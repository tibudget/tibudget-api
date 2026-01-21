package com.tibudget.api;

/**
 * Enumerates the barcode formats supported for loyalty cards.
 * <p>
 * Each barcode type represents a standardized encoding format,
 * commonly used to identify products, cards, or digital payloads.
 * Support and decoding capabilities may vary depending on the scanner
 * or device implementation.
 */
public enum BarcodeTypeEnum {

    /**
     * European Article Number with 13 digits.
     * Widely used for retail products worldwide.
     */
    EAN_13,

    /**
     * Shortened version of EAN-13 with 8 digits.
     * Used for small packages with limited printing space.
     */
    EAN_8,

    /**
     * Universal Product Code with 12 digits.
     * Commonly used in North America for retail products.
     */
    UPC_A,

    /**
     * Compressed version of UPC-A.
     * Designed for small packages.
     */
    UPC_E,

    /**
     * Alphanumeric linear barcode.
     * Often used in logistics, inventory, and industrial applications.
     */
    CODE_39,

    /**
     * Compact alphanumeric barcode.
     * Provides higher density than Code 39.
     */
    CODE_93,

    /**
     * High-density alphanumeric barcode.
     * Widely used in logistics, shipping, and labeling.
     */
    CODE_128,

    /**
     * Interleaved Two of Five numeric barcode.
     * Common in warehousing and distribution.
     */
    ITF,

    /**
     * Discrete numeric barcode.
     * Often used in libraries, blood banks, and logistics.
     */
    CODABAR,

    /**
     * Two-dimensional matrix barcode.
     * Can store large amounts of data and supports error correction.
     */
    QR_CODE,

    /**
     * Two-dimensional barcode with high data density.
     * Frequently used in industrial and medical contexts.
     */
    DATA_MATRIX,

    /**
     * Stacked linear barcode.
     * Commonly used for transport, tickets, and identity documents.
     */
    PDF_417,

    /**
     * Two-dimensional barcode optimized for small sizes.
     * Supports robust error correction and compact encoding.
     */
    AZTEC;
}
