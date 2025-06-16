package com.tibudget.api;

/**
 * This interface provides functionality for retrieving a counterparty UUID based on a query string.
 * The query supports prefixed identifiers like "iban:", "fr_siret:", "bic:", etc.
 * <p>
 * The list of supported prefixes is exposed as constants with documentation.
 * Note: this list is non-exhaustive and may grow over time.
 */
public interface CounterpartyProvider {

    /**
     * Retrieves a universally unique identifier (UUID) corresponding to the provided query.
     * The query can be a plain label or a prefixed identifier such as "bic:CMCIFRPP" or "fr_siret:12345678900013".
     *
     * @param query the search query string
     * @return the UUID as a {@code String}, or {@code null} if no match or multiple matches are found
     */
    String search(String query);

    // ---------- International identifiers ----------

    /** Legal Entity Identifier (ISO 17442) */
    String PREFIX_LEI = "lei";

    /** D-U-N-S Number (Dun & Bradstreet global identifier) */
    String PREFIX_DUNS = "duns";

    /** International Bank Account Number */
    String PREFIX_IBAN = "iban";

    /** Bank Identifier Code (SWIFT) */
    String PREFIX_BIC = "bic";

    /** VAT number (generic international format) */
    String PREFIX_VAT = "vat";

    /** Email address used as unique business identifier */
    String PREFIX_EMAIL = "email";

    /** Registered internet domain name (e.g. example.com) */
    String PREFIX_DOMAIN = "domain";

    // ---------- France ----------

    /** SIRET – French establishment identifier (14 digits) */
    String PREFIX_FR_SIRET = "fr_siret";

    /** SIREN – French company identifier (9 digits) */
    String PREFIX_FR_SIREN = "fr_siren";

    // ---------- Germany ----------

    /** Handelsregister (commercial register) number */
    String PREFIX_DE_HRB = "de_hrb";

    /** German national tax number */
    String PREFIX_DE_STEUERNUMMER = "de_steuernummer";

    /** German VAT ID (USt-IdNr) */
    String PREFIX_DE_USTID = "de_ustid";

    // ---------- United States ----------

    /** Employer Identification Number (IRS) */
    String PREFIX_US_EIN = "us_ein";

    /** Taxpayer Identification Number */
    String PREFIX_US_TIN = "us_tin";

    /** SEC Central Index Key */
    String PREFIX_US_CIK = "us_cik";

    // ---------- United Kingdom ----------

    /** UK Companies House registration number */
    String PREFIX_UK_COMPANY_NUMBER = "uk_company_number";

    /** Unique Taxpayer Reference */
    String PREFIX_UK_UTR = "uk_utr";

    /** UK VAT number */
    String PREFIX_UK_VAT = "uk_vat";

    // ---------- Canada ----------

    /** Canadian Business Number (CRA) */
    String PREFIX_CA_BN = "ca_bn";

    /** Canadian GST/HST tax ID */
    String PREFIX_CA_GST_HST = "ca_gst_hst";

    // ---------- Italy ----------

    /** Italian Codice Fiscale */
    String PREFIX_IT_CF = "it_cf";

    /** Italian Partita IVA (VAT number) */
    String PREFIX_IT_PIVA = "it_piva";

    // ---------- Spain ----------

    /** Spanish CIF (corporate tax ID) */
    String PREFIX_ES_CIF = "es_cif";

    /** Spanish NIF (individual or company tax ID) */
    String PREFIX_ES_NIF = "es_nif";

    // ---------- Poland ----------

    /** Polish tax identification number */
    String PREFIX_PL_NIP = "pl_nip";

    /** Polish business statistical number */
    String PREFIX_PL_REGON = "pl_regon";

    // ---------- Netherlands ----------

    /** Dutch Chamber of Commerce number */
    String PREFIX_NL_KVK = "nl_kvk";

    /** Dutch VAT number */
    String PREFIX_NL_BTW = "nl_btw";

    // ---------- Belgium ----------

    /** Belgian enterprise number (KBO) */
    String PREFIX_BE_KBO = "be_kbo";

    // ---------- Australia ----------

    /** Australian Business Number */
    String PREFIX_AU_ABN = "au_abn";

    /** Australian Company Number */
    String PREFIX_AU_ACN = "au_acn";

    // ---------- Brazil ----------

    /** Brazilian company tax ID (CNPJ) */
    String PREFIX_BR_CNPJ = "br_cnpj";

    /** Brazilian personal tax ID (CPF) */
    String PREFIX_BR_CPF = "br_cpf";

    // ---------- Switzerland ----------

    /** Swiss UID (IDE) business identifier */
    String PREFIX_CH_IDE = "ch_ide";

    // ---------- Japan ----------

    /** Japanese Corporate Number (法人番号) */
    String PREFIX_JP_CORPORATE_NO = "jp_corporate_no";

    // ---------- South Korea ----------

    /** South Korean Business Registration Number */
    String PREFIX_KR_BRN = "kr_brn";

    // ---------- China ----------

    /** Chinese Unified Social Credit Code (统一社会信用代码) */
    String PREFIX_CN_USCC = "cn_uscc";

    // ---------- India ----------

    /** Indian Corporate Identification Number */
    String PREFIX_IN_CIN = "in_cin";

    // ---------- Russia ----------

    /** Russian Primary State Registration Number */
    String PREFIX_RU_OGRN = "ru_ogrn";

    /** Russian Taxpayer Identification Number */
    String PREFIX_RU_INN = "ru_inn";

    // ---------- Mexico ----------

    /** Mexican Federal Taxpayer Registry (RFC) */
    String PREFIX_MX_RFC = "mx_rfc";

    // ---------- Turkey ----------

    /** Turkish Tax Identification Number (VKN) */
    String PREFIX_TR_VKN = "tr_vkn";

    // ---------- Sweden ----------

    /** Swedish organization number */
    String PREFIX_SE_ORGNR = "se_orgnr";

    // ---------- Denmark ----------

    /** Danish CVR number */
    String PREFIX_DK_CVR = "dk_cvr";

    // ---------- Finland ----------

    /** Finnish business ID (Y-tunnus) */
    String PREFIX_FI_YTUNNUS = "fi_ytunnus";

    // ---------- Norway ----------

    /** Norwegian organization number */
    String PREFIX_NO_ORGNR = "no_orgnr";

    // ---------- Vendor-specific ----------

    /** Internal Powens connector UUID */
    String PREFIX_POWENS = "powens";
}
