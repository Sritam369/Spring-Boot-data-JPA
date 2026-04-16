package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
