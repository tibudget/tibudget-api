package com.tibudget.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SearchOperationResultDto implements Serializable {
	
	private static final long serialVersionUID = 7838096506523662553L;

	private double negativeValuesSum;
	
	private double positiveValuesSum;
	
	private int negativeValuesCount;
	
	private int positiveValuesCount;
	
	private Date negativeValuesStartDate;
	
	private Date positiveValuesStartDate;
	
	private Date negativeValuesEndDate;
	
	private Date positiveValuesEndDate;

	private double allValuesSum;
	
	private int allValuesCount;
	
	private Date allValuesStartDate;
	
	private Date allValuesEndDate;

	private List<BankOperationDto> operations;

	public SearchOperationResultDto(List<BankOperationDto> operations) {
		super();
		this.operations = operations;
	}

	public double getNegativeValuesSum() {
		return negativeValuesSum;
	}

	public void setNegativeValuesSum(double negativeValuesSum) {
		this.negativeValuesSum = negativeValuesSum;
	}

	public double getPositiveValuesSum() {
		return positiveValuesSum;
	}

	public void setPositiveValuesSum(double positiveValuesSum) {
		this.positiveValuesSum = positiveValuesSum;
	}

	public int getNegativeValuesCount() {
		return negativeValuesCount;
	}

	public void setNegativeValuesCount(int negativeValuesCount) {
		this.negativeValuesCount = negativeValuesCount;
	}

	public int getPositiveValuesCount() {
		return positiveValuesCount;
	}

	public void setPositiveValuesCount(int positiveValuesCount) {
		this.positiveValuesCount = positiveValuesCount;
	}

	public double getAllValuesSum() {
		return allValuesSum;
	}

	public void setAllValuesSum(double allValuesSum) {
		this.allValuesSum = allValuesSum;
	}

	public int getAllValuesCount() {
		return allValuesCount;
	}

	public void setAllValuesCount(int allValuesCount) {
		this.allValuesCount = allValuesCount;
	}

	public List<BankOperationDto> getOperations() {
		return operations;
	}

	public void setOperations(List<BankOperationDto> operations) {
		this.operations = operations;
	}

	public Date getNegativeValuesStartDate() {
		return negativeValuesStartDate;
	}

	public void setNegativeValuesStartDate(Date negativeValuesStartDate) {
		this.negativeValuesStartDate = negativeValuesStartDate;
	}

	public Date getPositiveValuesStartDate() {
		return positiveValuesStartDate;
	}

	public void setPositiveValuesStartDate(Date positiveValuesStartDate) {
		this.positiveValuesStartDate = positiveValuesStartDate;
	}

	public Date getNegativeValuesEndDate() {
		return negativeValuesEndDate;
	}

	public void setNegativeValuesEndDate(Date negativeValuesEndDate) {
		this.negativeValuesEndDate = negativeValuesEndDate;
	}

	public Date getPositiveValuesEndDate() {
		return positiveValuesEndDate;
	}

	public void setPositiveValuesEndDate(Date positiveValuesEndDate) {
		this.positiveValuesEndDate = positiveValuesEndDate;
	}

	public Date getAllValuesStartDate() {
		return allValuesStartDate;
	}

	public void setAllValuesStartDate(Date allValuesStartDate) {
		this.allValuesStartDate = allValuesStartDate;
	}

	public Date getAllValuesEndDate() {
		return allValuesEndDate;
	}

	public void setAllValuesEndDate(Date allValuesEndDate) {
		this.allValuesEndDate = allValuesEndDate;
	}
}
