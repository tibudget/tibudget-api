package com.tibudget.api;

import com.tibudget.api.exceptions.*;
import com.tibudget.dto.AccountDto;
import com.tibudget.dto.MessageDto;
import com.tibudget.dto.TransactionDto;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * Interface defining a collector plugin, responsible for connecting to a bank website (or other providers)
 * to collect account and transaction data.
 */
public interface CollectorPlugin {

    /**
     * Provides an OTP (One-Time Password) provider to the collector if required.
     *
     * @param internetProvider The bridge to use to connect to the internet. This ensure high level of security since you will only be able to connect to the domain names that you declared when you registered your collector.
     * @param counterpartyProvider Interface to find Counterparty
     * @param otpProvider      an instance of {@link OTPProvider} to handle OTP authentication
     * @param pdfToolsProvider an instance of {@link PDFToolsProvider} to provide PDF utils
     * @param settings         a map containing settings previously returned by {@link #getSettings()} after last collect
     * @param previousAccounts accounts previously collected by this collector. Account can be used to store the last collected transaction in metadatas for exemple. The label may have been modified by the user, this must be preserved.
     */
    void init(InternetProvider internetProvider,
              CounterpartyProvider counterpartyProvider,
              OTPProvider otpProvider,
              PDFToolsProvider pdfToolsProvider,
              Map<String, String> settings,
              List<AccountDto> previousAccounts);

    /**
     * Called when the collector receives a callback URI at the end of an external
     * authentication or connection flow (OAuth, SSO, web login, etc.).
     *
     * <p>
     * This method is typically responsible for:
     * <ul>
     *     <li>Validating the callback parameters (code, token, state, error...)</li>
     *     <li>Finalizing the authentication process</li>
     *     <li>Fetching initial user or account information if required</li>
     * </ul>
     *
     * <p>
     * The returned value will be displayed to the user and should uniquely identify
     * the configured connection, for example:
     * <ul>
     *     <li>Bank name + account owner first name</li>
     *     <li>Shop name + customer identifier</li>
     * </ul>
     *
     * @param callbackUri The full callback URI received by Tibu at the end of the connection flow
     * @return A human-readable title describing the configured connection
     * @throws IllegalArgumentException if the callback URI is invalid or incomplete
     */
    String initConnection(URI callbackUri);

    /**
     * JSON configuration to connect to openid server as it is done in AppAuth demo application
     *
     * @return JSON string or null if this collector does not use OpenId to authenticate
     */
    default String getOpenIdJSONConfiguration() {
        return null;
    }

    /**
     * Retrieves the Datadome client ID associated with the current plugin if any. It will be used to generated the
     * datadome cookie.
     *
     * @return the Datadome client ID or {@code null} if no ID is available.
     */
    default String getDatadomeClientId() {
        return null;
    }

    /**
     * Validates the input parameters before initiating data collect.
     * Validation is considered successful if no ERROR messages are returned.
     *
     * @return a collection of {@link MessageDto} containing validation results.
     */
    default List<MessageDto> validate() {
        return List.of();
    }

    /**
     * Initiates the data collect process after successful validation.
     *
     * @throws CollectError         if an error occurs during the collect process (e.g., parsing issues).
     * @throws AccessDeny           if access is denied due to incorrect credentials.
     * @throws TemporaryUnavailable if the target website is temporarily unavailable (e.g., maintenance mode).
     * @throws ConnectionFailure    if the connection to the website fails due to network issues.
     * @throws ParameterError       if one or more provided parameters are incorrect.
     */
    void collect() throws CollectError, AccessDeny, TemporaryUnavailable, ConnectionFailure, ParameterError;

    /**
     * Retrieves the settings to be stored after a collect or connection.
     *
     * @return a map containing settings usefull for the collector.
     */
    Map<String, String> getSettings();

    /**
     * Retrieves the list of synchronized accounts.
     * Even if no new transactions are detected, the accounts must be included in this list
     * if they are synchronized with the provider's website.
     *
     * @return an iterable collection of {@link AccountDto} representing synchronized accounts.
     */
    List<AccountDto> getAccounts();

    /**
     * Retrieves the list of new transactions detected since the last {@link #collect(Iterable)} call.
     * Transactions should be associated with accounts present in the list returned by {@link #getAccounts()}.
     *
     * @return an iterable collection of {@link TransactionDto} representing new transactions.
     */
    List<TransactionDto> getTransactions();

    /**
     * Retrieves the current progress of the data collect process as a percentage.
     *
     * @return an integer between 0 and 100 (inclusive) representing the collect progress.
     */
    int getProgress();
}
