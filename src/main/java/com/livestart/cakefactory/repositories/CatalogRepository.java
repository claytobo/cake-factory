package com.livestart.cakefactory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livestart.cakefactory.repositories.entities.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, String> {

}
