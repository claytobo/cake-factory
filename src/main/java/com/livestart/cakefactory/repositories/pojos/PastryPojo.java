package com.livestart.cakefactory.repositories.pojos;

import java.math.BigDecimal;

import com.livestart.cakefactory.repositories.entities.Pastry;

public class PastryPojo {
	private String name;
	private BigDecimal price;
	
	public PastryPojo() {
		super();
	}

	public PastryPojo(String name, BigDecimal d) {
		super();
		this.name = name;
		this.price = d;
	}
	
	public PastryPojo(Pastry pastry) {
		this(pastry.getName(), pastry.getPrice());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.name + " - &163;" + this.price;
	}
}
