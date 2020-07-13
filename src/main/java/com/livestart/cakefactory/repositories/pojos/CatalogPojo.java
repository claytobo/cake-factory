package com.livestart.cakefactory.repositories.pojos;

import java.math.BigDecimal;

import com.livestart.cakefactory.repositories.entities.Catalog;

public class CatalogPojo {
	private String code;
	private String name;
	private double price;
	
	public CatalogPojo() {
		super();
	}
	
	public CatalogPojo(String code, String name, double price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	public CatalogPojo(String code, String name, BigDecimal price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price.doubleValue();
	}

	public CatalogPojo(Catalog catalog) {
		this(catalog.getId(), catalog.getName(), catalog.getPrice().doubleValue());
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
