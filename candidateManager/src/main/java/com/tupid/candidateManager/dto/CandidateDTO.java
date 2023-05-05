package com.tupid.candidateManager.dto;


public class CandidateDTO {

	private String name;

	private String phoneNumber;
	private String email; 
	private Address address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public CandidateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CandidateDTO(String name, String phoneNumber, String email, Address address) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}
	@Override
	public String toString() {
		return "CandidateDTO [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address="
				+ address + "]";
	}

	
}
