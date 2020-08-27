package com.livestart.cakefactory.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.livestart.cakefactory.repositories.pojos.Address;

@Entity(name = "addresses")
@Table(name = "addresses", schema = "cakefactory")
public class Addresses {
	@Id
	@Column(length = 20, nullable = false)
	private String email;
	@Column(length = 20, nullable = false)
	private String firstname;
	@Column(length = 20, nullable = false)
	private String lastname;
	@Column(length = 50, nullable = false)
	private String street;
	@Column(length = 50, nullable = false)
	private String city;
	@Column(length = 50, nullable = false)
	private String state;
	@Column(length = 10, nullable = false)
	private String zip;
	
	public Addresses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Addresses(String email, String firstname, String lastname, String street, String city, String state,
			String zip) {
		this();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public Addresses(Address address) {
		this(address.getEmail(), 
			 address.getFirstName(), 
			 address.getLastName(), 
			 address.getStreet(), 
			 address.getCity(), 
			 address.getState(), 
			 address.getZip());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
