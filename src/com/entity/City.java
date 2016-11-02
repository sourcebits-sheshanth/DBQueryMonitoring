package com.entity;

public class City {

	private int id;
	private String country;
	private Double map;
	private String name;
	private String state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getMap() {
		return map;
	}

	public void setMap(Double map) {
		this.map = map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", country=" + country + ", map=" + map + ", name=" + name + ", state=" + state + "]";
	}

}
