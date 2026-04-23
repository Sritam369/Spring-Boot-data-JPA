package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
