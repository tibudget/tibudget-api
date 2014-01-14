package com.tibudget.dto;

import java.io.Serializable;
import java.util.Date;

public class ChartPointDto implements Serializable {

	private static final long serialVersionUID = -9082892162316849760L;

	private String id;
	
	private String label;
	
	private Double value;

	private String parentId;

	private Double parentValue;
	
	private Date date;
	
	private int count;
	
	private String color;

	public ChartPointDto(String id, String label, String color) {
		super();
		this.id = id;
		this.label = label;
		this.value = 0.0;
		this.parentId = null;
		this.parentValue = 0.0;
		this.color = color;
		this.count = -1;
	}

	public ChartPointDto(String id, String label, String color, String parentId) {
		this(id, label, color);
		this.parentId = parentId;
	}

	public String getLabel() {
		return label;
	}

	public Double getValue() {
		return value;
	}

	public String getColor() {
		return color;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Double getParentValue() {
		return parentValue;
	}

	public void setParentValue(Double parentValue) {
		this.parentValue = parentValue;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
