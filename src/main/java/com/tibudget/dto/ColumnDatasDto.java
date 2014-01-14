package com.tibudget.dto;

import java.util.ArrayList;
import java.util.List;

public class ColumnDatasDto<T extends Comparable> implements Comparable<ColumnDatasDto<T>> {

	private T key;
	private String title;
	private List<PointDto> points;

	public ColumnDatasDto(T key, String title, int size) {
		super();
		this.key = key;
		this.title = title;
		this.points = new ArrayList<PointDto>(size);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<PointDto> getPoints() {
		return points;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	@Override
	public int compareTo(ColumnDatasDto<T> o) {
		return this.key.compareTo(o.getKey());
	}
}
