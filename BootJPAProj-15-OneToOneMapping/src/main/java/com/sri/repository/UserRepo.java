package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
