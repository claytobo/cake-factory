package com.livestart.cakefactory.assist;

public class Ingredient {
	private String abbreviation;
	private String name;
	private Type type;
	
	public Ingredient(String abbr, String name, Type type) {
		this.abbreviation = abbr;
		this.name = name;
		this.type = type;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Ingredient [abbreviation=" + abbreviation + ", name=" + name + ", type=" + type + "]";
	}
	
}
