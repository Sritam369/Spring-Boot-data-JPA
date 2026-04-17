package com.sri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Address;
import com.sri.entity.Employee;
import com.sri.repository.AddressRepo;
import com.sri.repository.EmployeeRepo;

import lombok.NonNull;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	@Autowired
	private AddressRepo repo2;
	
	public String addEmployee(Employee emp) {
		return " employee saved with id: "+repo.save(emp).getId();
	}
	
	public List<Employee> fetchEmployee(){
		List<Employee> all = repo.findAll();
		return all;
	}
	
	public String updateEmployee(Long eid,String name,String city,String state) {
		Optional<Employee> byId = repo.findById(eid);
		if(byId.isEmpty()) {
			return "no record found with given id "+eid;
		}
		else {
			Employee employee = byId.get();
			employee.setName(name);
			List<Address> addr = employee.getAddr();
			addr.forEach(add->{
				add.setCity(city);
				add.setState(state);
			});
			
			employee.setAddr(addr);
			
			 repo.save(employee);
			 return "employee updated";	
				
		}
	}
	
	public String deleteEmployee(Long id) {
	    Employee employee = repo.findById(id).get();	
	    if(employee!=null) {
	    	repo.delete(employee);
	    	return "employee with id "+id+" deleted";
	    }
	    else {
	    	return "employee not found";
	    }
	}
}
