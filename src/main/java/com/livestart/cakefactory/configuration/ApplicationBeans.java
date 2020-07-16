package com.livestart.cakefactory.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import com.livestart.cakefactory.repositories.pojos.Basket;

@Configuration
public class ApplicationBeans {
	
	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Basket createBasket() {
		return new Basket();
	}

}
