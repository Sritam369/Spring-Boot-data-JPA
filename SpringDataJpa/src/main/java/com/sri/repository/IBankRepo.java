package com.sri.repository;

import org.springframework.data.repository.CrudRepository;

import com.sri.entity.Bank;

public interface IBankRepo extends CrudRepository<Bank, Integer> {

}
