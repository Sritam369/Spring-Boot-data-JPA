package com.sri.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Employee_Date_Time;
import com.sri.service.EmployeeMgmtService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private EmployeeMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		Employee_Date_Time emp = new Employee_Date_Time("sritam","developer",LocalDateTime.of(2001,8,18,13,10),LocalTime.of(17, 45),LocalDate.of(2026, 7, 24));
		IO.println(service.saveEmployee(emp));
		
		List<Employee_Date_Time> allEmployees = service.getAllEmployees();
		if(allEmployees.size()>0) {
			allEmployees.forEach(IO::println);
		}
		else {
			IO.println("no records found");
		}
		
		List<Integer> showEmployeeAgesByDesg = service.showEmployeeAgesByDesg("developer");
		showEmployeeAgesByDesg.forEach(IO::println);

	}

}
