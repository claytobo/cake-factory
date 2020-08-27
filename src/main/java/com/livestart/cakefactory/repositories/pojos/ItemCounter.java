package com.livestart.cakefactory.repositories.pojos;

public class ItemCounter {
	private String item;
	private String code;
	private int quantity;
	private double pricePerItem;
	
	public ItemCounter(String item, String code, double pricePerItem) {
		super();
		this.item = item;
		this.code = code;
		this.pricePerItem = pricePerItem;
	}
	
	public String getItem() {return item;}
	public void setItem(String item) {this.item = item;}
	
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}

	public int getQuantity() {return quantity;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	
	public double getPricePerItem() {return pricePerItem;}
	public void setPricePerItem(double pricePerItem) {this.pricePerItem = pricePerItem;}

	public double getSubtotal() {
		return this.quantity * this.pricePerItem;
	}
	
	public void incrementCount() {
		this.quantity++;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pricePerItem);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemCounter)) {
			return false;
		}
		ItemCounter other = (ItemCounter) obj;
		if (item == null) {
			if (other.item != null) {
				return false;
			}
		} else if (!item.equals(other.item)) {
			return false;
		}
		if (Double.doubleToLongBits(pricePerItem) != Double.doubleToLongBits(other.pricePerItem)) {
			return false;
		}
		if (quantity != other.quantity) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemCounter [Item=");
		builder.append(item);
		builder.append(", Quantity=");
		builder.append(quantity);
		builder.append(", Price Per Item=");
		builder.append(pricePerItem);
		builder.append(", Subtotal=");
		builder.append(getSubtotal());
		builder.append("]");
		return builder.toString();
	}
}
