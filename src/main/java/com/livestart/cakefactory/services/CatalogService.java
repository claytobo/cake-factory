package com.livestart.cakefactory.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.livestart.cakefactory.assist.Pastry;
import com.livestart.cakefactory.interfaces.IPastryCatalog;
import com.livestart.cakefactory.repositories.PastryRepository;

@Service("CatalogService")
public class CatalogService implements IPastryCatalog {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private PastryRepository repository;
	
	public CatalogService(PastryRepository repo) {
		this.repository = repo;
	}
	
	@Override
	public List<Pastry> getAllPastries() {
		logger.info("inside getAllPastries()");
		List<Pastry> pastries = new ArrayList<>();
		repository.findAll().forEach(e -> {
			logger.info("pastry: {} = {}", e.getName(), e.getPrice());
			Pastry pastry = new Pastry(e.getName(), e.getPrice());
			pastries.add(pastry);
		});
		return pastries;
	}

}
