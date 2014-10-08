package com.tibudget.dto;

import java.io.Serializable;
import java.util.Date;

public class BankAccountDto implements Serializable {

	private static final long serialVersionUID = -4277619307911932128L;

	public enum Type {
		OTHER, BANK_CHECKING, BANK_SAVING, BANK_STOCK, GAMBLE
	}

	private String id;

	private String title;

	/** Name of the bank or provider of the account */
	private String providerName;

	private double currentBalance;

	private double shouldNotBeUnderBalance;

	private double mustNotBeUnderBalance;

	private double cannotNotBeUnderBalance;

	/**
	 * Last time that bank account has been updated successfully
	 */
	private Date lastUpdate;

	/**
	 * An ID that collector can set to know what was the last collected
	 * operation
	 */
	private String lastOperationProviderId;

	private Type type;
	
	/**
	 * True if the account is being updated (this flag is not always correct
	 * it depends of who created it)
	 */
	private boolean synchronizing;

	/**
	 * Constructor usefull for Collectors
	 * 
	 * @param title
	 *            Title of the account
	 * @param providerName
	 *            Name of the bank or provider of the account
	 * @param currentBalance
	 *            Current balance of the account
	 */
	public BankAccountDto(String id, Type type, String title, String providerName, double currentBalance) {
		this(id, type, title, providerName, currentBalance, null, null);
	}

	/**
	 * Constructor for the portal
	 * 
	 * @param id
	 *            Identifier of the bank account
	 * @param title
	 *            Title of the bank account
	 * @param providerName
	 *            Name of the bank or provider of the account
	 * @param lastUpdate
	 *            Last time that bank account has been updated successfully
	 * @param lastOperationProviderId
	 *            An ID that collector can set to know what was the last
	 *            collected operation
	 * @param
	 */
	public BankAccountDto(String id, Type type, String title, String providerName, double currentBalance, Date lastUpdate, String lastOperationProviderId) {
		super();
		this.id = id;
		this.type = type;
		this.title = title;
		this.providerName = providerName;
		this.currentBalance = currentBalance;
		this.lastUpdate = lastUpdate;
		this.lastOperationProviderId = lastOperationProviderId;
		this.shouldNotBeUnderBalance = 0.0;
		this.mustNotBeUnderBalance = 0.0;
		this.cannotNotBeUnderBalance = 0.0;
		this.synchronizing = false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getShouldNotBeUnderBalance() {
		return shouldNotBeUnderBalance;
	}

	public void setShouldNotBeUnderBalance(double shouldNotBeUnderBalance) {
		this.shouldNotBeUnderBalance = shouldNotBeUnderBalance;
	}

	public double getMustNotBeUnderBalance() {
		return mustNotBeUnderBalance;
	}

	public void setMustNotBeUnderBalance(double mustNotBeUnderBalance) {
		this.mustNotBeUnderBalance = mustNotBeUnderBalance;
	}

	public double getCannotNotBeUnderBalance() {
		return cannotNotBeUnderBalance;
	}

	public void setCannotNotBeUnderBalance(double cannotNotBeUnderBalance) {
		this.cannotNotBeUnderBalance = cannotNotBeUnderBalance;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLastOperationProviderId() {
		return lastOperationProviderId;
	}

	public void setLastOperationProviderId(String lastOperationProviderId) {
		this.lastOperationProviderId = lastOperationProviderId;
	}

	public boolean isSynchronizing() {
		return synchronizing;
	}

	public void setSynchronizing(boolean synchronizing) {
		this.synchronizing = synchronizing;
	}
}
