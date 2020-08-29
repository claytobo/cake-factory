package com.livestart.cakefactory.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.livestart.cakefactory.repositories.entities.Addresses;
import com.livestart.cakefactory.repositories.pojos.Address;
import com.livestart.cakefactory.services.AddressService;

@Controller
@RequestMapping("/account")
public class AccountController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AddressService service;
	
	@GetMapping
	public String showAccount(Model model, Authentication auth) {
		logger.info("inside AccountController::showAccount");
		Addresses address = service.getOne(auth.getName());
		model.addAttribute("ACCOUNT",  new Address(address));
		return "account";
	}
	
	@PostMapping
	public String updateAccount(@ModelAttribute("address") Address address, Authentication auth) {
		Addresses addresses = new Addresses(address);
		addresses.setEmail(auth.getName());
		service.save(addresses);
		return "redirect:/";
	}

}
