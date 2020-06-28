package com.livestart.cakefactory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.livestart.cakefactory.controllers.DesignCakeController;

@SpringBootTest
class CakeFactoryApplicationTests {
	@Autowired
	private DesignCakeController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
