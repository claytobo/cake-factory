package com.livestart.cakefactory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.livestart.cakefactory.services.CatalogService;

@Controller
@RequestMapping("/")
public class IndexCakeController {
	@Autowired
	private CatalogService service;

	@GetMapping
	public String showDesignForm(Model model) {
		model.addAttribute("PASTRIES", service.getAllPastries());
		return "index";
	}

}
