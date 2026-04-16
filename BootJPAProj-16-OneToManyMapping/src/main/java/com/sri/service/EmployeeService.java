package com.sri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Employee;
import com.sri.repository.AddressRepo;
import com.sri.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	@Autowired
	private AddressRepo repo2;
	
	public String addEmployee(Employee emp) {
		return " employee saved with id: "+repo.save(emp).getId();
	}
}
