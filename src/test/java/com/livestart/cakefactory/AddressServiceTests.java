package com.livestart.cakefactory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.livestart.cakefactory.repositories.entities.Addresses;
import com.livestart.cakefactory.services.AddressService;

@SpringBootTest
public class AddressServiceTests {
	@Autowired
	private AddressService addressService;
	
	@Test
	@DisplayName("test that the application context loads the AddressService")
	public void serviceLoads() throws Exception {
		assertThat(addressService).isNotNull();
	}
	
	@Test
	@DisplayName("test that the application adds and removes a single address")
	public void serviceAddsRemovesAddress() throws Exception {
		Addresses addresses = new Addresses();
		addresses.setCity("Galveston");
		addresses.setEmail("cecil.jackson@gmail.com");
		addresses.setFirstname("Cecil");
		addresses.setLastname("Jackson");
		addresses.setState("texas");
		addresses.setStreet("1310 25 Street");
		addresses.setZip("77550");
		
		long count = addressService.count();
		addressService.save(addresses);
		assertThat(count).isLessThan(addressService.count());
		addressService.delete(addresses);
		assertThat(count).isEqualTo(addressService.count());
	}
}
