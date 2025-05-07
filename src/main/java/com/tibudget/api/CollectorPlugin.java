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
	 * @param otpProvider an instance of {@link OTPProvider} to handle OTP authentication
	 */
	void setOTPProvider(OTPProvider otpProvider);

	void setOpenIdAuthenticator(OpenIdAuthenticator openIdAuthenticator);

	/**
	 * Restores previously stored cookies to maintain session continuity if applicable.
	 *
	 * @param cookies a map containing cookies previously returned by {@link #getCookies()}.
	 */
	void setCookies(Map<String, String> cookies);

	/**
	 * Retrieves the cookies to be stored after a collect session.
	 * These cookies can be used to restore the session before the next collect attempt.
	 *
	 * @return a map containing session cookies.
	 */
	Map<String, String> getCookies();

	/**
	 * Validates the input parameters before initiating data collect.
	 * Validation is considered successful if no ERROR messages are returned.
	 *
	 * @return a collection of {@link MessageDto} containing validation results.
	 */
	List<MessageDto> validate();

	/**
	 * Initiates the data collect process after successful validation.
	 *
	 * @param existingAccounts a collection of accounts that were previously collected by this plugin.
	 * @throws CollectError if an error occurs during the collect process (e.g., parsing issues).
	 * @throws AccessDeny if access is denied due to incorrect credentials.
	 * @throws TemporaryUnavailable if the target website is temporarily unavailable (e.g., maintenance mode).
	 * @throws ConnectionFailure if the connection to the website fails due to network issues.
	 * @throws ParameterError if one or more provided parameters are incorrect.
	 */
	void collect(Iterable<AccountDto> existingAccounts)
			throws CollectError, AccessDeny, TemporaryUnavailable, ConnectionFailure, ParameterError;

	/**
	 * Retrieves the list of synchronized accounts.
	 * Even if no new transactions are detected, the accounts must be included in this list
	 * if they are synchronized with the provider's website.
	 *
	 * @return an iterable collection of {@link AccountDto} representing synchronized accounts.
	 */
	List<AccountDto> getAccounts();

	/**
	 * Set accounts previously collected by this collector. Account can be used to store the last collected operation
	 * in metadatas for exemple. The label may have been modified by the user, this must be preserved.
	 *
	 * @param accounts List of accounts (can be empty)
	 */
	void setAccounts(List<AccountDto> accounts);

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
