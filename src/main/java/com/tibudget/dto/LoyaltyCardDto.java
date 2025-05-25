package com.tibudget.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * Data Transfer Object representing a loyalty card.
 */
public class LoyaltyCardDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int ISSUER_MAX_LENGTH = 100;

    /**
     * Enum representing supported barcode types for loyalty cards.
     */
    public enum BarcodeType {
        EAN_13,
        EAN_8,
        UPC_A,
        UPC_E,
        CODE_39,
        CODE_93,
        CODE_128,
        ITF,
        CODABAR,
        QR_CODE,
        DATA_MATRIX,
        PDF_417,
        AZTEC;
    }

    /**
     * Barcode value (card number, QR code content, etc.)
     */
    private String reference;

    /**
     * Type of barcode (e.g., QR_CODE, EAN_13, CODE_128).
     */
    private BarcodeType barcodeType;

    /**
     * Name of the issuer or brand.
     */
    private String issuer;

    /**
     * Image of the card (optional)
     */
    private FileDto cover = null;

    public LoyaltyCardDto() {
        super();
    }

    public LoyaltyCardDto(String issuer, BarcodeType barcodeType, String reference) {
        this();
        this.issuer = issuer;
        this.reference = reference;
        this.barcodeType = barcodeType;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BarcodeType getBarcodeType() {
        return barcodeType;
    }

    public void setBarcodeType(BarcodeType barcodeType) {
        this.barcodeType = barcodeType;
    }

    public FileDto getCover() {
        return cover;
    }

    public void setCover(FileDto cover) {
        this.cover = cover;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LoyaltyCardDto)) return false;
        LoyaltyCardDto that = (LoyaltyCardDto) o;
        return Objects.equals(reference, that.reference) && barcodeType == that.barcodeType && Objects.equals(issuer, that.issuer) && Objects.equals(cover, that.cover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, barcodeType, issuer, cover);
    }

    @Override
    public String toString() {
        return "LoyaltyCardDto{" +
                "reference='" + reference + '\'' +
                ", barcodeType=" + barcodeType +
                ", issuer='" + issuer + '\'' +
                ", cover=" + cover +
                '}';
    }
}
