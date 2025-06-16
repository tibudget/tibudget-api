package com.tibudget.dto;

import java.io.Serializable;
import java.util.*;

/**
 * Data Transfer Object representing a financial transaction.
 * It contains essential information about an transaction, such as its type, amount, dates, and associated metadata.
 */
public class TransactionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int LABEL_MAX_LENGTH = 100;
    public static final int DETAILS_MAX_LENGTH = 1000;

    /**
     * Represents the type of a financial transaction, which is essential for linking related transactions.
     */
    public enum TransactionDtoType {
        /**
         * A purchase transaction, representing a payment made at a store (either online or physical).
         * This type of transaction is always linked to a {@link #PAYMENT} transaction.
         */
        PURCHASE,

        /**
         * A payment transaction, representing a withdrawal from a bank account.
         * This type of transaction is always linked to a {@link #PURCHASE} transaction.
         */
        PAYMENT,

        /**
         * A money transfer between accounts. This type of transaction is always linked to another {@link #TRANSFER}
         * transaction.
         */
        TRANSFER,

        /**
         * An internal transaction applied by the account provider, such as bank fees, interest, or other adjustments.
         * This type of transaction is never linked to any other transaction.
         */
        INTERNAL,
    }

    /** Common metadata keys : Reference of this transaction (transaction ID for exemple) */
    public static final String METADATA_REFERENCE = "REFERENCE";
    /** Common metadata keys : IBAN of the counterparty if available */
    public static final String METADATA_COUNTERPARTY_IBAN = "COUNTERPARTY_IBAN";
    /** Common metadata keys : if available and applicable, provide the merchant or other counterparty name */
    public static final String METADATA_COUNTERPARTY_NAME = "COUNTERPARTY_NAME";
    /** Common metadata keys : if available and applicable, provide the merchant or other counterparty  website */
    public static final String METADATA_COUNTERPARTY_WEBSITE = "COUNTERPARTY_WEBSITE";
    /** Common metadata keys : if available and applicable, provide the check number */
    public static final String METADATA_CHECK_NUMBER = "CHECK_NUMBER";

    /**
     * Unique identifier for this transaction within the associated account.
     * This ID is used as a key for subsequent transaction updates.
     */
    private String id;

    /**
     * Represents the unique identifier (UUID) for the account associated
     * with the transaction.
     */
    private String accountUuid;
    private TransactionDtoType type;
    private final Map<String, String> metadatas;

    /**
     * Optional UUID of the counterparty (e.g. Paypal, Amazon, etc.)
     * You can find it with the CounterpartyProvider if you have enough informations to find it.
     */
    private String counterPartyUuid;

    /**
     * The amount of a transaction should be negative for PURCHASE or PAYMENT transactions,
     * except in the case of a refund.
     * This ensures that amounts are displayed from the user's perspective:
     * negative values represent expenses, while positive values indicate credits.
     */
    private double amount;

    /**
     * Currency code ISO 4217
     */
    private String currencyCode;

    /**
     * Date time when the transaction has been executed
     */
    private Date dateValue;

    /**
     * Date time when the transaction has been authorized (date of the payment)
     */
    private Date dateTransaction;

    /**
     * Limited to {@link #LABEL_MAX_LENGTH} characters. It will be truncated, so it's better if you handle this length on your side.
     */
    private String label;

    /**
     * Limited to {@link #DETAILS_MAX_LENGTH} characters. It will be truncated, so it's better if you handle this length on your side.
     */
    private String details;

    /**
     * Where this transaction was done (physical place or internet)
     */
    private LocationInfosDto locationInfos;

    private final List<PaymentDto> payments;
    private final List<FileDto> files;
    private final List<ItemDto> items;

    /**
     * Default constructor initializing lists and metadata map.
     */
    public TransactionDto() {
        this.metadatas = new HashMap<>();
        this.files = new ArrayList<>();
        this.items = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    /**
     * Constructs a TransactionDto with mandatory details.
     *
     * @param id              ID of the transaction, it must be unique for this transaction within the associated account
     * @param accountUuid     UUID of the account associated to this transaction.
     * @param type            Type of transaction.
     * @param dateTransaction Transaction date (when the user performed the transaction).
     * @param dateValue       Value date (when the bank processes the transaction).
     * @param label           Label of the transaction.
     * @param details         Details of the transaction.
     * @param amount          Amount of the transaction.
     */
    public TransactionDto(String id, String accountUuid, TransactionDtoType type, Date dateTransaction, Date dateValue,
                          String label, String details, double amount) {
        this();
        this.id = id;
        this.accountUuid = accountUuid;
        this.dateTransaction = dateTransaction;
        this.dateValue = dateValue;
        this.details = details;
        this.label = label;
        this.type = type;
        this.amount = amount;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAccountUuid() { return accountUuid; }
    public void setAccountUuid(String accountUuid) { this.accountUuid = accountUuid; }

    public Date getDateTransaction() { return dateTransaction; }
    public void setDateTransaction(Date dateTransaction) { this.dateTransaction = dateTransaction; }

    public Date getDateValue() { return dateValue; }
    public void setDateValue(Date dateValue) { this.dateValue = dateValue; }

    public String getDetails() { return details; }

    /**
     * @param details Limited to {@link #DETAILS_MAX_LENGTH} characters. It will be truncated, so it's better if you handle this length on your side.
     */
    public void setDetails(String details) { this.details = details; }

    public String getLabel() { return label; }

    /**
     * @param label Limited to {@link #LABEL_MAX_LENGTH} characters. It will be truncated, so it's better if you handle this length on your side.
     */
    public void setLabel(String label) { this.label = label; }

    public TransactionDtoType getType() { return type; }
    public void setType(TransactionDtoType type) { this.type = type; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }

    public String getCounterPartyUuid() {
        return counterPartyUuid;
    }

    public void setCounterPartyUuid(String counterPartyUuid) {
        this.counterPartyUuid = counterPartyUuid;
    }

    /**
     * Returns an unmodifiable list of payments linked to this transaction.
     *
     * @return List of payments.
     */
    public List<PaymentDto> getPayments() { return Collections.unmodifiableList(payments); }
    public void addPayment(PaymentDto payment) { this.payments.add(payment); }
    public void addPayments(List<PaymentDto> payments) { this.payments.addAll(payments); }

    /**
     * Returns an unmodifiable list of files linked to this transaction.
     *
     * @return List of files.
     */
    public List<FileDto> getFiles() { return Collections.unmodifiableList(files); }
    public void addFile(FileDto file) { this.files.add(file); }

    /**
     * Returns an unmodifiable list of items linked to this transaction.
     *
     * @return List of items.
     */
    public List<ItemDto> getItems() { return Collections.unmodifiableList(items); }
    public void addItem(ItemDto item) { this.items.add(item); }
    public void addItems(List<ItemDto> items) { this.items.addAll(items); }

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

    public LocationInfosDto getLocationInfos() {
        return locationInfos;
    }

    public void setLocationInfos(LocationInfosDto locationInfos) {
        this.locationInfos = locationInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TransactionDto)) return false;
        TransactionDto that = (TransactionDto) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(id, that.id) && Objects.equals(accountUuid, that.accountUuid) && type == that.type && Objects.equals(metadatas, that.metadatas) && Objects.equals(currencyCode, that.currencyCode) && Objects.equals(dateValue, that.dateValue) && Objects.equals(dateTransaction, that.dateTransaction) && Objects.equals(label, that.label) && Objects.equals(details, that.details) && Objects.equals(locationInfos, that.locationInfos) && Objects.equals(payments, that.payments) && Objects.equals(files, that.files) && Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountUuid, type, metadatas, amount, currencyCode, dateValue, dateTransaction, label, details, locationInfos, payments, files, items);
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id='" + id + '\'' +
                ", accountUuid='" + accountUuid + '\'' +
                ", type=" + type +
                ", counterPartyUuid='" + counterPartyUuid + '\'' +
                ", metadatas=" + metadatas +
                ", amount=" + amount +
                ", currencyCode='" + currencyCode + '\'' +
                ", dateValue=" + dateValue +
                ", dateTransaction=" + dateTransaction +
                ", label='" + label + '\'' +
                ", details='" + details + '\'' +
                ", locationInfos=" + locationInfos +
                ", payments=" + payments +
                ", files=" + files +
                ", items=" + items +
                '}';
    }
}