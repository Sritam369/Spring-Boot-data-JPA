package com.sri.repository;

import org.springframework.data.repository.CrudRepository;

import com.sri.Entity.FoodOrder;

public interface FoodOrderRepository extends CrudRepository<FoodOrder, Long> {

}
