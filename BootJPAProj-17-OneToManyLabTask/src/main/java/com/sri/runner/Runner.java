package com.sri.runner;

import java.util.ArrayList;
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
			IO.println("2. add employees in department");
			IO.println("3. fetch department by id");
			IO.println("4. fetch all departments");
			IO.println("5. fetch employees by department");
			IO.println("6. fetch employees with salary greater than 50k");
			IO.println("7. delete only one employee by id");
			IO.println("8. transfer one employee to other department");
			IO.println("9. exit");
			
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
				Long did = Long.parseLong(IO.readln("enter department id"));
				int size = Integer.parseInt(IO.readln("enter how many employees "));
				List<Employee>list = new ArrayList<>();
				for(int i=1;i<=size;i++) {
					Employee emp = new Employee();
					emp.setName(IO.readln("enter name"));
					emp.setSalary(Double.parseDouble(IO.readln("enter sal")));
					emp.setDesignation(IO.readln("enter designation"));
					list.add(emp);
				}
				String empToDepartment = serv.addEmpToDepartment(did, list);
				IO.println(empToDepartment);
			}
			
			else if(choice==3) {
				Long id = Long.parseLong(IO.readln("enter id"));
				Department fetchDeptById = serv.fetchDeptById(id);
				if(fetchDeptById!=null) {
					IO.println(fetchDeptById);
				}
				else {
					IO.println("no department found with id : "+id);
				}
			}
			
			else if(choice==4) {
				List<Department> fetchAllDept = serv.fetchAllDept();
				if(fetchAllDept.isEmpty()) {
					IO.println("no department found");
				}
				else {
					fetchAllDept.forEach(IO::println);
				}
			}
			
			else if(choice==5) {
				Long id = Long.parseLong(IO.readln("enter id of the department"));		
				List<Employee> employeesByDept = serv.getEmployeesByDept(id);
				employeesByDept.forEach(IO::println);
			}
			
			else if(choice==6) {
				List<Employee> fetchEmpWithSalGt50k = serv.fetchEmpWithSalGt50k();
				if(fetchEmpWithSalGt50k.isEmpty()) {
					IO.println("no employee have salary greater than 50k");
				}
				else {
					fetchEmpWithSalGt50k.forEach(IO::println);
				}
			}
			else if(choice==7) {
				Long id = Long.parseLong(IO.readln("enter employee id"));		
				IO.println(serv.deleteEmpById(id));
			}
			else if(choice==8) {
				Long eid = Long.parseLong(IO.readln("enter employee id"));
				Long did = Long.parseLong(IO.readln("enter department id"));		
				IO.println(serv.transferEmpByIdToNewDept(eid, did));
			}
			else if(choice==9) {
				System.exit(0);
			}
			else {
				IO.println("Invalid choice");
			}
		}

	}

}
