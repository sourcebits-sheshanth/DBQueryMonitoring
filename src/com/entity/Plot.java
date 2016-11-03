package com.entity;

public class Plot {

	private int count;
	private String dates;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Override
	public String toString() {
		return "Plot [count=" + count + ", dates=" + dates + "]";
	}

}
