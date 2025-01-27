package com.tibudget.dto;

import java.io.Serializable;
import java.util.Date;

public class OperationDto implements Serializable {

    public enum OperationDtoType {
        /**
         * when no other type is pertinent
         */
        OTHER,
        /**
         * cash payment or ATM withdraw
         */
        CASH,
        /**
         * account to account transfert
         */
        TRANSFERT,
        /**
         * Debit card payment
         */
        DEBIT_CARD,
        /**
         * Credit card payment
         */
        CREDIT_CARD,
        /**
         * Check payment
         */
        CHECK,
        /**
         * Bank cost
         */
        BANK
    }

    private String accountUuid;

    private OperationDtoType type;

    /**
     * ID used by the collector to identify the operation
     */
    private String idForCollector;

    private Double value;

    private Date dateValue;

    private Date dateOperation;

    private String label;

    private String details;

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
