package com.livestart.cakefactory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livestart.cakefactory.repositories.entities.Addresses;

public interface AddressesRepository extends JpaRepository<Addresses, String> {

}
