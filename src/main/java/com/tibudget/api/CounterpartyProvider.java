package com.tibudget.api;

/**
 * Provides read-only access to counterparties using metadata-based lookup.
 * <p>
 * A counterparty represents an entity involved in transactions, such as
 * a merchant, a service provider, or an individual.
 * <p>
 * Lookups are performed using metadata keys and values.
 * The provided metadata key must refer to a metadata definition
 * marked as {@code unique=true}.
 * <p>
 * Built-in metadata keys and their constraints are defined in
 * {@link CounterpartyMetadataCoreKeys}.
 * Custom metadata keys must be validated through the Tibu professional
 * dashboard and explicitly declared as unique.
 * <p>
 * Implementations must perform an exact match on the given metadata value.
 */
public interface CounterpartyProvider {

    /**
     * Finds a counterparty using a string-based metadata value.
     * <p>
     * The provided {@code metadataKey} must reference a metadata definition
     * marked as {@code unique=true}. Using a non-unique metadata key
     * is considered a programming error and will result in an exception.
     *
     * @param metadataKey
     *     Unique identifier of the metadata key, for example {@code "tibu:id:fr:siret"}.
     * @param valueString
     *     String value associated with the metadata key.
     *     The comparison is expected to be exact.
     *
     * @return
     *     The UUID of the matching counterparty if found,
     *     or {@code null} if no matching counterparty exists.
     *
     * @throws IllegalArgumentException
     *     if {@code metadataKey} is null, blank,
     *     unknown, not validated,
     *     or does not refer to a metadata marked as {@code unique=true}.
     */
    String find(String metadataKey, String valueString);

    /**
     * Finds a counterparty using a numeric metadata value.
     * <p>
     * The provided {@code metadataKey} must reference a metadata definition
     * marked as {@code unique=true}. Using a non-unique metadata key
     * is considered a programming error and will result in an exception.
     *
     * @param metadataKey
     *     Unique identifier of the metadata key.
     * @param valueNumeric
     *     Numeric value associated with the metadata key.
     *     The comparison is expected to be exact.
     *
     * @return
     *     The UUID of the matching counterparty if found,
     *     or {@code null} if no matching counterparty exists.
     *
     * @throws IllegalArgumentException
     *     if {@code metadataKey} is null, blank,
     *     unknown, not validated,
     *     or does not refer to a metadata marked as {@code unique=true}.
     */
    String find(String metadataKey, Double valueNumeric);
}
