package com.sri.runner;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Faculty;
import com.sri.entity.Student;
import com.sri.service.CollegeService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private CollegeService service;
	@Override
	public void run(String... args) throws Exception {
		while(true) {
			
			IO.println("1. add faculty");
			IO.println("2. fetch faculty");
			
			int choice = Integer.parseInt(IO.readln("enter your choice"));
			
			if(choice==1) {
				IO.println(service.addDataUsingParent());
			}
			else if(choice==2) {
				List<Faculty> fetchDataUsingParent = service.fetchDataUsingParent();
				fetchDataUsingParent.forEach(f->{
					IO.println(f.getFid()+" "+f.getFName()+" "+f.getFAddrs());
					Set<Student> stud = f.getStudentInfo();
					stud.forEach(IO::println);
				});
			}
		}

	}

}
