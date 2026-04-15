package com.sri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Employee;
import com.sri.repository.EmployeeCollectionRepo;

@Service
public class EmployeeService implements EmployeeCollectionService {

	@Autowired
	private EmployeeCollectionRepo repo;
	
	@Override
	public String registerEmployee(Employee emp) {
		return "Employee record saved with id value : "+repo.save(emp).getId();
	}

	@Override
	public List<Employee> showAllEmployees() {
		List<Employee> all = repo.findAll();
		return all;
	}

}
