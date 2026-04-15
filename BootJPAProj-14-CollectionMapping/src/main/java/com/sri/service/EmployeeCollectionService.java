package com.sri.service;

import java.util.List;

import com.sri.entity.Employee;

public interface EmployeeCollectionService {

	String registerEmployee(Employee emp);
	List<Employee> showAllEmployees();
}
