package com.livestart.cakefactory.assist;

public class Pastry {
	private String name;
	private double price;
	
	public Pastry() {
		super();
	}

	public Pastry(String name, double d) {
		super();
		this.name = name;
		this.price = d;
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
