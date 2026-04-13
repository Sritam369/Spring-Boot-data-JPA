package com.sri.runner;

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
			IO.println("1. Add Employee");
			IO.println("2. View all Employees");
			IO.println("3. Find by department");
			IO.println("4. Find by salary");
			IO.println("5. Search by name");
			IO.println("6. Count by department");
			IO.println("7. Find by department and designation");
			IO.println("8. Salary range");
			IO.println("9. Top 5 highest paid");
			IO.println("10. Count Total Employee");
			IO.println("11. Average salary");
			IO.println("12. Update salary");
			IO.println("13. Increment salary by dept");
			IO.println("14. Delete by department");
			IO.println("15. Exit");
			
			int choice = Integer.parseInt(IO.readln("enter your choice"));
			
			switch(choice) {
			case 1 ->{
				Employee e1 = new Employee("sritam","it",60000d,"dev");
				Employee e2 = new Employee("subrat","it",62000d,"dev");
				Employee e3 = new Employee("tirupati","mech",50000d,"engg");
				Employee e4 = new Employee("jeevan","civil",40000d,"operation");
				Employee e5 = new Employee("rahul","it",62000d,"designer");
				Employee e6 = new Employee("ganesh","marketing",55000d,"testing");
				List<Employee> list = List.of(e1,e2,e3,e4,e5,e6);
				List<Employee> saveAll = repo.saveAll(list);
				if(saveAll.size()>0) {
					IO.println("records saved");
				}
				else {
					IO.println("records not saved");
				}
			}
			
			case 2->{
				List<Employee> all = repo.findAll();
				if(all.size()>0) {
					all.forEach(IO::println);
				}
				else {
					IO.println("no records present");
				}
			}
			case 3->{
				String dept =IO.readln("enter department");
				List<Employee> byDept = repo.findByDept(dept);
				if(byDept.size()>0) {
					byDept.forEach(IO::println);
				}
				else {
					IO.println("no department found");
				}
			}
			case 4->{
			   Double sal = Double.parseDouble(IO.readln("enter salary"));
			   List<Employee> bySalaryGreaterThan = repo.findBySalaryGreaterThan(sal);
			   if(bySalaryGreaterThan.size()>0) {
				   bySalaryGreaterThan.forEach(IO::println);
			   }
			   else {
				   IO.println("no record found");
			   }
			}
			case 5->{
				String name = IO.readln("enter name");
				List<Employee> byName = repo.findByName(name.toLowerCase());
				if(byName.size()>0) {
					byName.forEach(IO::println);
				}
				else {
					IO.println("no names found");
				}
			}
			case 6->{
				String dept = IO.readln("enter department");
				int countEmployeeInDept = repo.countEmployeeInDept(dept);
				if(countEmployeeInDept>0) {
					IO.println(countEmployeeInDept+" employees are present");
				}
				else {
					IO.println("no employee found");
				}
			}
			case 7 ->{
				String dept = IO.readln("enter department");
				String desg = IO.readln("enter designation");
				
				List<Employee> empInDesgnAndDept = repo.findEmpInDesgnAndDept(desg, dept);
				if(empInDesgnAndDept.size()>0) {
					empInDesgnAndDept.forEach(IO::println);
				}
				else {
					IO.println("no employee found");
				}
			}
			case 8->{
				Double sal1 = Double.parseDouble(IO.readln("enter first sal"));
				Double sal2 = Double.parseDouble(IO.readln("enter second sal"));
				List<Employee> bySalRange = repo.findBySalRange(sal1, sal2);
				if(bySalRange.size()>0) {
					bySalRange.forEach(IO::println);
				}
				else {
					IO.println("no record found");
				}				
			}
			case 9->{
				List<Employee> fetchTop5 = repo.fetchTop5();
				if(fetchTop5.size()>0) {
					fetchTop5.forEach(IO::println);
				}
				else {
					IO.println("no records found");
				}
			}
			case 10->{
				int countTotalEmployees = repo.countTotalEmployees();
				if(countTotalEmployees>0) {
					IO.println(countTotalEmployees+" employees are present");
				}
				else {
					IO.println("no employees found");
				}
			}
			case 11->{
				Double avgSalary = repo.avgSalary();
				if(avgSalary!=null) {
				IO.println(avgSalary);
				}
				else {
					IO.println("no salary found");
				}
			}
			case 12->{
				Long id = Long.parseLong(IO.readln("enter id"));
				int updateSal = repo.updateSal(id);
				if(updateSal>0) {
					IO.println("salary updated");
					repo.findById(id).ifPresent(IO::println);
				}
				else {
					IO.println("salary not updated");
				}
			}
			case 13->{
				String dept = IO.readln("enter dept");
				int increaseSal = repo.increaseSal(dept);
				if(increaseSal>0) {
					IO.println("salary increased");
				}
				else {
					IO.println("salary not increased");
				}
			}
			case 14->{
				String dept = IO.readln("enter dept");
				int deleteEmployeeByDept = repo.deleteEmployeeByDept(dept);
				if(deleteEmployeeByDept>0) {
					IO.println("Employee deleted");
				}
				else {
					IO.println("Employee not deleted");
				}
			}
			case 15->{
				System.exit(0);
			}
			default ->{
				IO.println("invalid chocie");
			}
			
			}
		}

	}

}
