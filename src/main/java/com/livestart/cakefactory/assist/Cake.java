package com.livestart.cakefactory.assist;

public class Cake {
	private Type batter;
	private Type icing;
	private Ingredient cakeIngredient;
	public Type getBatter() {
		return batter;
	}

	public void setBatter(Type batter) {
		this.batter = batter;
	}

	public Type getIcing() {
		return icing;
	}

	public void setIcing(Type icing) {
		this.icing = icing;
	}

	public Ingredient getCakeIngredient() {
		return cakeIngredient;
	}

	public void setCakeIngredient(Ingredient cakeIngredient) {
		this.cakeIngredient = cakeIngredient;
	}

	public Ingredient getIcingIngredient() {
		return icingIngredient;
	}

	public void setIcingIngredient(Ingredient icingIngredient) {
		this.icingIngredient = icingIngredient;
	}

	private Ingredient icingIngredient;
	
	public Cake() {
		this.batter = Type.CAKE;
		this.icing = Type.ICING;
	}
}
