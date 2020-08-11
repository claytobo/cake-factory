package com.livestart.cakefactory.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "authorities")
@Table(name = "authorities", schema = "cakefactory")
@IdClass(AuthoritiesPK.class)
public class Authorities {
	@Id
	private String username;
	@Id
	private String authority;
	
	public Authorities() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
