package com.livestart.cakefactory.interfaces;

import java.util.List;

import com.livestart.cakefactory.repositories.pojos.CatalogPojo;

public interface ICatalog {
	public List<CatalogPojo> getAllItems();
}
