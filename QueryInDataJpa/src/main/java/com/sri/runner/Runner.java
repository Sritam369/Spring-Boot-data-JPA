package com.sri.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Employee;
import com.sri.repository.EmployeeRepo;
@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private EmployeeRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
         
		while(true) {
			IO.println("1. add employee");
			IO.println("2. search employee by department");
			IO.println("3. search employee with greater salary");
			IO.println("4. search employee by name");
			IO.println("5. exit");
			
			int choice = Integer.parseInt(IO.readln("enter choice"));
			
			if(choice==1) {
				int size = Integer.parseInt(IO.readln("enter how many employees "));
				for(int i=1;i<=size;i++) {
					Employee emp = new Employee();
					emp.setName(IO.readln("enter name"));;
					emp.setDepartment(IO.readln("enter department"));
					emp.setSalary(Double.parseDouble(IO.readln("enter salary")));
					
					List<Employee> list = new ArrayList<>();
					list.add(emp);
					
					List<Employee> saveAll = repo.saveAll(list);
					IO.println(saveAll.size()+" employees added");
				}

			}
			else if(choice==2) {
				List<Employee> employeesByDept = repo.findEmployeesByDept(IO.readln("enter department"));
				employeesByDept.forEach(IO::println);
			}
			else if(choice==3) {
				repo.findEmployeeWithGreaterSal(Double.parseDouble(IO.readln("enter sal"))).forEach(IO::println);
			}
			else if(choice==4) {
				repo.findByName(IO.readln("enter name")).forEach(IO::println);
			}
			else if(choice==5) {
				System.exit(0);
			}
			
		}

	}

}
