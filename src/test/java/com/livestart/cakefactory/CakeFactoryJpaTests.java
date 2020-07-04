package com.livestart.cakefactory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.livestart.cakefactory.repositories.PastryRepository;
import com.livestart.cakefactory.repositories.entities.Pastry;

@DataJpaTest
public class CakeFactoryJpaTests {
	@Autowired
    private TestEntityManager entityManager;

	@Autowired
	private PastryRepository repository;
	
	@Test
	public void insertRecord() {
		Pastry pe = new Pastry();
		pe.setName("Banana Cream Pie");
		pe.setPrice(15.00);
		entityManager.persist(pe);

		long count = repository.count();
		assertThat(count).isGreaterThan(0);
	}
	
	@Test
	public void someTests() throws Exception {
		long count = repository.count();
		assertThat(count).isGreaterThan(0);
	}
}
