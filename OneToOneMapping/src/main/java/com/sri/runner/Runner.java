package com.sri.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Employee;
import com.sri.entity.IdCard;
import com.sri.repository.EmployeeRepo;
import com.sri.repository.IdRepo;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private EmployeeRepo eRepo;
	@Autowired
	private IdRepo iRepo;
	
	@Override
	public void run(String... args) throws Exception {
		while(true) {
			
			IO.println("1.add employee");
			IO.println("2.view employee and id card details");
			IO.println("3.search employee by id");
			IO.println("4.exit");
			
			int choice = Integer.parseInt(IO.readln("enter choice"));
			
			if(choice==1) {
				int size = Integer.parseInt(IO.readln("enter how many employee"));
				List<Employee> list = new ArrayList<>();
				for(int i=1;i<=size;i++) {
					Employee emp = new Employee();
					emp.setEName(IO.readln("enter name"));
					emp.setDept(IO.readln("enter dept"));
					emp.setSalary(Double.parseDouble(IO.readln("enter salary")));
					IdCard id = new IdCard();
					id.setCardType(IO.readln("enter card type"));
					id.setAcessLevel(IO.readln("enter access level"));
					id.setIssuedBy(IO.readln("enter issued by"));
					emp.setEid(id);
					list.add(emp);
				}
				List<Employee> saveAll = eRepo.saveAll(list);
				if(saveAll!=null) {
					IO.println(saveAll.size()+" no. of employees added");
				}
				else {
					IO.println("no employee added");
				}
				
			}
			
			else if(choice==2) {
				List<Employee> all = eRepo.findAll();
				all.forEach(IO::println);
				
			}
			else if(choice==3) {
				Long id = Long.parseLong(IO.readln("enter id"));
				Optional<Employee> all = eRepo.findById(id);
				Employee employee = all.get();
				IO.println(employee);
			}
			else if(choice==4) {
				System.exit(0);
			}
		}

	}

}
