package com.tibudget.dto;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class EqualityContractTest {
    // Call equals directly for reflexivity and null: assertEquals may short-circuit
    // identical references, and assertNotEquals(null, value) does not call value.equals(null).
    @SuppressWarnings({"SimplifiableAssertion", "EqualsWithItself", "ConstantValue"})
    private static void assertEquivalent(Object a, Object b, Object c) {
        assertTrue(a.equals(a));
        assertFalse(a.equals(null));
        assertNotEquals(new Object(), a);
        assertEquals(a, b);
        assertEquals(b, a);
        assertEquals(b, c);
        assertEquals(a, c);
        assertEquals(a.hashCode(), b.hashCode());
        assertEquals(b.hashCode(), c.hashCode());
        assertEquals(1, new HashSet<>(Arrays.asList(a, b, c)).size());
        HashMap<Object, String> map = new HashMap<>();
        map.put(a, "found");
        assertEquals("found", map.get(b));
    }

    @Test
    public void valueDtosRespectEqualityContract() {
        assertEquivalent(new PaymentDto(), new PaymentDto(), new PaymentDto());
        assertEquivalent(new PaymentMethodDto(), new PaymentMethodDto(), new PaymentMethodDto());
        assertEquivalent(new LocationInfosDto(), new LocationInfosDto(), new LocationInfosDto());
        assertEquivalent(new ItemDto(), new ItemDto(), new ItemDto());
        assertEquivalent(new FileDto(), new FileDto(), new FileDto());
        assertEquivalent(new TransactionDto(), new TransactionDto(), new TransactionDto());
        assertEquivalent(new MessagesDto(), new MessagesDto(), new MessagesDto());
    }

    @Test
    @SuppressWarnings({"SimplifiableAssertion", "EqualsWithItself", "ConstantValue"})
    public void unidentifiedEntitiesRemainDistinct() {
        List<Object> entities = Arrays.asList(new AccountDto(), new RecurringPaymentDto());
        for (Object entity : entities) {
            assertTrue(entity.equals(entity));
            assertFalse(entity.equals(null));
        }
        assertEquals(2, new HashSet<>(Arrays.asList(new AccountDto(), new AccountDto())).size());
        assertEquals(2, new HashSet<>(Arrays.asList(new RecurringPaymentDto(), new RecurringPaymentDto())).size());
    }

    @Test
    public void entitiesCompareByUuidOnly() {
        AccountDto a = new AccountDto();
        AccountDto b = new AccountDto();
        AccountDto c = new AccountDto();
        a.setUuid("account");
        b.setUuid("account");
        c.setUuid("account");
        b.setLabel("Different label");
        assertEquivalent(a, b, c);
        assertNotEquals(new AccountDto(), a);
        assertNotEquals(new AccountDto(), a);
        c.setUuid("other");
        assertNotEquals(a, c);

        RecurringPaymentDto r = new RecurringPaymentDto("1", "recurring", "account");
        RecurringPaymentDto s = new RecurringPaymentDto("2", "recurring", "account");
        RecurringPaymentDto t = new RecurringPaymentDto("3", "recurring", "account");
        s.setDetails("Different details");
        assertEquivalent(r, s, t);
        assertNotEquals(new RecurringPaymentDto(), r);
        assertNotEquals(new RecurringPaymentDto(), r);
        t.setUuid("other");
        assertNotEquals(r, t);
        RecurringPaymentDto subclass = new RecurringPaymentDto("1", "recurring", "account") { };
        assertNotEquals(r, subclass);
        assertNotEquals(subclass, r);
    }

    private MessageDto nestedMessage() {
        return new MessageDto(MessageDto.MessageType.ERROR, "field", "key",
                new Object[]{new int[]{1, 2}, new Object[]{new String[]{"nested"}}});
    }

    @Test
    public void nestedMessageArgumentsHaveConsistentHashes() {
        assertEquivalent(nestedMessage(), nestedMessage(), nestedMessage());
        assertEquivalent(new MessagesDto(List.of(nestedMessage())),
                new MessagesDto(List.of(nestedMessage())),
                new MessagesDto(List.of(nestedMessage())));
        assertEquivalent(new MessageDto("key", (Object[]) null),
                new MessageDto("key", (Object[]) null), new MessageDto("key", (Object[]) null));
    }

    @Test
    public void itemBrandParticipatesInEquality() {
        ItemDto a = new ItemDto();
        ItemDto b = new ItemDto();
        a.setBrand("A");
        b.setBrand("B");
        assertNotEquals(a, b);
        assertEquals(2, new HashSet<>(Arrays.asList(a, b)).size());
        b.setBrand("A");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    private FileDto attachment() {
        return new FileDto(FileDto.FileDtoType.CONTRACT, "Contract", "application/pdf", new File("contract.pdf"));
    }

    @Test
    public void attachmentsCompareByMetadataAndPathWithoutReadingFiles() {
        FileDto a = attachment();
        FileDto b = attachment();
        assertEquivalent(a, b, attachment());
        b.setLabel("Other");
        assertNotEquals(a, b);
        b = attachment();
        b.setType(FileDto.FileDtoType.OTHER);
        assertNotEquals(a, b);
        b = attachment();
        b.setContentType("text/plain");
        assertNotEquals(a, b);
        b = attachment();
        b.setFile(new File("other.pdf"));
        assertNotEquals(a, b);
    }

    @Test
    public void nestedAttachmentsCompareByValueInTransactionsAndItems() {
        TransactionDto a = new TransactionDto();
        TransactionDto b = new TransactionDto();
        a.addFile(attachment());
        b.addFile(attachment());
        ItemDto i = new ItemDto();
        ItemDto j = new ItemDto();
        i.addFile(attachment());
        j.addFile(attachment());
        a.addItem(i);
        b.addItem(j);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        j.setBrand("Changed");
        assertNotEquals(a, b);
    }
}
