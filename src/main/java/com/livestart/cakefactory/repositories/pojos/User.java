package com.livestart.cakefactory.repositories.pojos;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.livestart.cakefactory.assist.AccountStates;
import com.livestart.cakefactory.repositories.entities.Users;

public class User implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5495233253393270676L;
	private Boolean[] states;
	private String username;
	private String password;
	private Set<Authority> set;
	
	public User(Users users) {
		states = new Boolean[4];
		states[AccountStates.ACCOUNT_NON_EXPIRED.position()] = true;
		states[AccountStates.ACCOUNT_NON_LOCKED.position()] = true;
		states[AccountStates.CREDENTIALS_NON_EXPIRED.position()] = true;
		states[AccountStates.ENABLED.position()] = users.getEnabled();
		this.username = users.getUsername();
		this.password = users.getPassword();
		set = new HashSet<>();
		set.add(new Authority());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return set;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return states[AccountStates.ACCOUNT_NON_EXPIRED.position()];
	}

	@Override
	public boolean isAccountNonLocked() {
		return states[AccountStates.ACCOUNT_NON_LOCKED.position()];
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return states[AccountStates.CREDENTIALS_NON_EXPIRED.position()];
	}

	@Override
	public boolean isEnabled() {
		return states[AccountStates.ENABLED.position()];
	}

}
