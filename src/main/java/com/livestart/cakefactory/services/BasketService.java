package com.livestart.cakefactory.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livestart.cakefactory.repositories.pojos.Basket;
import com.livestart.cakefactory.repositories.pojos.CatalogPojo;

@Service("BasketService")
public class BasketService {
	@Autowired
	private Basket basket;
	
	private Map<String, CatalogPojo> items;
	private double basketTotal = 0.0;
	
	public BasketService(CatalogService service) {
		items = new HashMap<>();
		List<CatalogPojo> allItems = service.getAllItems();
		allItems.forEach(item -> {
			items.put(item.getCode(), item);
		});
	}
	
	public void addItem(String id) {
		// look up the item
		CatalogPojo catalogPojo = items.get(id);
		if (catalogPojo != null) {
			// the item exists so add it to the basket
			basket.add(catalogPojo);
		}
		// calculate the amount contained in the basket
		total();
	}
	
	public void removeItem(String id) {
		// get the actual item from the code
		CatalogPojo catalogPojo = items.get(id);
		if (catalogPojo != null) {
			// see if the item is in the basket
			if (basket.contains(catalogPojo)) {
				basket.remove(catalogPojo);
			}
		}
		// calculate the amount contained in the basket
		total();
	}
	
	public void removeAllItems() {
		// get a list of codes
		List<String> codes = new ArrayList<>();
		basket.forEach(item -> {
			codes.add(item.getCode());
		});
		// now loop through the codes and remove each code from the basket
		// this is done in this manner to avoid a ConcurrentModificationException
		codes.forEach(code -> {
			removeItem(code);
		});
	}
	
	public int countItems() {
		return basket.size();
	}
	
	public double getTotal() {
		return basketTotal;
	}
	
	public List<CatalogPojo> getBasketItems() {
		// clone the basket
		List<CatalogPojo> clonedBasket = new ArrayList<>();
		basket.forEach(item -> {
			clonedBasket.add(item);
		});
		Collections.sort(clonedBasket);
		return clonedBasket;
	}
	
	private void total() {
		basketTotal = 0.0;
		basket.forEach(item -> {
			basketTotal += item.getPrice();
		});
	}
}
