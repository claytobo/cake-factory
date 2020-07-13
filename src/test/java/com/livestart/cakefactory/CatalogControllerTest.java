package com.livestart.cakefactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Collections;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.livestart.cakefactory.controllers.IndexCakeController;
import com.livestart.cakefactory.repositories.pojos.CatalogPojo;
import com.livestart.cakefactory.services.CatalogService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = IndexCakeController.class)
class CatalogControllerTest {

	private WebClient webClient;

	@Autowired
	MockMvc mockMvc;

	@MockBean
	CatalogService catalogService;

	@BeforeEach
	void setUp() {
		this.webClient = MockMvcWebClientBuilder.mockMvcSetup(mockMvc).build();
	}

	@Test
	@DisplayName("index page returns the landing page")
	void returnsLandingPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Cake Factory")));
	}

	@Test
	@DisplayName("index page return a list of items from the database")
	void returnsListOfItemsFromDb() throws Exception {
		final String expectedCode = "rv";
		final String expectedTitle = "Red Velvet";
		mockItems(expectedCode, expectedTitle, BigDecimal.valueOf(3));

		HtmlPage page = webClient.getPage("http://localhost/");

		assertThat(page.querySelectorAll(".list-group-item")).anyMatch(domElement -> expectedTitle.equals(domElement.asText()));
	}

	private void mockItems(String code, String name, BigDecimal price) {
		when(catalogService.getAllItems()).thenReturn(Collections.singletonList(new CatalogPojo(code, name, price)));
	}
	
	@Test
	@DisplayName("index page is indeed the Cake Factory home page")
	public void homePageTitle() throws Exception {
		HtmlPage page = webClient.getPage("http://localhost:8080/");
		assertThat(page.getTitleText()).isEqualTo("The Cake Factory Home Page");
	}

	
	@Test
	@DisplayName("index page contains the Pick a Pastry section")
	public void homePageCategory() throws Exception {
		HtmlPage page = webClient.getPage("http://localhost:8080/");
		DomNode node = page.querySelector("div.col-lg-3");
		assertThat(node.asText()).contains("Pick a Pastry!");
	}
	
}
