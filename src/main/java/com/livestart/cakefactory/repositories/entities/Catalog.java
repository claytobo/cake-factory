package com.livestart.cakefactory.repositories.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "catalog")
@Table(name = "catalog", schema = "cakefactory")
public class Catalog {
	@Id
	@Column(length = 10, nullable = false)
	private String id;
	@Column(length = 20)
	private String name;
	private BigDecimal price;
	
	public String getId() {
		return id;
	}
	public void setId(String code) {
		this.id = code;
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
}
