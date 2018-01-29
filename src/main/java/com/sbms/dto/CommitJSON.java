package com.sbms.dto;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * {"days":[0,1,0,0,0,0,0],"total":1,"week":1485648000}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitJSON {

	private int[] days;
	private String total;
	private long week;
	private String monthyear;

	private static final long unixtimediff = 1000L;

	public CommitJSON() {

	}

	public String getMonthyear() {
		return monthyear;
	}

	public void setMonthyear(String monthyear) {
		this.monthyear = monthyear;
	}

	public int[] getDays() {
		return days;
	}

	public void setDays(int[] days) {
		this.days = days;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public long getWeek() {
		return week;
	}

	public void setWeek(long week) {
		this.week = week;
		setWeekNumber();
	}

	private void setWeekNumber() {
		setMonthyear(new SimpleDateFormat("MMyyyy").format(new java.util.Date(this.getWeek() * 1000L)));
	}

	@Override
	public String toString() {
		return "{\"days\":" + Arrays.toString(this.getDays()) + ",\"total\":" + this.getTotal() + ",\"week\":"
				+ this.getWeek() + "-" + this.getMonthyear() + "}";
	}

}
