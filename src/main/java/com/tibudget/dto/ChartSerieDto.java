package com.tibudget.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChartSerieDto implements Serializable {

	private static final long serialVersionUID = -536285092824365221L;

	private String label;

	private List<ChartPointDto> points;

	public ChartSerieDto(String label) {
		super();
		this.label = label;
		this.points = new ArrayList<ChartPointDto>();
	}

	public String getLabel() {
		return label;
	}

	public List<ChartPointDto> getPoints() {
		return points;
	}

}
