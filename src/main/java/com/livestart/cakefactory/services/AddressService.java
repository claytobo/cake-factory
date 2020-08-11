package com.livestart.cakefactory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.livestart.cakefactory.repositories.AddressesRepository;
import com.livestart.cakefactory.repositories.entities.Addresses;

@Service
public class AddressService {
	@Autowired
	AddressesRepository repository;

	public <S extends Addresses> S save(S entity) {
		return repository.save(entity);
	}

	public <S extends Addresses> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	public Page<Addresses> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<Addresses> findAll() {
		return repository.findAll();
	}

	public List<Addresses> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public List<Addresses> findAllById(Iterable<String> ids) {
		return repository.findAllById(ids);
	}

	public <S extends Addresses> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	public Optional<Addresses> findById(String id) {
		return repository.findById(id);
	}

	public void flush() {
		repository.flush();
	}

	public <S extends Addresses> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	public boolean existsById(String id) {
		return repository.existsById(id);
	}

	public void deleteInBatch(Iterable<Addresses> entities) {
		repository.deleteInBatch(entities);
	}

	public <S extends Addresses> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	public Addresses getOne(String id) {
		return repository.getOne(id);
	}

	public <S extends Addresses> long count(Example<S> example) {
		return repository.count(example);
	}

	public <S extends Addresses> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	public <S extends Addresses> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	public long count() {
		return repository.count();
	}

	public void deleteById(String id) {
		repository.deleteById(id);
	}

	public <S extends Addresses> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	public void delete(Addresses entity) {
		repository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Addresses> entities) {
		repository.deleteAll(entities);
	}

	public void deleteAll() {
		repository.deleteAll();
	}
}
