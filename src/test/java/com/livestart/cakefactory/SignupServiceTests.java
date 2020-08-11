package com.livestart.cakefactory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.livestart.cakefactory.repositories.pojos.Register;
import com.livestart.cakefactory.services.SignupService;

@SpringBootTest
public class SignupServiceTests {
	@Autowired
	private SignupService signupService;
	
	@Test
	@DisplayName("test that the application context loads the AddressService")
	public void serviceLoads() throws Exception {
		assertThat(signupService).isNotNull();
	}
	
	@Test
	@DisplayName("test that the application can register and unregister a customer")
	public void serviceRegistersAndUnregisters() throws Exception {
		Register register = new Register();
		register.setCity("Aldie");
		register.setEmail("lamaibodine@msn.com");
		register.setFirstName("Lamai");
		register.setLastName("Bodine");
		register.setPassword("r@msg@t3");
		register.setState("virginia");
		register.setStreet("25223 Mastery Place");
		register.setZip("20105");
		
		long count = signupService.count();
		signupService.register(register);
		assertThat(count).isLessThan(signupService.count());
		
		signupService.remove("lamaibodine@msn.com");
		assertThat(count).isEqualTo(signupService.count());
	}
}
