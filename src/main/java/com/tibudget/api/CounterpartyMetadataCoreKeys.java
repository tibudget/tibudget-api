package com.tibudget.api;

/**
 * Defines the built-in metadata keys supported by Tibu for counterparties.
 * <p>
 * These metadata keys are considered core and are guaranteed to be
 * recognized and supported by the Tibu platform.
 * <p>
 * Each metadata key defines:
 * <ul>
 *     <li>a unique string identifier</li>
 *     <li>a functional description</li>
 *     <li>whether the value is numeric or textual</li>
 *     <li>whether the value must be unique across all counterparties</li>
 * </ul>
 * <p>
 * Custom metadata keys are not listed here and must be submitted for validation
 * through the Tibu professional dashboard before production use.
 */
public enum CounterpartyMetadataCoreKeys {

    /* ==============================
     * Identity / naming
     * ============================== */

    /**
     * Display name of the counterparty.
     */
    NAME(
            "tibu:name",
            "Display name of the counterparty",
            false,
            false
    ),

    /**
     * Type of source used to create the counterparty.
     */
    SOURCE_TYPE(
            "tibu:source:type",
            "Type of source used to create the counterparty",
            false,
            false
    ),

    /**
     * Counterparty originating from OpenStreetMap.
     * <p>
     * The value represents the OSM identifier.
     * Examples: node/123, way/12345, relation/123456789.
     */
    SOURCE_OPENSTREETMAP(
            "tibu:source:osm",
            "Counterparty originating from OpenStreetMap",
            false,
            true
    ),

    /**
     * Counterparty created by an end user.
     */
    SOURCE_USER(
            "tibu:source:usr",
            "Counterparty created by end user",
            false,
            false
    ),

    /**
     * Counterparty created by a professional user.
     */
    SOURCE_USER_PRO(
            "tibu:source:pro",
            "Counterparty created by professional user",
            false,
            false
    ),

    /**
     * Main activity of the counterparty.
     */
    MAIN_ACTIVITY(
            "tibu:activity:main",
            "Main activity of the counterparty",
            false,
            false
    ),

    /* ==============================
     * Geolocation
     * ============================== */

    /**
     * Latitude of the counterparty location.
     */
    LATITUDE(
            "tibu:latitude",
            "Latitude of the counterparty location",
            true,
            false
    ),

    /**
     * Longitude of the counterparty location.
     */
    LONGITUDE(
            "tibu:longitude",
            "Longitude of the counterparty location",
            true,
            false
    ),

    /**
     * Full postal address.
     */
    ADDRESS(
            "tibu:address:full",
            "Full postal address",
            false,
            false
    ),

    /**
     * City name.
     */
    CITY(
            "tibu:address:city",
            "City name",
            false,
            false
    ),

    /**
     * District or neighborhood name.
     */
    DISTRICT(
            "tibu:address:district",
            "District or neighborhood",
            false,
            false
    ),

    /**
     * Commercial area or shopping zone.
     */
    COMMERCIAL_AREA(
            "tibu:address:commercial_area",
            "Commercial area or shopping zone",
            false,
            false
    ),

    /* ==============================
     * Branding
     * ============================== */

    /**
     * Brand name associated with the counterparty.
     */
    BRAND(
            "tibu:brand",
            "Brand name",
            false,
            false
    ),

    /**
     * Logo image in 128x128 format.
     */
    LOGO_128(
            "tibu:logo:128x128",
            "Logo image (128x128)",
            false,
            false
    ),

    /* ==============================
     * Legal / identifiers
     * ============================== */

    /**
     * French SIRET identifier.
     */
    ID_FR_SIRET(
            "tibu:id:fr:siret",
            "French SIRET identifier",
            true,
            true
    ),

    /**
     * French SIREN identifier.
     */
    ID_FR_SIREN(
            "tibu:id:fr:siren",
            "French SIREN identifier",
            true,
            true
    ),

    /**
     * European VAT identifier.
     */
    ID_EU_VAT(
            "tibu:id:eu:vat",
            "European VAT identifier",
            false,
            true
    ),

    /**
     * Legal Entity Identifier.
     */
    ID_LEI(
            "tibu:id:lei",
            "Legal Entity Identifier",
            false,
            true
    ),

    /**
     * Powens internal identifier.
     */
    ID_POWENS(
            "tibu:id:powens",
            "Powens internal identifier",
            false,
            true
    ),

    /* ==============================
     * Transaction analysis
     * ============================== */

    /**
     * Keyword used to match transaction labels.
     */
    TRANSACTION_KEYWORD(
            "tibu:transaction_keyword",
            "Keyword used to match transaction labels",
            false,
            false
    );

    private final String key;
    private final String description;
    private final boolean numeric;
    private final boolean unique;

    CounterpartyMetadataCoreKeys(String key, String description, boolean numeric, boolean unique) {
        this.key = key;
        this.description = description;
        this.numeric = numeric;
        this.unique = unique;
    }

    /**
     * Returns the unique identifier of the metadata key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the functional description of the metadata.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Indicates whether the metadata value is numeric.
     */
    public boolean isNumeric() {
        return numeric;
    }

    /**
     * Indicates whether the metadata value must be unique across all counterparties.
     * <p>
     * When set to true, the same value cannot be assigned to more than one counterparty.
     */
    public boolean isUnique() {
        return unique;
    }

    @Override
    public String toString() {
        // In case the developper forgot to add .key
        return key;
    }
}
