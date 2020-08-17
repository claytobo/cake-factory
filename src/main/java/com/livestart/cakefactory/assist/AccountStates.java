package com.livestart.cakefactory.assist;

public enum AccountStates {
	ACCOUNT_NON_EXPIRED(0),
	ACCOUNT_NON_LOCKED(1),
	CREDENTIALS_NON_EXPIRED(2),
	ENABLED(3);
	
	private final Integer position;
	
	AccountStates(Integer pos) {
		this.position = pos;
	}
	
	public Integer position() {
		return this.position;
	}
}
