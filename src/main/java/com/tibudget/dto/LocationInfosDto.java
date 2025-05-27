package com.tibudget.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a generic, international location for an event such as a purchase.
 * <p>
 * This DTO is designed to store both structured and unstructured location data,
 * including coordinates, postal address, and optional metadata from external services.
 * <p>
 * Example use cases:
 * - Representing the merchant location for a transaction.
 * - Geolocating a store or online vendor.
 * - Linking to external location identifiers (Google Maps, TripAdvisor, etc.).
 */
public class LocationInfosDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Optional label to display for the location, such as the store or venue name.
     * Example: "Starbucks Wangfujing"
     */
    private String label;

    /**
     * Full free-text address in international format.
     * Example: "中国北京市东城区王府井大街88号"
     */
    private String address;

    /**
     * City name (optional but useful for filtering).
     * Example: "Beijing" or "北京"
     */
    private String city;

    /**
     * Country code in ISO 3166-1 alpha-2 format.
     * Examples: "FR" for France, "US" for United States, "CN" for China.
     */
    private String countryCode;

    /**
     * Geographic latitude of the location.
     * Example: 39.9087
     */
    private Double latitude;

    /**
     * Geographic longitude of the location.
     * Example: 116.3975
     */
    private Double longitude;

    /**
     * Optional website URL for the location or venue.
     * Example: "https://www.starbucks.com.cn/"
     */
    private String websiteUrl;

    /**
     * Optional metadata for third-party service integration.
     * Common keys: "google_maps", "tripadvisor", "baidu_maps", etc.
     * Values are external location identifiers (e.g., Place ID).
     */
    private Map<String, String> metadatas;

    // Constructors, getters, setters...

    public LocationInfosDto() {
        this.metadatas = new HashMap<>();
    }

    public LocationInfosDto(String label, String address, String city, String countryCode) {
        this();
        this.label = label;
        this.address = address;
        this.city = city;
        this.countryCode = countryCode;
    }

    public LocationInfosDto(String label, Double latitude, Double longitude) {
        this();
        this.label = label;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocationInfosDto(String label, String websiteUrl) {
        this();
        this.label = label;
        this.websiteUrl = websiteUrl;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public Map<String, String> getMetadatas() {
        return Collections.unmodifiableMap(metadatas);
    }

    /**
     * Retrieves a specific metadata value by key.
     *
     * @param key The metadata key.
     * @return The associated metadata value, or null if not found.
     */
    public String getMetadata(String key) { return metadatas.get(key); }

    /**
     * Sets a metadata key-value pair.
     *
     * @param key   The metadata key.
     * @param data  The metadata value. Set to null to delete the metadata.
     */
    public void setMetadata(String key, String data) {
        if (key != null) {
            if (data != null) {
                this.metadatas.put(key, data);
            }
            else {
                this.metadatas.remove(key);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LocationInfosDto)) return false;
        LocationInfosDto that = (LocationInfosDto) o;
        return Objects.equals(label, that.label) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(countryCode, that.countryCode) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude) && Objects.equals(websiteUrl, that.websiteUrl) && Objects.equals(metadatas, that.metadatas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, address, city, countryCode, latitude, longitude, websiteUrl, metadatas);
    }

    @Override
    public String toString() {
        return "LocationInfosDto{" +
                "label='" + label + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", metadatas=" + metadatas +
                '}';
    }
}

