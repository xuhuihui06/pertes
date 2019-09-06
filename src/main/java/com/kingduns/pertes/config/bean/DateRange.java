package com.kingduns.pertes.config.bean;

import java.io.Serializable;

public class DateRange implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7650044184063867319L;
	private String start;
	private String end;

	public DateRange(String start, String end) {
		this.start = start;
		this.end = end;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
}
