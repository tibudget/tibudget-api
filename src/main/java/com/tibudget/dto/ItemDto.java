package com.tibudget.dto;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description of an item. This is used in PURCHASE operation.
 */
public class ItemDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Enum representing global product reference types.
     */
    public enum ProductReferenceType {
        /**
         * Global Trade Item Number (GTIN), including EAN, UPC, and ITF-14.
         */
        GTIN,

        /**
         * European Article Number (EAN), used in Europe and internationally.
         */
        EAN,

        /**
         * Universal Product Code (UPC), used mainly in the USA and Canada.
         */
        UPC,

        /**
         * International Standard Book Number (ISBN), used for books.
         */
        ISBN,

        /**
         * Amazon Standard Identification Number (ASIN), used exclusively on Amazon.
         */
        ASIN,

        /**
         * Stock Keeping Unit (SKU), an internal identifier used by retailers to track inventory.
         * SKUs are specific to each store or business and are not globally standardized.
         */
        SKU,

        /**
         * For any other reference type
         */
        OTHER
    }

    /**
     * You should at least add an image to illustrate the product. You can also add contract or other related files for
     * this item.
     */
    private final List<FileDto> files;

    /**
     * The label of this item
     */
    private String label;

    /**
     * The total price of this item, meaning if there are 3 in quantity the price is for the 3 items
     */
    private double price;

    /**
     * Quantity of items
     */
    private int quantity;

    /**
     * References of the item, try to add at least one reference
     */
    private final Map<ProductReferenceType, String> references;

    /**
     * URL of the product page if any
     */
    private URL url;

    public ItemDto() {
        files = new ArrayList<>();
        references = new HashMap<>();
    }

    public ItemDto(String label, double price, int quantity) {
        this();
        this.label = label;
        this.price = price;
        this.quantity = quantity;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public List<FileDto> getFiles() {
        return files;
    }

    public void addFile(FileDto file) {
        files.add(file);
    }

    public Map<ProductReferenceType, String> getReferences() {
        return references;
    }

    public void setReference(ProductReferenceType type, String reference) {
        this.references.put(type, reference);
    }
}
