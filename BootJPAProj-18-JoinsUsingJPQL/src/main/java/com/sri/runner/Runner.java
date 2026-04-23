package com.sri.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Department;
import com.sri.entity.Employee;
import com.sri.service.OfficeService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private OfficeService serv;
	
	@Override
	public void run(String... args) throws Exception {
		
		while(true) {
			IO.println("1. save department");
			IO.println("2. get only common details of two tables");
			
			
			int choice = Integer.parseInt(IO.readln("enter your choice"));
			
			if(choice==1) {
				int dept = Integer.parseInt(IO.readln("enter how many departments"));
				
				for(int i=1;i<=dept;i++) {
					Department d = new Department();
					String dName = IO.readln("enter department name");
					String dLocation = IO.readln("enter location");
					int emp= Integer.parseInt(IO.readln("enter how many employees"));
					List<Employee>list = new ArrayList<>();
					for(int j=1;j<=emp;j++) {
				    Employee e = new Employee();
					String eName = IO.readln("enter employee name");
					Double sal = Double.parseDouble(IO.readln("enter salary"));
					String designation = IO.readln("enter designation");
					e.setName(eName);
					e.setSalary(sal);
					e.setDesignation(designation);
					e.setDept(d);
					list.add(e);
					
					}
					d.setName(dName);
					d.setLocation(dLocation);
					d.setEmps(list);
					IO.println(serv.saveDepartment(d));
				}
			}
			
			else if(choice==2) {
				List<Object[]> fetchCommonData = serv.fetchCommonData();
				if(fetchCommonData.isEmpty()) {
					IO.println("no common data found");
				}
				else {
				fetchCommonData.forEach(e->{
					for(Object er:e) {
						IO.print(er+" ");
					}
					IO.println();
				});
				}
			}
		}		
	}

}
