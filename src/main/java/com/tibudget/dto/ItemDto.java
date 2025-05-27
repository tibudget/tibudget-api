package com.tibudget.dto;

import java.io.Serializable;
import java.net.URL;
import java.util.*;

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
     * Minimal and universal set of quantity units.
     * This enum is designed to support a wide range of products while remaining simple and standardized.
     */
    public enum QuantityUnit {

        /**
         * Countable items (e.g., 1 item, 3 apples, 10 tickets).
         */
        UNIT,

        /**
         * Mass in grams. All weight-based quantities should be converted to grams.
         */
        GRAM,

        /**
         * Volume in liters. All liquid or volumetric quantities should be converted to liters.
         */
        LITER,

        /**
         * Length in meters. Suitable for fabric, cables, etc.
         */
        METER,

        /**
         * Surface area in square meters (m²). Used for tiles, land, etc.
         */
        SQUARE_METER,

        /**
         * Volume in cubic meters (m³). Used for bulk goods like sand, wood, etc.
         */
        CUBIC_METER,

        /**
         * Time in hours. Useful for services or time-based usage (e.g., parking, rentals).
         */
        HOUR,

        /**
         * Fallback unit for unknown or custom measurements.
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
     * The brand of the product or the provider of the service
     */
    private String brand;

    /**
     * The total price of this item, meaning if there are 3 in quantity the price is for the 3 items
     */
    private double price;

    /**
     * Quantity of items
     */
    private double quantity;

    private QuantityUnit quantityUnit = QuantityUnit.UNIT;

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

    public ItemDto(String label, double price, double quantity, QuantityUnit quantityUnit) {
        this();
        this.label = label;
        this.price = price;
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setQuantity(double quantity, QuantityUnit quantityUnit) {
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
    }

    public QuantityUnit getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(QuantityUnit quantityUnit) {
        this.quantityUnit = quantityUnit;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ItemDto)) return false;
        ItemDto itemDto = (ItemDto) o;
        return Double.compare(price, itemDto.price) == 0 && Double.compare(quantity, itemDto.quantity) == 0 && Objects.equals(files, itemDto.files) && Objects.equals(label, itemDto.label) && quantityUnit == itemDto.quantityUnit && Objects.equals(references, itemDto.references) && Objects.equals(url, itemDto.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(files, label, price, quantity, quantityUnit, references, url);
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "label='" + label + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", quantityUnit=" + quantityUnit +
                '}';
    }
}
