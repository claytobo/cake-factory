package com.livestart.cakefactory.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.WebApplicationContext;

import com.livestart.cakefactory.repositories.pojos.Basket;
import com.livestart.cakefactory.repositories.pojos.Order;

@Configuration
public class ApplicationBeans {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Basket createBasket() {
		return new Basket();
	}

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Order createOrder() {
		return new Order();
	}

	@Bean
	public BCryptPasswordEncoder securityPasswordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		logger.info(String.format("ApplicationBeans::securityPasswordEncoder encrypted password = %s", encoder.encode("r@msg@t3")));
		return encoder;
	};
}
