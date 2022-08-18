package com.douglasfelc.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglasfelc.springboot.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
