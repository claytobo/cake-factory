package com.livestart.cakefactory.repositories.pojos;

import com.livestart.cakefactory.repositories.entities.Pastry;

public class PastryPojo {
	private String name;
	private double price;
	
	public PastryPojo() {
		super();
	}

	public PastryPojo(String name, double d) {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.name + " - &163;" + this.price;
	}
}
