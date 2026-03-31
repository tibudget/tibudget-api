package com.tibudget.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Data Transfer Object representing a payment.
 * It contains details such as the payment type, amount, currency, references, and payment method metadata.
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
        DIGITAL_WALLET
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
     * The reference of the payment (transaction ID, for example).
     */
    private String reference;

    /**
     * The reference of the payment method used for this payment.
     * <ul>
     * <li>CARD: expected to be the last 4 digits of the card</li>
     * <li>TRANSFER: expected to be the destination IBAN</li>
     * <li>CHECK: expected to be the check number</li>
     * <li>CASH, GIFT_CARD, STORE_CREDIT: leave empty</li>
     * </ul>
     */
    private String paymentMethodReference;

    /**
     * Creates an empty payment DTO.
     */
    public PaymentDto() {
        super();
    }

    /**
     * Creates a payment DTO with all fields initialized.
     *
     * @param type                    the payment type
     * @param providerName            the payment method provider name
     * @param paymentDate             the date when the payment was made
     * @param amount                  the payment amount
     * @param currencyCode            the ISO 4217 currency code
     * @param reference               the payment reference
     * @param paymentMethodReference   the payment method reference
     */
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
    public boolean equals(Object o) {
        if (!(o instanceof PaymentDto)) return false;
        PaymentDto that = (PaymentDto) o;
        return Double.compare(amount, that.amount) == 0 && type == that.type && Objects.equals(providerName, that.providerName) && Objects.equals(paymentDate, that.paymentDate) && Objects.equals(currencyCode, that.currencyCode) && Objects.equals(reference, that.reference) && Objects.equals(paymentMethodReference, that.paymentMethodReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, providerName, paymentDate, amount, currencyCode, reference, paymentMethodReference);
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
