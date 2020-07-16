package com.livestart.cakefactory.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.livestart.cakefactory.services.BasketService;

@Controller
@RequestMapping("/basket")
public class BasketController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private BasketService basketService;
	
	public BasketController(BasketService service) {
		this.basketService = service;
	}
	
	@GetMapping(value = "/add/{id}")
	public ModelAndView addItemToBasket(@PathVariable("id") String id, ModelMap model) {
		basketService.addItem(id);
		logger.info("BasketService added item " + id);
		model.addAttribute("BASKET_COUNT", basketService.countItems());
		model.addAttribute("BASKET_PRICE", basketService.getTotal());
		model.addAttribute("BASKET_ITEMS", basketService.getBasketItems());
		model.addAttribute("attribute", "index");
		logger.info("Model Basket Count: " + model.getAttribute("BASKET_COUNT"));
		logger.info("Model Basket Price: " + model.getAttribute("BASKET_PRICE"));
		return new ModelAndView("redirect:/", model);
	}
	
	@GetMapping(value = "/subtract/{id}")
	public ModelAndView removeItemFromBasket(@PathVariable("id") String id, ModelMap model) {
		basketService.removeItem(id);
		model.addAttribute("BASKET_COUNT", basketService.countItems());
		model.addAttribute("BASKET_PRICE", basketService.getTotal());
		model.addAttribute("BASKET_ITEMS", basketService.getBasketItems());
		return new ModelAndView("redirect:/basket", model);
	}
	
	@GetMapping
	public String showBasket(Model model) {
		logger.info("user called BasketController::showBasket");
		model.addAttribute("BASKET_COUNT", basketService.countItems());
		model.addAttribute("BASKET_PRICE", basketService.getTotal());
		model.addAttribute("BASKET_ITEMS", basketService.getBasketItems());
		logger.info("Model Basket Count: " + model.getAttribute("BASKET_COUNT"));
		logger.info("Model Basket Price: " + model.getAttribute("BASKET_PRICE"));
		return "basket";
	}
}
