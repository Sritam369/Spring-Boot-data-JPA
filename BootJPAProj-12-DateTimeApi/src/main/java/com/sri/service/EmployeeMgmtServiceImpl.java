package com.sri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Employee_Date_Time;
import com.sri.repository.EmployeeDateTimeRepo;

@Service
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	@Autowired
	private EmployeeDateTimeRepo repo;
	
	@Override
	public String saveEmployee(Employee_Date_Time dateTime) {
		return "employee record is saved with id value: "+repo.save(dateTime).getEno();
	}

	@Override
	public List<Employee_Date_Time> getAllEmployees() {
		List<Employee_Date_Time> all = repo.findAll();
		return all;
	}

	@Override
	public List<Integer> showEmployeeAgesByDesg(String desg) {
		List<Integer> employeeAgesByDesg = repo.getEmployeeAgesByDesg(desg);
		return employeeAgesByDesg;
	}

}
