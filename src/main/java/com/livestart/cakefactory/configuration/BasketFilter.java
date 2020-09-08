package com.livestart.cakefactory.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import com.livestart.cakefactory.services.BasketService;

@Configuration
public class BasketFilter extends GenericFilterBean {
	private BasketService service;
	
	public BasketFilter(BasketService basketService) {
		this.service = basketService;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setAttribute("FILTER_BASKET_COUNT", service.countItems());
		request.setAttribute("FILTER_BASKET_PRICE", service.getTotal());
		request.setAttribute("FILTER_BASKET_ITEMS", service.getBasketItems());
		chain.doFilter(request, response);
	}

}
