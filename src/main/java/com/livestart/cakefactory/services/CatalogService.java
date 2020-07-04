package com.livestart.cakefactory.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.livestart.cakefactory.interfaces.ICatalog;
import com.livestart.cakefactory.interfaces.IPastryCatalog;
import com.livestart.cakefactory.repositories.CatalogRepository;
import com.livestart.cakefactory.repositories.PastryRepository;
import com.livestart.cakefactory.repositories.pojos.CatalogPojo;
import com.livestart.cakefactory.repositories.pojos.PastryPojo;

@Service("CatalogService")
public class CatalogService implements IPastryCatalog, ICatalog {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private PastryRepository repository;
	private CatalogRepository categoryRepository;
	
	public CatalogService(PastryRepository repo, CatalogRepository cr) {
		this.repository = repo;
		this.categoryRepository = cr;
	}
	
	@Override
	public List<PastryPojo> getAllPastries() {
		logger.info("inside getAllPastries()");
		List<PastryPojo> pastries = new ArrayList<>();
		repository.findAll().forEach(e -> {
			logger.info("pastry: {} = {}", e.getName(), e.getPrice());
			PastryPojo pastry = new PastryPojo(e);
			pastries.add(pastry);
		});
		return pastries;
	}

	@Override
	public List<CatalogPojo> getAllItems() {
		logger.info("inside getAllItems()");
		List<CatalogPojo> items = new ArrayList<>();
		categoryRepository.findAll().forEach(action -> {
			logger.info("catalog item: {}/t{}/t{}", action.getId(), action.getName(), action.getPrice());
			CatalogPojo item = new CatalogPojo(action);
			items.add(item);
		});
		return items;
	}

}
