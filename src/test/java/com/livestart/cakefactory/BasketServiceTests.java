package com.livestart.cakefactory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.livestart.cakefactory.services.BasketService;

@SpringBootTest
public class BasketServiceTests {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BasketService service;
	
	@BeforeEach
	public void clearBasket() throws Exception {
		logger.info("clearBasket called!");
		service.removeAllItems();
		assertThat(service.countItems()).isEqualTo(0);
	}
	
	@Test
	@DisplayName("test that the application context loads the BasketService")
	public void serviceLoads() throws Exception {
		assertThat(service).isNotNull();
	}
	
	@Test
	@DisplayName("test that the BasketService correctly adds an item to the basket")
	public void addItem() throws Exception {
		service.addItem("rv");
		assertThat(service.countItems()).isEqualTo(1);
		assertThat(service.getTotal()).isEqualTo(3.95);
	}
	
	@Test
	@DisplayName("test that the BasketService correctly removes an item from the basket")
	public void removeItem() throws Exception {
		service.addItem("rv");
		assertThat(service.countItems()).isEqualTo(1);
		service.removeItem("rv");
		assertThat(service.countItems()).isEqualTo(0);
	}
	
	@Test
	@DisplayName("test that the BasketService correctly adds multiple items")
	public void addItems() throws Exception {
		service.addItem("abcr");
		service.addItem("ccr");
		service.addItem("b");
		service.addItem("rv");
		assertThat(service.getTotal()).isEqualTo(7.25);
	}
	
	@Test
	@DisplayName("test that the BasketService correctly adds duplicate items")
	public void addDuplicateItems() throws Exception {
		for (int i = 0; i < 10; i++) {
			service.addItem("ccr");
		}
		assertThat(service.getTotal()).isEqualTo(9.5);
	}
	
	@Test
	@DisplayName("test that the BasketService can safely remove a duplicate item")
	public void removeDuplicateItem() throws Exception {
		for (int i = 0; i < 10; i++) {
			service.addItem("ccr");
		}
		assertThat(service.getTotal()).isEqualTo(9.5);
		service.removeItem("ccr");
		assertThat(service.getTotal()).isEqualTo(8.55);
	}
}
