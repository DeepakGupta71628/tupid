package com.tupid.candidateManager.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tupid.candidateManager.dto.Address;

@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer candidateId;
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
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidate(String name, String phoneNumber, String email, Address address) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Candidate [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address="
				+ address + "]";
	}

	
}
