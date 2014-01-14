package com.tibudget.api;

import java.util.Collection;

import com.tibudget.api.exceptions.AccessDeny;
import com.tibudget.api.exceptions.CollectError;
import com.tibudget.api.exceptions.ConnectionFailure;
import com.tibudget.api.exceptions.ParameterError;
import com.tibudget.api.exceptions.TemporaryUnavailable;
import com.tibudget.dto.BankAccountDto;
import com.tibudget.dto.BankOperationDto;
import com.tibudget.dto.MessageDto;

/**
 * <p>Interface for collector plugins, the piece of code that will
 * connect to bank website and collect account and bank operations.
 * 
 * <p>Well in fact it is not dedicated to bank account, it can be used
 * for whatever account that manage money, e.g. online bet site.
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
	 * @param existingBankAccounts List of account previously collected by this collector
	 * @throws CollectError An error occured during collection (parsing, etc.)
	 * @throws AccessDeny Access is refused, probably due to bad credentials
	 * @throws TemporaryUnavailable Web site is not available, e.g. the site is under maintenance 
	 * @throws ConnectionFailure Web site connection has failed due to network error, e.g. no internet connection
	 * @throws ParameterError One of the parameter is probably wrong and caused this error
	 */
	void collect(Iterable<BankAccountDto> existingBankAccounts) throws CollectError, AccessDeny, TemporaryUnavailable, ConnectionFailure, ParameterError;

	/**
	 * Return the list of synchronized accounts. Even if there is no new operation
	 * the account must be present in this list if its status is synchronized
	 * with account provider web site
	 * @return List of synchronized accounts
	 */
	Iterable<BankAccountDto> getBankAccounts();

	/**
	 * <p>Return the list of all new operation since last {@link #collect(Iterable)} call.
	 * <p>Account of operation must be present in list returned by {@link #getBankAccounts()}.
	 * @return List of new operations
	 */
	Iterable<BankOperationDto> getBankOperations();

	/**
	 * Return collect progression in percent
	 * @return A value between 0 and 100 included
	 */
	int getProgress();
}
