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
		
		while(true) {
			IO.println("1.Add employee");
			IO.println("2.fetch employee");
			IO.println("3.update employee");
			IO.println("4.delete employee");
			IO.println("5.update only employee address");
			IO.println("6.exit");
			int choice = Integer.parseInt(IO.readln("enter choice"));
			
			if(choice==1) {
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
			else if(choice==2) {
				List<Employee> fetchEmployee = serv.fetchEmployee();
				if(fetchEmployee.isEmpty()) {
					IO.println("no records found");
				}
				else {
					fetchEmployee.forEach(IO::println);
				}
			}
			else if(choice==3) {
				Long id = Long.parseLong(IO.readln("enter id"));
				IO.println(serv.updateEmployee(id, "sri", "bls", "odisha"));
			}
			else if(choice==4) {
				IO.println(serv.deleteEmployee(101l));
			}
			else if(choice==5) {
				IO.println(serv.updateAddress(101l));
			}
		}

	}

}
