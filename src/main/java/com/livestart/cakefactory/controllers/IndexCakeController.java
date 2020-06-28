package com.livestart.cakefactory.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.livestart.cakefactory.assist.Cake;
import com.livestart.cakefactory.assist.Ingredient;
import com.livestart.cakefactory.assist.Type;

@Controller
@RequestMapping("/")
public class IndexCakeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("CACK", "Carrot Cake", Type.CAKE),
				new Ingredient("CHCK", "Chocolate Cake", Type.CAKE),
				new Ingredient("COCK", "Coconut Cake", Type.CAKE),
				new Ingredient("GCCK", "German Chocolate Cake", Type.CAKE),
				new Ingredient("LMCK", "Lemon Cake", Type.CAKE), 
				new Ingredient("POCK", "Pound Cake", Type.CAKE),
				new Ingredient("VACK", "Vanilla Cake", Type.CAKE),
				new Ingredient("WHCK", "White Cake", Type.CAKE),
				new Ingredient("VAIC", "Vanilla Icing", Type.ICING), 
				new Ingredient("LMIC", "Lemon Icing", Type.ICING),
				new Ingredient("CHIC", "Chocolate Icing", Type.ICING));

		Type[] types = Type.values();
		for (Type type : types) {
			logger.info("working on the {} type", type.toString());
			List<Ingredient> ing = filterByType(ingredients, type);
			ing.forEach(o -> {
				logger.info("The {} ingredient will be added under the {} category", o.getName(), type.name());
			});
			model.addAttribute(type.toString().toUpperCase(), ing);
		}

		model.addAttribute("design", new Cake());

		model.asMap().forEach((k, v) -> {
			if (v instanceof Cake) {
				logger.info("key {} : {}", k, ((Cake)v).toString());
			}
			else {
				List<Ingredient> ing = (List<Ingredient>) v;
				ing.forEach(ingredient -> {
					logger.info("key {} : {}", k, ingredient.toString());
				});
			}
		});

		return "index";
	}

	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream()
						  .filter(x -> x.getType().equals(type))
						  .collect(Collectors.toList());
	}
}
