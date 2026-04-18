package com.sri.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.sri.NativeQueryInDataJpaApplication;
import com.sri.entity.Student;
import com.sri.repository.StudentRepo;

@Component
public class Runner implements CommandLineRunner {


	@Autowired
	private StudentRepo repo;

	@Override
	public void run(String... args) throws Exception {
         
		while(true) {
			IO.println("1. add student");
			IO.println("2. search student by course");
			IO.println("3. search student with highest marks");
			IO.println("4. calculate average marks");
			IO.println("5. exit");
			
			int choice = Integer.parseInt(IO.readln("enter choice"));
			
			if(choice==1) {
				int size = Integer.parseInt(IO.readln("enter how many students "));
				for(int i=1;i<=size;i++) {
					Student  emp = new Student();
					emp.setName(IO.readln("enter name"));;
					emp.setCourse(IO.readln("enter course"));
					emp.setMarks(Double.parseDouble(IO.readln("enter marks")));
					
					List<Student> list = new ArrayList<>();
					list.add(emp);
					
					List<Student> saveAll = repo.saveAll(list);
					IO.println(saveAll.size()+" Students added");
				}

			}
			else if(choice==2) {
				List<Student> employeesByDept = repo.findByCourse(IO.readln("enter course"));
				employeesByDept.forEach(IO::println);
			}
			else if(choice==3) {
				repo.findTopScoringStudent(Double.parseDouble(IO.readln("enter marks"))).forEach(IO::println);
			}
			else if(choice==4) {
				int averageMarks = repo.averageMarks();
				IO.println("average mark is: "+averageMarks);
			}
			else if(choice==5) {
				System.exit(0);
			}
			
		}

	}

}
