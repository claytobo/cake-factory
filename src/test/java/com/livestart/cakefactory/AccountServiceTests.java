package com.livestart.cakefactory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.livestart.cakefactory.repositories.entities.Authorities;
import com.livestart.cakefactory.repositories.entities.Users;
import com.livestart.cakefactory.services.AccountService;

@SpringBootTest
public class AccountServiceTests {
	@Autowired
	private AccountService accountService;
	
	@Test
	@DisplayName("test that the application context loads the AccountService")
	public void serviceLoads() throws Exception {
		assertThat(accountService).isNotNull();
	}
	
	@Test
	@DisplayName("test that the application can add and remove authorities")
	public void serviceAddsRemovesAuthority() throws Exception {
		Authorities authorities = new Authorities();
		authorities.setAuthority("USER");
		authorities.setUsername("cbodine@msn.com");
		
		long count = accountService.countAuthorities();
		accountService.saveAuthorities(authorities);
		assertThat(count).isLessThan(accountService.countAuthorities());
		
		accountService.deleteAuthorities(authorities);
		assertThat(count).isEqualTo(accountService.countAuthorities());
	}
	
	@Test
	@DisplayName("test that the application can add and remove users")
	public void serviceAddsRemovesUsers() throws Exception {
		Users users = new Users();
		users.setEnabled(true);
		users.setPassword("r@msg@t3");
		users.setUsername("nicholas.bodine@gmail.com");
		
		long count = accountService.countUsers();
		accountService.saveUsers(users);
		assertThat(count).isLessThan(accountService.countUsers());
		
		accountService.deleteUsers(users);
		assertThat(count).isEqualTo(accountService.countUsers());
	}
}
