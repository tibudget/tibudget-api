package com.tibudget.dto;

import java.util.List;

public class SerieDto {

	private String title;
	private String type;
	private List<PointDto> points;

	public SerieDto(String title, String type) {
		super();
		this.title = title;
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<PointDto> getPoints() {
		return points;
	}
}
