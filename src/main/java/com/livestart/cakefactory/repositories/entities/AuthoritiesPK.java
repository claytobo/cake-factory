package com.livestart.cakefactory.repositories.entities;

import java.io.Serializable;

import javax.persistence.Column;

public class AuthoritiesPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3248553921849175676L;
	
	@Column(length = 50, nullable = false)
	private String username;
	@Column(length = 50)
	private String authority;
	
	public AuthoritiesPK() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AuthoritiesPK)) {
			return false;
		}
		AuthoritiesPK other = (AuthoritiesPK) obj;
		if (authority == null) {
			if (other.authority != null) {
				return false;
			}
		} else if (!authority.equals(other.authority)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
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
