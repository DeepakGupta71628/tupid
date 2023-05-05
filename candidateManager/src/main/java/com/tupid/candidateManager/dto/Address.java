package com.tupid.candidateManager.dto;

public class Address {
	private String plotNo;
	private String street;
	private String state;
	private String pincode;
	public String getPlotNo() {
		return plotNo;
	}
	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String plotNo, String street, String state, String pincode) {
		super();
		this.plotNo = plotNo;
		this.street = street;
		this.state = state;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [plotNo=" + plotNo + ", street=" + street + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	
}
