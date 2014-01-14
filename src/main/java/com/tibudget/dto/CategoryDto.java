package com.tibudget.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryDto implements Serializable, PointEntityDto {
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String parentId;

	private String title;
	
	private int childrenCount;

	private int level;

	private List<CategoryDto> children;
	
	private Double value;
	
	private String color;

	public CategoryDto(String id, String parentId, int level, String title, String color) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.level = level;
		this.title = title;
		this.color = color;
		this.childrenCount = -1;
		this.children = new ArrayList<CategoryDto>();
		this.value = 0.0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(int childrenCount) {
		this.childrenCount = childrenCount;
	}

	public List<CategoryDto> getChildren() {
		return children;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Override
	public String getEntityId() {
		return getId();
	}

	@Override
	public void setValue(Double value) {
		this.value = value;
	}

	public Double getValue() {
		return value;
	}

	public int getLevel() {
		return level;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
