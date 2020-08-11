package com.livestart.cakefactory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livestart.cakefactory.repositories.entities.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {

}
