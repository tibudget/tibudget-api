package com.tibudget.api;

/**
 * Built-in counterparty metadata keys.
 */
public enum CounterpartyMetadataCoreKeys {

    /* ==============================
     * Identity / naming
     * ============================== */

    NAME(
            "tibu:name",
            "Display name of the counterparty",
            false
    ),

    SOURCE_TYPE(
            "tibu:source:type",
            "Type of source used to create the counterparty",
            false
    ),

    SOURCE_OPENSTREETMAP(
            "tibu:source:osm",
            "Counterparty originating from OpenStreetMap, the value is its ID. Exemple: node/123 way/12345 or relation/123456789",
            false
    ),

    SOURCE_USER(
            "tibu:source:usr",
            "Counterparty created by end user",
            false
    ),

    SOURCE_USER_PRO(
            "tibu:source:pro",
            "Counterparty created by professional user",
            false
    ),

    MAIN_ACTIVITY(
            "tibu:activity:main",
            "Main activity of the counterparty",
            false
    ),

    /* ==============================
     * Geolocation
     * ============================== */

    LATITUDE(
            "tibu:latitude",
            "Latitude of the counterparty location",
            true
    ),

    LONGITUDE(
            "tibu:longitude",
            "Longitude of the counterparty location",
            true
    ),

    ADDRESS(
            "tibu:address:full",
            "Full postal address",
            false
    ),

    CITY(
            "tibu:address:city",
            "City name",
            false
    ),

    DISTRICT(
            "tibu:address:district",
            "District or neighborhood",
            false
    ),

    COMMERCIAL_AREA(
            "tibu:address:commercial_area",
            "Commercial area or shopping zone",
            false
    ),

    /* ==============================
     * Branding
     * ============================== */

    BRAND(
            "tibu:brand",
            "Brand name",
            false
    ),

    LOGO_128(
            "tibu:logo:128x128",
            "Logo image (128x128)",
            false
    ),

    /* ==============================
     * Legal / identifiers
     * ============================== */

    ID_FR_SIRET(
            "tibu:id:fr:siret",
            "French SIRET identifier",
            true
    ),

    ID_FR_SIREN(
            "tibu:id:fr:siren",
            "French SIREN identifier",
            true
    ),

    ID_EU_VAT(
            "tibu:id:eu:vat",
            "European VAT identifier",
            false
    ),

    ID_LEI(
            "tibu:id:lei",
            "Legal Entity Identifier",
            false
    ),

    ID_POWENS(
            "tibu:id:powens",
            "Powens internal identifier",
            false
    ),

    /* ==============================
     * Transaction analysis
     * ============================== */

    TRANSACTION_KEYWORD(
            "tibu:transaction_keyword",
            "Keyword used to match transaction labels",
            false
    );

    private final String key;
    private final String description;
    private final boolean numeric;

    CounterpartyMetadataCoreKeys(String key, String description, boolean numeric) {
        this.key = key;
        this.description = description;
        this.numeric = numeric;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public boolean isNumeric() {
        return numeric;
    }
}
