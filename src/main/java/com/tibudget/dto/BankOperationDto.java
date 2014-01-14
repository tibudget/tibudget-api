package com.tibudget.dto;

import java.io.Serializable;
import java.util.Date;

public class BankOperationDto implements Serializable {

	private static final long serialVersionUID = 1832972023357724057L;

	public enum Type {
		/** when no other type is pertinent */
		OTHER,
		/** cash payment or ATM withdraw */
		CASH,
		/** account to account transfert */
		TRANSFERT,
		/** Debit card payment */
		DEBIT_CARD,
		/** Credit card payment */
		CREDIT_CARD,
		/** Check payment */
		CHECK,
		/** Bank cost*/
		BANK
	}

	private String id;

	private String accountId;

	private Type type;

	private Date dateValue;

	private Date dateOperation;

	private Date dateCreated;

	private String label;

	private Double value;

	private String category;

	private String categoryId;

	private String categoryColor;

	private boolean newOperation;

	/**
	 * Set to -1 if unknown
	 */
	private int childrenCount;

	/**
	 * Constructor usefull for Collectors
	 * @param dateValue Value date (when the user did the operation)
	 * @param dateOperation Operation date (when the bank operate the operation)
	 * @param label Label of operation
	 * @param value Amount of the operation
	 */
	public BankOperationDto(Type type, Date dateValue, Date dateOperation, String label, Double value) {
		super();
		this.id = null;
		this.type = type;
		this.dateCreated = null;
		this.dateValue = dateValue;
		this.dateOperation = dateOperation;
		this.label = label;
		this.value = value;
		this.childrenCount = 0;
		this.newOperation = true;
	}

	public BankOperationDto(String id, Type type, Date dateCreated, Date dateValue, Date dateOperation, String label, Double value, int childrenCount, boolean newOperation) {
		super();
		this.id = id;
		this.type = type;
		this.dateCreated = dateCreated;
		this.dateValue = dateValue;
		this.dateOperation = dateOperation;
		this.label = label;
		this.value = value;
		this.childrenCount = childrenCount;
		this.newOperation = newOperation;
	}

	public Date getDateValue() {
		return this.dateValue;
	}

	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

	public Date getDateOperation() {
		return this.dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getChildrenCount() {
		return this.childrenCount;
	}

	public void setChildrenCount(int childrenCount) {
		this.childrenCount = childrenCount;
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isNewOperation() {
		return this.newOperation;
	}

	public Type getType() {
		return this.type;
	}

	public String getCategoryColor() {
		return categoryColor;
	}

	public void setCategoryColor(String categoryColor) {
		this.categoryColor = categoryColor;
	}
}
