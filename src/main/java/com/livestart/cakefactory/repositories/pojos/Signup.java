package com.livestart.cakefactory.repositories.pojos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Signup {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String email;

	public Signup() {
		logger.info("called the Signup constructor");
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Signup [email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
}
