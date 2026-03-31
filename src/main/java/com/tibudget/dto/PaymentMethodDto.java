package com.tibudget.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * Data Transfer Object representing a payment method.
 * It contains the payment type and, when relevant, a payment method reference.
 */
public class PaymentMethodDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The type of payment.
     */
    private PaymentDto.PaymentDtoType type;

    /**
     * The reference of the payment method used for this payment.
     * <ul>
     * <li>CARD: expected to be the last 4 digits of the card</li>
     * <li>TRANSFER, CHECK, CASH, GIFT_CARD, STORE_CREDIT: leave empty</li>
     * </ul>
     */
    private String reference;

    /**
     * Creates an empty payment method DTO.
     */
    public PaymentMethodDto() {
        super();
    }

    /**
     * Creates a payment method DTO.
     *
     * @param type the payment type
     * @param reference the payment method reference
     */
    public PaymentMethodDto(PaymentDto.PaymentDtoType type, String reference) {
        this();
        this.type = type;
        this.reference = reference;
    }

    /**
     * Creates a payment method DTO without a reference.
     *
     * @param type the payment type
     */
    public PaymentMethodDto(PaymentDto.PaymentDtoType type) {
        this(type, null);
    }

    /**
     * Returns the payment type.
     *
     * @return the payment type
     */
    public PaymentDto.PaymentDtoType getType() {
        return type;
    }

    /**
     * Sets the payment type.
     *
     * @param type the payment type
     */
    public void setType(PaymentDto.PaymentDtoType type) {
        this.type = type;
    }

    /**
     * Returns the payment method reference.
     *
     * @return the payment method reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the payment method reference.
     *
     * @param reference the payment method reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PaymentMethodDto)) return false;
        PaymentMethodDto that = (PaymentMethodDto) o;
        return type == that.type && Objects.equals(reference, that.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, reference);
    }

    @Override
    public String toString() {
        return "PaymentMethodDto{" +
                "type=" + type +
                ", reference='" + reference + '\'' +
                '}';
    }
}
