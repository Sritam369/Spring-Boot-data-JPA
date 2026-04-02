package com.sri.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sri.entity.Employeejpa;

public interface EmployeeRepository extends CrudRepository<Employeejpa, Integer>, PagingAndSortingRepository<Employeejpa, Integer> {


}
