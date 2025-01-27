package com.tibudget.api;

import java.util.Collection;

import com.tibudget.api.exceptions.AccessDeny;
import com.tibudget.api.exceptions.CollectError;
import com.tibudget.api.exceptions.ConnectionFailure;
import com.tibudget.api.exceptions.ParameterError;
import com.tibudget.api.exceptions.TemporaryUnavailable;
import com.tibudget.dto.AccountDto;
import com.tibudget.dto.OperationDto;
import com.tibudget.dto.MessageDto;

/**
 * <p>Interface for collector plugins, the piece of code that will
 * connect to bank website (or other types) and collect account and operations.
 */
public interface ICollectorPlugin {

	/**
	 * <p>First method to be called to validate field values.
	 * <p>Validation pass if no ERROR message is returned
	 * @return A list of messages
	 */
	Collection<MessageDto> validate();
	
	/**
	 * <p>If {@link #validate()} passed then this methods is called to
	 * run account and operation collect. 
	 * @param existingAccounts Set of account previously collected by this collector
	 * @throws CollectError An error occurred during collection (parsing, etc.)
	 * @throws AccessDeny Access is refused, probably due to bad credentials
	 * @throws TemporaryUnavailable Web site is not available, e.g. the site is under maintenance 
	 * @throws ConnectionFailure Web site connection has failed due to network error, e.g. no internet connection
	 * @throws ParameterError One of the parameter is probably wrong and caused this error
	 */
	void collect(Iterable<AccountDto> existingAccounts) throws CollectError, AccessDeny, TemporaryUnavailable, ConnectionFailure, ParameterError;

	/**
	 * Return the list of synchronized accounts. Even if there is no new operation
	 * the account must be present in this list if its status is synchronized
	 * with account provider web site
	 * @return List of synchronized accounts
	 */
	Iterable<AccountDto> getAccounts();

	/**
	 * <p>Return the list of all new operation since last {@link #collect(Iterable)} call.
	 * <p>Account of operation must be present in list returned by {@link #getAccounts()}.
	 * @return List of new operations
	 */
	Iterable<OperationDto> getOperations();

	/**
	 * Return collect progression in percent
	 * @return A value between 0 and 100 included
	 */
	int getProgress();
}
