package com.livestart.cakefactory.repositories.pojos;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Basket extends ArrayList<CatalogPojo> {
	private static final long serialVersionUID = 7681201942150276064L;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Basket() {
		super();
		logger.info("new Basket created");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Basket [");
		super.forEach(item -> {
			builder.append(item.toString());
			builder.append(", ");
		});
		int length = builder.length();
		builder.replace(length - 2, length, "");
		builder.append("]");
		return builder.toString();
	}
}
