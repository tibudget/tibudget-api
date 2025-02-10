package com.tibudget.dto;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OperationDto implements Serializable {

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


    private String accountUuid;

    private OperationDtoType type;

    /**
     * ID used by the collector to identify the operation
     */
    private String idForCollector;

    private double value;

    private Date dateValue;

    private Date dateOperation;

    private String label;

    private String details;

    /**
     * When type is PURCHASE you should add paiements informations so the operation can be linked to other related
     * operations.
     */
    private List<PaymentDto> paiments;

    /**
     * When type is PURCHASE you should add the invoice. You can also add contract or other related files.
     */
    private List<FileDto> files;

    /**
     * When type is PURCHASE you should list the products that have been bought
     */
    private List<ItemDto> items;

    /**
     * @param accountUuid    UUID of the account for this operation
     * @param idForCollector ID used by the collector to identify the operation, if possible, use a unique identifier also used by the provider (bank)
     * @param type           Type of operation
     * @param dateValue      Value date (when the user did the operation)
     * @param dateOperation  Operation date (when the bank operate the operation)
     * @param label          Label of operation
     * @param details        Details of the operation
     * @param value          Amount of the operation
     */
    public OperationDto(
            String accountUuid,
            String idForCollector,
            OperationDtoType type,
            Date dateOperation,
            Date dateValue,
            String label,
            String details,
            Double value
    ) {
        this.accountUuid = accountUuid;
        this.dateOperation = dateOperation;
        this.dateValue = dateValue;
        this.details = details;
        this.idForCollector = idForCollector;
        this.label = label;
        this.type = type;
        this.value = value;
    }

    public String getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getIdForCollector() {
        return idForCollector;
    }

    public void setIdForCollector(String idForCollector) {
        this.idForCollector = idForCollector;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public OperationDtoType getType() {
        return type;
    }

    public void setType(OperationDtoType type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
