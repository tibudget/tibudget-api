package com.tibudget.dto;

import java.io.Serializable;
import java.util.*;

/**
 * Data Transfer Object representing a financial operation.
 * It contains essential information about an operation, such as its type, amount, dates, and associated metadata.
 */
public class OperationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Represents the type of a financial operation, which is essential for linking related operations.
     */
    public enum OperationDtoType {
        /**
         * A purchase transaction, representing a payment made at a store (either online or physical).
         * This type of operation is always linked to a {@link #PAYMENT} operation.
         */
        PURCHASE,

        /**
         * A payment transaction, representing a withdrawal from a bank account.
         * This type of operation is always linked to a {@link #PURCHASE} operation.
         */
        PAYMENT,

        /**
         * A money transfer between accounts. This type of operation is always linked to another {@link #TRANSFER}
         * operation.
         */
        TRANSFER,

        /**
         * An internal operation applied by the account provider, such as bank fees, interest, or other adjustments.
         * This type of operation is never linked to any other operation.
         */
        INTERNAL,
    }

    /** Common metadata keys : IBAN of the destinataire of a transfert */
    public static final String METADATA_DEST_IBAN = "DEST_IBAN";
    /** Common metadata keys : Reference of this operation (transaction ID for exemple) */
    public static final String METADATA_REFERENCE = "REFERENCE";
    /** Common metadata keys : Comma separated list of categories */
    public static final String METADATA_CATEGORIES = "CATEGORIES";

    private String accountUuid;
    private OperationDtoType type;
    private final Map<String, String> metadatas;
    private double amount;
    private String currencyCode;
    private Date dateValue;
    private Date dateOperation;
    private String label;
    private String details;
    private final List<PaymentDto> payments;
    private final List<FileDto> files;
    private final List<ItemDto> items;

    /**
     * Default constructor initializing lists and metadata map.
     */
    public OperationDto() {
        this.metadatas = new HashMap<>();
        this.files = new ArrayList<>();
        this.items = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    /**
     * Constructs an OperationDto with mandatory details.
     *
     * @param accountUuid   UUID of the account for this operation.
     * @param type          Type of operation.
     * @param dateOperation Operation date (when the bank processes the operation).
     * @param dateValue     Value date (when the user performed the operation).
     * @param label         Label of the operation.
     * @param details       Details of the operation.
     * @param amount        Amount of the operation.
     */
    public OperationDto(String accountUuid, OperationDtoType type, Date dateOperation, Date dateValue,
                        String label, String details, double amount) {
        this();
        this.accountUuid = accountUuid;
        this.dateOperation = dateOperation;
        this.dateValue = dateValue;
        this.details = details;
        this.label = label;
        this.type = type;
        this.amount = amount;
    }

    public String getAccountUuid() { return accountUuid; }
    public void setAccountUuid(String accountUuid) { this.accountUuid = accountUuid; }

    public Date getDateOperation() { return dateOperation; }
    public void setDateOperation(Date dateOperation) { this.dateOperation = dateOperation; }

    public Date getDateValue() { return dateValue; }
    public void setDateValue(Date dateValue) { this.dateValue = dateValue; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public OperationDtoType getType() { return type; }
    public void setType(OperationDtoType type) { this.type = type; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }

    /**
     * Returns an unmodifiable list of payments linked to this operation.
     *
     * @return List of payments.
     */
    public List<PaymentDto> getPayments() { return Collections.unmodifiableList(payments); }
    public void addPayment(PaymentDto payment) { this.payments.add(payment); }

    /**
     * Returns an unmodifiable list of files linked to this operation.
     *
     * @return List of files.
     */
    public List<FileDto> getFiles() { return Collections.unmodifiableList(files); }
    public void addFile(FileDto file) { this.files.add(file); }

    /**
     * Returns an unmodifiable list of items linked to this operation.
     *
     * @return List of items.
     */
    public List<ItemDto> getItems() { return Collections.unmodifiableList(items); }
    public void addItem(ItemDto item) { this.items.add(item); }

    /**
     * Returns the metadata map.
     *
     * @return Map of metadata key-value pairs.
     */
    public Map<String, String> getMetadatas() { return Collections.unmodifiableMap(metadatas); }

    /**
     * Retrieves a specific metadata value by key.
     *
     * @param key The metadata key.
     * @return The associated metadata value, or null if not found.
     */
    public String getMetadata(String key) { return metadatas.get(key); }

    /**
     * Sets a metadata key-value pair.
     *
     * @param key   The metadata key.
     * @param data  The metadata value. Set to null to delete the metadata.
     */
    public void setMetadata(String key, String data) {
        if (key != null) {
            if (data != null) {
                this.metadatas.put(key, data);
            }
            else {
                this.metadatas.remove(key);
            }
        }
    }
}
