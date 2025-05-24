package com.tibudget.dto;

import java.io.Serializable;

public class PaymentMethodDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The type of payment.
     */
    private PaymentDto.PaymentDtoType type;

    /**
     * The reference payment method used for this payment.
     * <li>CARD: we expect the last 4 digits of the card</li>
     * <li>TRANSFERT, CHECK, CASH, GIFT_CARD, STORE_CREDIT: let empty</li>
     */
    private String reference;

    public PaymentMethodDto() {
        super();
    }

    public PaymentMethodDto(PaymentDto.PaymentDtoType type, String reference) {
        this();
        this.type = type;
        this.reference = reference;
    }

    public PaymentMethodDto(PaymentDto.PaymentDtoType type) {
        this(type, null);
    }

    public PaymentDto.PaymentDtoType getType() {
        return type;
    }
    public void setType(PaymentDto.PaymentDtoType type) {
        this.type = type;
    }

    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "PaymentMethodDto{" +
                "type=" + type +
                ", reference='" + reference + '\'' +
                '}';
    }
}
