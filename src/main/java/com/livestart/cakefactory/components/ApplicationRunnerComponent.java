package com.livestart.cakefactory.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.livestart.cakefactory.repositories.PastryRepository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ApplicationRunnerComponent implements ApplicationRunner {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PastryRepository repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = repo.count();
		logger.info("There are {} items in the repository", count);
	}

}
