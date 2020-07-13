package com.livestart.cakefactory;

import java.math.BigDecimal;

import com.livestart.cakefactory.repositories.CatalogRepository;
import com.livestart.cakefactory.repositories.PastryRepository;
import com.livestart.cakefactory.repositories.entities.Catalog;
import com.livestart.cakefactory.repositories.pojos.CatalogPojo;
import com.livestart.cakefactory.services.CatalogService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("/application.yaml")
class JpaCatalogServiceTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    CatalogRepository itemRepository;
    
    @Autowired
    PastryRepository pastryRepository;

    private CatalogService jpaCatalogService;

    @BeforeEach
    void setup() {
        this.jpaCatalogService = new CatalogService(this.pastryRepository, this.itemRepository);
    }

    @Test
    @DisplayName("returns data from the database")
    void returnsDataFromDatabase() {
        String expectedTitle = "Victoria Sponge";
        saveTestItem(expectedTitle, BigDecimal.valueOf(5.55));

        Iterable<CatalogPojo> items = jpaCatalogService.getAllItems();

        org.assertj.core.api.Assertions.assertThat(items).anyMatch(item -> expectedTitle.equals(item.getName()));
    }

    private void saveTestItem(String title, BigDecimal price) {
        Catalog itemEntity = new Catalog();
        itemEntity.setId("test-vs");
        itemEntity.setName(title);
        itemEntity.setPrice(price);
        testEntityManager.persistAndFlush(itemEntity);
    }

}