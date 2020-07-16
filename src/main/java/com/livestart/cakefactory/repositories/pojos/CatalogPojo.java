package com.livestart.cakefactory.repositories.pojos;

import java.math.BigDecimal;

import com.livestart.cakefactory.repositories.entities.Catalog;

public class CatalogPojo implements Comparable<CatalogPojo> {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CatalogPojo)) {
			return false;
		}
		CatalogPojo other = (CatalogPojo) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(CatalogPojo o) {
		return this.name.compareTo(o.getName());
	}
}
