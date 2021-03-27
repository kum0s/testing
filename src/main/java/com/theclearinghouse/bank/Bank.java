//Bank - an entity
package com.theclearinghouse.bank;

public class Bank {
	private String name;
	private String type;
	private String city;
	private String state;
	private String zipCode;
	
	public Bank(String name, String type, String city, String state, String zipCode) {
		super();
		this.name = name;
		this.type = type;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZip(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Bank [name=" + name + ", type=" + type + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
}
