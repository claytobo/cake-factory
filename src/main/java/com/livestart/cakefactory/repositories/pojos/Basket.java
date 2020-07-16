package com.livestart.cakefactory.repositories.pojos;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Basket extends ArrayList<CatalogPojo> {
	private static final long serialVersionUID = 7681201942150276064L;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Basket() {
		logger.info("new Basket created");
	}
}
