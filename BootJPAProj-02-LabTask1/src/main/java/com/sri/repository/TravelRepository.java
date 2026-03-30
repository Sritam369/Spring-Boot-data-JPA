package com.sri.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sri.entity.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long> {

}
