package com.livestart.cakefactory.interfaces;

import java.util.List;

import com.livestart.cakefactory.repositories.pojos.PastryPojo;

public interface IPastryCatalog {
	public List<PastryPojo> getAllPastries();
}
