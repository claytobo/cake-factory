package com.livestart.cakefactory.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.livestart.cakefactory.services.BasketService;
import com.livestart.cakefactory.services.CatalogService;

@Controller
@RequestMapping("/")
public class IndexCakeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BasketService basketService;
	
	@Autowired
	private CatalogService service;

	@GetMapping
	public String showDesignForm(Model model) {
		logger.info("inside IndexCakeController::showDesignForm");
		model.addAttribute("PASTRIES", service.getAllPastries());
		model.addAttribute("CATALOG", service.getAllItems());
		model.addAttribute("BASKET_COUNT", basketService.countItems());
		return "index";
	}

}
