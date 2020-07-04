package com.livestart.cakefactory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livestart.cakefactory.repositories.entities.Pastry;

public interface PastryRepository extends JpaRepository<Pastry, Long> {

}
