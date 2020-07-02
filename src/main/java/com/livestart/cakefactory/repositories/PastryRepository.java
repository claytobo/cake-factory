package com.livestart.cakefactory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livestart.cakefactory.repositories.entities.PastryEntity;

public interface PastryRepository extends JpaRepository<PastryEntity, Long> {

}
