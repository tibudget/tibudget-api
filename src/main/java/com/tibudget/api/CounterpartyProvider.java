package com.tibudget.api;

/**
 * This interface provides functionality for retrieving counterparty associated to an {@link com.tibudget.dto.AccountDto}
 * or to a {@link com.tibudget.dto.TransactionDto}.
 */
public interface CounterpartyProvider {

    /**
     * Retrieves a universally unique identifier (UUID) corresponding to the provided query.
     * The query can be a label or a complex query such as: "bic:CMCIFRPP" or "powens:e9606d38-6b0f-5f76-b573-61a4d00a927d"
     *
     * @param query the search query as a {@code String}; it defines the criteria
     *              to look for in the target data source
     * @return the UUID as a {@code String} that corresponds to the given identifier type and value, or {@code null} if 0 or multiple match is found
     */
    String search(String query);

    /**
     * Retrieves a universally unique identifier (UUID) corresponding to a specific identifier type and value.
     *
     * @param type  the type of identifier (e.g., LEI, DUNS, IBAN, or any other defined in the {@code IdType} enum)
     * @param value the value of the specific identifier for which the UUID is being requested
     * @return the UUID as a {@code String} that corresponds to the given identifier type and value, or {@code null} if no match is found
     */
    String getUuidById(IdType type, String value);

    enum IdType {
        // International identifiers
        LEI,              // Legal Entity Identifier (ISO 17442)
        DUNS,             // D-U-N-S Number (Dun & Bradstreet)
        IBAN,             // International Bank Account Number
        BIC,              // Bank Identifier Code (SWIFT)
        VAT_NUMBER,       // Generic VAT number (EU, UK, etc.)
        EMAIL,            // Unique business contact (if registered)
        WEBSITE_DOMAIN,   // Registered domain name

        // France
        FR_SIRET,         // Establishment ID (14 digits)
        FR_SIREN,         // Company ID (9 digits)

        // Germany
        DE_HRB,           // Handelsregister number (commercial register)
        DE_STEUERNUMMER,  // National tax number
        DE_USTID,         // VAT ID (USt-IdNr)

        // United States
        US_EIN,           // Employer Identification Number (IRS)
        US_TIN,           // Taxpayer Identification Number
        US_CIK,           // SEC Central Index Key

        // United Kingdom
        UK_COMPANY_NUMBER, // Companies House registration number
        UK_UTR,            // Unique Taxpayer Reference
        UK_VAT_NUMBER,     // VAT number

        // Canada
        CA_BN,            // Business Number (CRA)
        CA_GST_HST,       // GST/HST Tax ID

        // Italy
        IT_CF,            // Codice Fiscale
        IT_PIVA,          // Partita IVA (VAT)

        // Spain
        ES_CIF,           // Corporate tax ID
        ES_NIF,           // Tax ID for individuals or entities

        // Poland
        PL_NIP,           // Tax Identification Number
        PL_REGON,         // Statistical Business ID

        // Netherlands
        NL_KVK,           // Chamber of Commerce number
        NL_BTW,           // VAT number

        // Belgium
        BE_KBO,           // Crossroads Bank for Enterprises number

        // Australia
        AU_ABN,           // Australian Business Number
        AU_ACN,           // Australian Company Number

        // Brazil
        BR_CNPJ,          // Company Tax ID
        BR_CPF,           // Personal Tax ID

        // Switzerland
        CH_IDE,           // UID – Swiss Enterprise Identification Number

        // Japan
        JP_CORPORATE_NO,  // Corporate Number (法人番号)

        // South Korea
        KR_BRN,           // Business Registration Number

        // China
        CN_USCC,          // Unified Social Credit Code (统一社会信用代码)

        // India
        IN_CIN,           // Corporate Identification Number

        // Russia
        RU_OGRN,          // Primary State Registration Number
        RU_INN,           // Taxpayer Identification Number

        // Mexico
        MX_RFC,           // Federal Taxpayer Registry (Registro Federal de Contribuyentes)

        // Turkey
        TR_VKN,           // Turkish Tax Number

        // Sweden
        SE_ORGNR,         // Swedish Organization Number

        // Denmark
        DK_CVR,           // Central Business Register number

        // Finland
        FI_YTUNNUS,       // Business ID (Y-tunnus)

        // Norway
        NO_ORGNR          // Organization Number
    }

}
