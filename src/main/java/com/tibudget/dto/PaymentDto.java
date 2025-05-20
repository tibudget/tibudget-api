package com.tibudget.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a payment transaction with details such as type, amount, currency, and references.
 */
public class PaymentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Defines the type of a payment method, determining how a transaction is processed.
     */
    public enum PaymentDtoType {
        /**
         * Payment made using cash.
         */
        CASH,

        /**
         * Payment made using a debit or credit card.
         */
        CARD,

        /**
         * Payment made using a check.
         */
        CHECK,

        /**
         * Payment made via bank transfer.
         */
        TRANSFER,

        /**
         * Payment made using a gift card.
         */
        GIFT_CARD,

        /**
         * Payment made using store credit or a refund balance.
         */
        STORE_CREDIT,

        /**
         * Payment made using a digital wallet (e.g., Google Pay, Apple Pay, PayPal, Samsung Pay).
         */
        DIGITAL_WALLET,

        /**
         * Discount applied to the invoice
         */
        DISCOUNT,
    }

    /**
     * The type of payment.
     */
    private PaymentDtoType type;

    /**
     * Provider of the payment method, e.g. Mastercard, Visa, etc.
     */
    private String providerName;

    /**
     * The date when the payment was made.
     */
    private Date paymentDate;

    /**
     * The amount of the payment.
     */
    private double amount;

    /**
     * The currency code in ISO 4217 format (e.g., "USD", "EUR").
     */
    private String currencyCode;

    /**
     * The reference of the payment (ID of the transaction for exemple).
     */
    private String reference;

    /**
     * The reference payment method used for this payment.
     * <li>CARD: we expect the last 4 digits of the card</li>
     * <li>TRANSFERT: we expect the IBAN of the destinataire</li>
     * <li>CHECK: the number of the check</li>
     * <li>CASH, GIFT_CARD, STORE_CREDIT: let empty</li>
     */
    private String paymentMethodReference;

    public PaymentDto() {
        super();
    }

    public PaymentDto(PaymentDtoType type, String providerName, Date paymentDate, double amount, String currencyCode, String reference, String paymentMethodReference) {
        this();
        this.type = type;
        this.providerName = providerName;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.reference = reference;
        this.paymentMethodReference = paymentMethodReference;
    }

    public PaymentDtoType getType() {
        return type;
    }

    public void setType(PaymentDtoType type) {
        this.type = type;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPaymentMethodReference() {
        return paymentMethodReference;
    }

    public void setPaymentMethodReference(String paymentMethodReference) {
        this.paymentMethodReference = paymentMethodReference;
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "type=" + type +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                ", currencyCode='" + currencyCode + '\'' +
                ", reference='" + reference + '\'' +
                ", paymentMethodReference='" + paymentMethodReference + '\'' +
                ", providerName='" + providerName + '\'' +
                '}';
    }
}
