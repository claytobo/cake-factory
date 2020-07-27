package com.livestart.cakefactory.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.livestart.cakefactory.repositories.pojos.Basket;
import com.livestart.cakefactory.repositories.pojos.Order;

@Controller("OrderController")
@RequestMapping("/order")
public class OrderController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Basket basket;

	@PostMapping
	public String processOrder(@ModelAttribute("order") Order order) {
		order.setBasket(basket);
		logger.info("Order submitted: " + order.toString());
		return "redirect:/";
	}
}
