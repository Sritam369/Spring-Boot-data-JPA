package com.sri.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Employee;
import com.sri.service.EmployeeCollectionService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private EmployeeCollectionService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		Employee emp = new Employee("sritam","hyd",List.of("subrat","hemant","jeevan","konda"),Set.of(999999l,888888l,777777l),Map.of("aadhar","456fd57f","passport","5454fh5ds"));
		IO.println(service.registerEmployee(emp));
		
		service.showAllEmployees().forEach(IO::println);
		
	}

}
