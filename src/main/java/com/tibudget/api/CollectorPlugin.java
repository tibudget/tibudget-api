package com.tibudget.api;

import com.tibudget.api.exceptions.*;
import com.tibudget.dto.AccountDto;
import com.tibudget.dto.MessageDto;
import com.tibudget.dto.OperationDto;

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
     * @param otpProvider      an instance of {@link OTPProvider} to handle OTP authentication
     * @param previousCookies  a map containing cookies previously returned by {@link #getCookies()} after last collect
     * @param previousAccounts accounts previously collected by this collector. Account can be used to store the last collected operation in metadatas for exemple. The label may have been modified by the user, this must be preserved.
     */
    void init(InternetProvider internetProvider, OTPProvider otpProvider, Map<String, String> previousCookies, List<AccountDto> previousAccounts);

    /**
     * JSON configuration to connect to openid server as it is done in AppAuth demo application
     *
     * @return JSON string or null if this collector does not use OpenId to authenticate
     */
    default String getOpenIdJSONConfiguration() {
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
     * Retrieves the cookies to be stored after a collect session.
     * These cookies can be used to restore the session before the next collect attempt.
     *
     * @return a map containing session cookies.
     */
    Map<String, String> getCookies();

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
     * @return an iterable collection of {@link OperationDto} representing new transactions.
     */
    List<OperationDto> getOperations();

    /**
     * Retrieves the current progress of the data collect process as a percentage.
     *
     * @return an integer between 0 and 100 (inclusive) representing the collect progress.
     */
    int getProgress();
}
