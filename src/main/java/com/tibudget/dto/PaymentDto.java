package com.tibudget.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Data Transfer Object representing a payment.
 *
 * <p>Collectors must populate payment fields consistently to allow Tibu
 * to identify payment methods, match counterparties, and recognize recurring payments.</p>
 *
 * <p>Field conventions depend on the payment type and provider.
 * In particular, SEPA direct debits must use the TRANSFER type with
 * providerName set to "SEPA". Do not introduce a separate payment type
 * for SEPA direct debits.</p>
 *
 * <p>Collectors must never generate, guess, or substitute payment identifiers.
 * If a reference is unavailable from the source, leave the corresponding
 * field null. Do not use payment labels, creditor names, or bank names
 * as substitutes for RUM, ICS, IBAN, or transaction references.</p>
 *
 * <p>Examples:</p>
 * <ul>
 *   <li>Card payment:
 *       type=CARD, providerName="VISA", reference="TXN-12345",
 *       paymentMethodReference="1234"</li>
 *   <li>SEPA direct debit:
 *       type=TRANSFER, providerName="SEPA", reference="MANDATE-12345" (RUM),
 *       paymentMethodReference="FR12ZZZ123456" (ICS)</li>
 *   <li>Bank transfer:
 *       type=TRANSFER, providerName=null, reference="TRF-12345",
 *       paymentMethodReference="FR7630006000011234567890189" (destination IBAN)</li>
 *   <li>Check:
 *       type=CHECK, providerName=null, reference=null,
 *       paymentMethodReference="0001234"</li>
 *   <li>Cash:
 *       type=CASH, providerName=null, reference=null,
 *       paymentMethodReference=null</li>
 * </ul>
 */
public class PaymentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Defines the payment method used for a transaction.
     *
     * <p>Important: SEPA direct debits must be classified as TRANSFER,
     * not as a separate payment type.</p>
     */
    public enum PaymentDtoType {
        /** Payment made using cash. */
        CASH,

        /** Payment made using a debit or credit card. */
        CARD,

        /** Payment made using a check. */
        CHECK,

        /**
         * Payment made through a bank account.
         * Includes standard bank transfers and SEPA direct debits.
         *
         * <p>For SEPA direct debits, set providerName to "SEPA".</p>
         */
        TRANSFER,

        /** Payment made using a gift card. */
        GIFT_CARD,

        /** Payment made using store credit or a refund balance. */
        STORE_CREDIT,

        /** Payment made using a digital wallet. */
        DIGITAL_WALLET
    }

    /**
     * The type of payment.
     */
    private PaymentDtoType type;

    /**
     * Provider or payment network associated with the payment method.
     *
     * <p>Use a standardized name whenever possible.</p>
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>CARD: "VISA", "MASTERCARD", "AMEX"</li>
     *   <li>TRANSFER (SEPA direct debit): "SEPA" (mandatory)</li>
     *   <li>TRANSFER (standard bank transfer): null unless a provider is known</li>
     *   <li>DIGITAL_WALLET: "PAYPAL", "GOOGLE_PAY", "APPLE_PAY"</li>
     *   <li>CASH, CHECK: null unless relevant</li>
     * </ul>
     *
     * <p>For SEPA direct debits, always use exactly "SEPA".
     * Do not use the creditor name, bank name, or variations such as
     * "SEPA_DD", "SDD", or "SEPA_DIRECT_DEBIT".</p>
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
     * Reference identifying the payment or its associated authorization.
     *
     * <p>The expected value depends on the payment method:</p>
     * <ul>
     *   <li>CARD: transaction reference or payment identifier</li>
     *   <li>TRANSFER (SEPA direct debit): Unique Mandate Reference (RUM)</li>
     *   <li>TRANSFER (standard bank transfer): transaction reference</li>
     *   <li>CHECK: transaction reference, if available</li>
     *   <li>Other types: transaction reference, if available</li>
     * </ul>
     *
     * <p>For SEPA direct debits, the RUM identifies the mandate rather
     * than an individual debit. Multiple payments may share the same RUM.</p>
     *
     * <p>Example: "MANDATE-12345".</p>
     *
     * <p>Do not confuse the RUM with the SEPA Creditor Identifier (ICS).
     * The ICS belongs in paymentMethodReference.</p>
     */
    private String reference;

    /**
     * Reference identifying the payment method or payment origin.
     *
     * <p>The expected value depends on the payment type and provider:</p>
     * <ul>
     *   <li>CARD: last 4 digits of the card number (e.g., "1234")</li>
     *   <li>TRANSFER (SEPA direct debit): SEPA Creditor Identifier (ICS),
     *       e.g., "FR12ZZZ123456"</li>
     *   <li>TRANSFER (standard bank transfer): destination IBAN,
     *       e.g., "FR7630006000011234567890189"</li>
     *   <li>CHECK: check number (e.g., "0001234")</li>
     *   <li>CASH, GIFT_CARD, STORE_CREDIT: null</li>
     * </ul>
     *
     * <p>For SEPA direct debits:</p>
     * <ul>
     *   <li>providerName must be "SEPA"</li>
     *   <li>reference must contain the RUM</li>
     *   <li>paymentMethodReference must contain the ICS</li>
     * </ul>
     *
     * <p>The combination of ICS and RUM identifies a SEPA mandate.
     * An ICS alone identifies a creditor, not an individual establishment.</p>
     *
     * <p>Never store a full card number in this field.</p>
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
