package com.sri.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Address;
import com.sri.entity.Employee;
import com.sri.service.EmployeeService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private EmployeeService serv;
	
	@Override
	public void run(String... args) throws Exception {
		Address add1 = new Address();
		add1.setCity("hyd");
		add1.setState("telengana");
		Address add2 = new Address();
		add2.setCity("chennai");
		add2.setState("tamilnadu");
		
		Employee emp = new Employee();
		emp.setName("sritam");
	    add1.setEmp(emp);
	    add2.setEmp(emp);
	    emp.setAddr(List.of(add1,add2));
	    
	    IO.println(serv.addEmployee(emp));

	}

}
