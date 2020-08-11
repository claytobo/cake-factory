package com.livestart.cakefactory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.livestart.cakefactory.repositories.AuthoritiesRepository;
import com.livestart.cakefactory.repositories.UsersRepository;
import com.livestart.cakefactory.repositories.entities.Authorities;
import com.livestart.cakefactory.repositories.entities.Users;

@Service
public class AccountService {
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	@Autowired
	private UsersRepository usersRepository;

	public <S extends Authorities> S saveAuthorities(S entity) {
		return authoritiesRepository.save(entity);
	}

	public <S extends Authorities> Optional<S> findOneAuthorities(Example<S> example) {
		return authoritiesRepository.findOne(example);
	}

	public Page<Authorities> findAllAuthorities(Pageable pageable) {
		return authoritiesRepository.findAll(pageable);
	}

	public List<Authorities> findAllAuthorities() {
		return authoritiesRepository.findAll();
	}

	public List<Authorities> findAllAuthorities(Sort sort) {
		return authoritiesRepository.findAll(sort);
	}

	public List<Authorities> findAllAuthoritiesById(Iterable<String> ids) {
		return authoritiesRepository.findAllById(ids);
	}

	public <S extends Authorities> List<S> saveAllAuthorities(Iterable<S> entities) {
		return authoritiesRepository.saveAll(entities);
	}

	public Optional<Authorities> findAuthoritiesById(String id) {
		return authoritiesRepository.findById(id);
	}

	public void flushAuthorities() {
		authoritiesRepository.flush();
	}

	public <S extends Authorities> S saveAuthoritiesAndFlush(S entity) {
		return authoritiesRepository.saveAndFlush(entity);
	}

	public boolean authoritiesExistsById(String id) {
		return authoritiesRepository.existsById(id);
	}

	public void deleteAuthoritiesInBatch(Iterable<Authorities> entities) {
		authoritiesRepository.deleteInBatch(entities);
	}

	public <S extends Authorities> Page<S> findAllAuthorities(Example<S> example, Pageable pageable) {
		return authoritiesRepository.findAll(example, pageable);
	}

	public void deleteAuthoritiesAllInBatch() {
		authoritiesRepository.deleteAllInBatch();
	}

	public Authorities getOneAuthorities(String id) {
		return authoritiesRepository.getOne(id);
	}

	public <S extends Authorities> long countAuthorities(Example<S> example) {
		return authoritiesRepository.count(example);
	}

	public <S extends Authorities> boolean authoritiesExists(Example<S> example) {
		return authoritiesRepository.exists(example);
	}

	public <S extends Authorities> List<S> findAllAuthorities(Example<S> example) {
		return authoritiesRepository.findAll(example);
	}

	public long countAuthorities() {
		return authoritiesRepository.count();
	}

	public void deleteAuthoritiesById(String id) {
		authoritiesRepository.deleteById(id);
	}

	public <S extends Authorities> List<S> findAllAuthorities(Example<S> example, Sort sort) {
		return authoritiesRepository.findAll(example, sort);
	}

	public void deleteAuthorities(Authorities entity) {
		authoritiesRepository.delete(entity);
	}

	public void deleteAllAuthorities(Iterable<? extends Authorities> entities) {
		authoritiesRepository.deleteAll(entities);
	}

	public void deleteAllAuthorities() {
		authoritiesRepository.deleteAll();
	}

	public <S extends Users> S saveUsers(S entity) {
		return usersRepository.save(entity);
	}

	public <S extends Users> Optional<S> findOneUsers(Example<S> example) {
		return usersRepository.findOne(example);
	}

	public Page<Users> findAllUsers(Pageable pageable) {
		return usersRepository.findAll(pageable);
	}

	public List<Users> findAllUsers() {
		return usersRepository.findAll();
	}

	public List<Users> findAllUsers(Sort sort) {
		return usersRepository.findAll(sort);
	}

	public List<Users> findAllUsersById(Iterable<String> ids) {
		return usersRepository.findAllById(ids);
	}

	public <S extends Users> List<S> saveAllUsers(Iterable<S> entities) {
		return usersRepository.saveAll(entities);
	}

	public Optional<Users> findUsersById(String id) {
		return usersRepository.findById(id);
	}

	public void flushUsers() {
		usersRepository.flush();
	}

	public <S extends Users> S saveAndFlushUsers(S entity) {
		return usersRepository.saveAndFlush(entity);
	}

	public boolean usersExistsById(String id) {
		return usersRepository.existsById(id);
	}

	public void deleteUsersInBatch(Iterable<Users> entities) {
		usersRepository.deleteInBatch(entities);
	}

	public <S extends Users> Page<S> findAllUsers(Example<S> example, Pageable pageable) {
		return usersRepository.findAll(example, pageable);
	}

	public void deleteAllUsersInBatch() {
		usersRepository.deleteAllInBatch();
	}

	public Users getOneUsers(String id) {
		return usersRepository.getOne(id);
	}

	public <S extends Users> long countUsers(Example<S> example) {
		return usersRepository.count(example);
	}

	public <S extends Users> boolean usersExists(Example<S> example) {
		return usersRepository.exists(example);
	}

	public <S extends Users> List<S> findAllUsers(Example<S> example) {
		return usersRepository.findAll(example);
	}

	public long countUsers() {
		return usersRepository.count();
	}

	public void deleteUsersById(String id) {
		usersRepository.deleteById(id);
	}

	public <S extends Users> List<S> findAllUsers(Example<S> example, Sort sort) {
		return usersRepository.findAll(example, sort);
	}

	public void deleteUsers(Users entity) {
		usersRepository.delete(entity);
	}

	public void deleteAllUsers(Iterable<? extends Users> entities) {
		usersRepository.deleteAll(entities);
	}

	public void deleteAllUsers() {
		usersRepository.deleteAll();
	}
	
}
