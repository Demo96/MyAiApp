package com.aiapp.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private Integer id;
	private String firstName;
	private String sureName;
	private String phoneNumber;
	private String city;
	private String address;

	public User() {
	};

	public User(Integer id, String name, String surename, String number, String city, String address) {
		this.id = id;
		this.firstName = name;
		this.sureName = surename;
		this.phoneNumber = number;
		this.city = city;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return firstName;
	}

	public void setName(String name) {
		this.firstName = name;
	}

	public String getSurename() {
		return sureName;
	}

	public void setSurename(String surename) {
		this.sureName = surename;
	}

	public String getNumber() {
		return phoneNumber;
	}

	public void setNumber(String number) {
		this.phoneNumber = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
