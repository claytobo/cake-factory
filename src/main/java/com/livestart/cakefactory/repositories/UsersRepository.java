package com.livestart.cakefactory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livestart.cakefactory.repositories.entities.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

}
