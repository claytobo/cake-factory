package com.livestart.cakefactory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.livestart.cakefactory.repositories.entities.Addresses;
import com.livestart.cakefactory.repositories.entities.Authorities;
import com.livestart.cakefactory.repositories.entities.Users;
import com.livestart.cakefactory.repositories.pojos.Register;

@Service
public class SignupService {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AddressService addressService;
	
	public Boolean register(Register register) {
		// create variable to catch exceptions...
		Boolean registered = true;
		// split the register object into DTO entities...
		Users users = new Users();
		users.setEnabled(true);
		users.setPassword(register.getPassword());
		users.setUsername(register.getEmail());
		
		Authorities auths = new Authorities();
		auths.setAuthority("CUSTOMER");
		auths.setUsername(register.getEmail());
		
		Addresses address = new Addresses();
		address.setCity(register.getCity());
		address.setEmail(register.getEmail());
		address.setFirstname(register.getFirstName());
		address.setLastname(register.getLastName());
		address.setState(register.getState());
		address.setStreet(register.getStreet());
		address.setZip(register.getZip());
		
		// add new user to database...
		try {
			accountService.saveUsers(users);
		} catch (Exception e) {
			registered = false;
		}
		
		try {
			accountService.saveAuthorities(auths);
		} catch (Exception e) {
			registered = false;
		}
		
		try {
			addressService.save(address);
		} catch (Exception e) {
			registered = false;
		}
		return registered;
	}
	
	public Boolean remove(String username) {
		// create variable to catch exceptions...
		Boolean removed = true;
		// retrieve entities...
		Users users = accountService.getOneUsers(username);
		Authorities authorities = new Authorities();
		authorities.setUsername(username);
		Example<Authorities> example = Example.of(authorities);
		List<Authorities> list = accountService.findAllAuthorities(example);
		
		Addresses addresses = addressService.getOne(username);
		// now delete these records...
		try {
			accountService.deleteAllAuthorities(list);
		} catch (Exception e) {
			removed = false;
		}
		
		try {
			accountService.deleteUsers(users);
		} catch (Exception e) {
			removed = false;
		}
		
		try {
			addressService.delete(addresses);
		} catch (Exception e) {
			removed = false;
		}
		return removed;
	}
	
	public long count() {
		return accountService.countUsers();
	}
}
