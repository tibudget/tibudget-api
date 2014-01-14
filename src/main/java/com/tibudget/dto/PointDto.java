package com.tibudget.dto;

import java.util.Date;

public class PointDto {
	private Double value;
	private Date beginDate;

	public PointDto(Double value, Date beginDate) {
		super();
		this.value = value;
		this.beginDate = beginDate;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getBeginDate() {
		return beginDate;
	}
}
