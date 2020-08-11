package com.livestart.cakefactory.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.livestart.cakefactory.repositories.pojos.Register;
import com.livestart.cakefactory.repositories.pojos.Signup;
import com.livestart.cakefactory.services.SignupService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SignupService signupService;

	@GetMapping
	public void show(Model model) {
		logger.info("on the registration page");
		model.addAttribute("signup", new Signup());
		model.addAttribute("register", new Register());
	}
	
	@PostMapping
	public String registerUser(@ModelAttribute Register register, Model model) {
		logger.info("RegistrationController received a post");
		logger.info(register.toString());
		signupService.register(register);
		return "index";
	}
}
