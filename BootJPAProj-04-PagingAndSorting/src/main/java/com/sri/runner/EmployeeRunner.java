package com.sri.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.sri.entity.Employeejpa;
import com.sri.service.IEmployeeService;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		while(true) {
			IO.println("1. save employee records");
			IO.println("2. view selected employee records acc to page");
			IO.println("3. view all employee records page wise");
			IO.println("4. exit");
			int choice = Integer.parseInt(IO.readln("enter choice"));
			if(choice==1) {
		int size = Integer.parseInt(IO.readln("Enter how many employees you want to save"));
		List<Employeejpa> list = new ArrayList<>();
		for(int i=1;i<=size;i++) {
			Employeejpa emp = new Employeejpa();
			String name = IO.readln("enter name");
			String dept = IO.readln("enter department");
			Double sal = Double.parseDouble(IO.readln("enter salary"));
			emp.setEmpName(name);
			emp.setDepartment(dept);
			emp.setSalary(sal);
			
			list.add(emp);
			
		}
		IO.println(service.saveEmployees(list));
			}
			else if(choice==2) {
		      Page<Employeejpa> page = service.getEmployeesByPageAndSort(0, 3, true, "empId");
		      List<Employeejpa> content = page.getContent();
		      IO.println("page number : "+page.getNumber());
		      IO.println("page count : "+page.getTotalPages());
		      IO.println("is it first page : "+page.isFirst());
		      IO.println("is it LAST page : "+page.isLast());
		      IO.println("page size : "+page.getSize());
		      IO.println("page elements count : "+page.getNumberOfElements());
		      
		      content.forEach(IO::println);
			}
			else if(choice==3) {
				service.showDataThroughPagination(3);
			}
			else if(choice==4) {
				System.exit(0);
			}
			else {
				IO.println("invalid choice");
			}
	}
	}
}
