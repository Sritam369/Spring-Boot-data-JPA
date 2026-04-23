package com.sri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Department;
import com.sri.entity.Employee;
import com.sri.repository.DepartmentRepo;
import com.sri.repository.EmployeeRepo;

@Service
public class OfficeService {

	@Autowired
	private EmployeeRepo eRepo;
	@Autowired
	private DepartmentRepo dRepo;
	
	public String saveDepartment(Department dept) {
		Department save = dRepo.save(dept);
		if(save!=null) {
			return "department saved";
		}
		else {
			return "department not saved";
		}
	}
	
	public List<Object[]> fetchCommonData() {
		List<Object[]> fetchOnlyCommonData = dRepo.fetchOnlyCommonData();
		return fetchOnlyCommonData;
	}
}
