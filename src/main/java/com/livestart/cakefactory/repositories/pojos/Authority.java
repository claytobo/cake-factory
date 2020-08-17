package com.livestart.cakefactory.repositories.pojos;

import org.springframework.security.core.GrantedAuthority;

import com.livestart.cakefactory.repositories.entities.Authorities;

public class Authority implements GrantedAuthority {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2143540955042841436L;
	private Authorities authorities;
	
	public Authority() {
		this.authorities = new Authorities();
		this.authorities.setAuthority("CUSTOMER");
	}
	
	public Authority(Authorities auth) {
		this.authorities = auth;
	}
	
	@Override
	public String getAuthority() {
		return authorities.getAuthority();
	}

}
