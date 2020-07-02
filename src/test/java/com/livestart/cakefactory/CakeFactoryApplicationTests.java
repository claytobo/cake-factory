package com.livestart.cakefactory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.livestart.cakefactory.controllers.DesignCakeController;

@SpringBootTest
class CakeFactoryApplicationTests {
	@Autowired
	private DesignCakeController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void homePageTitle() throws Exception {
	    try (final WebClient webClient = new WebClient()) {
	        final HtmlPage page = webClient.getPage("http://localhost:8080/");
	        assertThat(page.getTitleText()).isEqualTo("The Cake Factory Home Page");
	    }
	}

	
	@Test
	public void homePageCategory() throws Exception {
	    try (final WebClient webClient = new WebClient()) {
	        final HtmlPage page = webClient.getPage("http://localhost:8080/");
	        DomNode node = page.querySelector("div.col-lg-3");
	        assertThat(node.asText()).contains("Pick a Pastry!");
	    }
	}
	
	@Test
	public void homePagePastry() throws Exception {
	    try (final WebClient webClient = new WebClient()) {
	        final HtmlPage page = webClient.getPage("http://localhost:8080/");
	        DomNode node = page.querySelector("div.col-lg-3");
	        assertThat(node.asText()).contains("Chocolate Cream Pie");
	    }
	}
}
