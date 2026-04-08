package com.sri.runner;

import java.util.List;
import java.util.Optional;

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
    	   IO.println("2. View all Employee");
    	   IO.println("3. Find Employee by dept");
    	   IO.println("4. find sal between range");
    	   IO.println("5. find Employee acc to exp");
    	   IO.println("6. count Employee");
    	   IO.println("7. Highest salary Employee");
    	   IO.println("8. Increase Employee sal");
    	   IO.println("9. Delete Lowest salary Employee");
    	   IO.println("10. Exit");
    	   
    	   int i = Integer.parseInt(IO.readln("enter your choice"));
    	   
    	   switch(i) {
    	   
    	   case 1->{
    		   Employee e1 = new Employee("sritam","developer",45000d,1);
    		   Employee e2 = new Employee("subrat","designer",55000d,2);
    		   Employee e3 = new Employee("ganesh","tester",46000d,3);
    		   Employee e4 = new Employee("hemanta","developer",65000d,1);
    		   Employee e5 = new Employee("padma","designer",40000d,4);
    		   List<Employee> list = List.of(e1,e2,e3,e4,e5);
    		   List<Employee> saveAll = repo.saveAll(list);
    		   if(saveAll.size()>0) {
    			   IO.println("Employee records saved");
    		   }
    		   else {
    			   IO.println("Employee records not found");
    		   }
    	   }
    	   case 2->{
    		   List<Employee> all = repo.findAll();
    		   if(all.size()>0)
    		   all.forEach(IO::println);
    		   else
    			   IO.println("No records found");
    	   }
    	   case 3->{
    		   	
    		   List<Employee> searchByDept = repo.searchByDept(IO.readln("enter dept"));
    		   if(searchByDept.size()>0) {
    			   searchByDept.forEach(IO::println);
    		   }
    		   else
    			   IO.println("record not found");
    	   }
    	   case 4->{
    		   List<Employee> searchBySal = repo.searchBySal(Double.parseDouble(IO.readln("enter first sal")), Double.parseDouble(IO.readln("enter first sal")));
    		   if(searchBySal.size()>0) {
    			   searchBySal.forEach(IO::println);
    		   }
    		   else {
    			   IO.println("no records found");
    		   }
    	   }
    	   case 5->{
    		   List<Employee> searchByExp = repo.searchByExp(Integer.parseInt(IO.readln("enter experience")));
    		   if(searchByExp.size()>0) {
    			   searchByExp.forEach(IO::println);
    		   }
    		   else {
    			   IO.println("no records found");
    		   }
    	   }
    	   case 6->{
    		   int countEmployeesInDept = repo.countEmployeesInDept(IO.readln("enter dept"));
    		   if(countEmployeesInDept>0) {
    			   IO.println("Total "+countEmployeesInDept+" employees found");
    		   }
    		   else {
    			   IO.println("no employees found");
    		   }
    	   }
    	   case 7->{
    		   Optional<Employee> highestSalEmp = repo.getHighestSalEmp();
    		   if(highestSalEmp.isPresent()) {
    			   highestSalEmp.ifPresent(IO::println);
    		   }
    		   else {
    			   IO.println("no employees found");
    		   }
    	   }
    	   case 8->{
    		   int increaseSal = repo.increaseSal(Double.parseDouble(IO.readln("Enter percentage")), Long.parseLong(IO.readln("Enter id")));
    		   if(increaseSal>0) {
    			   IO.println("Salary increased");
    		   }
    		   else {
    			   IO.println("salary not increased");
    		   }
    			   
    	   }
    	   case 9->{
    		   int deleteLowestSal = repo.deleteLowestSal(Double.parseDouble(IO.readln("enter salary")));
    		   if(deleteLowestSal>0) {
    			   IO.println("Lowest salary deleted");
    		   }
    		   else {
    			   IO.println("Lowest salary not found");
    		   }
    	   }
    	   case 10->{
    		   System.exit(0);
    	   }
    	   default ->{
    		   IO.println("Invalid choice");
    	   }
    	   }
       }


	}

}
