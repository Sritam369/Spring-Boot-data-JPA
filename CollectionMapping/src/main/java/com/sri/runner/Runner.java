package com.sri.runner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.sri.CollectionMappingApplication;
import com.sri.entity.Employee;
import com.sri.repository.EmployeeRepo;

@Component
public class Runner implements CommandLineRunner {

    private final CollectionMappingApplication collectionMappingApplication;


	@Autowired
	private EmployeeRepo repo;

    Runner(CollectionMappingApplication collectionMappingApplication) {
        this.collectionMappingApplication = collectionMappingApplication;
    }

	@Override
	public void run(String... args) throws Exception {
         
		while(true) {
			IO.println("1. add employee");
			IO.println("2. show employee");
			IO.println("3. show only unique skills of each employee");
			IO.println("4. show only unique skills of all employee");
			IO.println("5. exit");
			
			int choice = Integer.parseInt(IO.readln("enter choice"));
			
			if(choice==1) {
				int size = Integer.parseInt(IO.readln("enter how many employees "));
				List<Employee> list = new ArrayList<>();
				for(int i=1;i<=size;i++) {
					Employee  emp = new Employee();
					emp.setName(IO.readln("enter name"));;
					int s = Integer.parseInt(IO.readln("enter how many skills"));
					List<String> skill = new ArrayList<>();
					for(int j=1;j<=s;j++) {
						String skills = IO.readln("enter skill");
						skill.add(skills);
					}
					emp.setSkills(skill);
					
					list.add(emp);
					
				}
				List<Employee> saveAll = repo.saveAll(list);
				IO.println(saveAll.size()+" Employees added");

			}
			else if(choice==2) {
				List<Employee> all = repo.findAll();
				all.forEach(IO::println);
			}
			else if(choice==3) {
				List<Employee> all = repo.findAll();
				all.forEach(e->{
					List<String>skills = e.getSkills();
					skills.stream().distinct().forEach(IO::println);
				});
			}
			else if(choice==4) {
				List<Employee> all = repo.findAll();
				all.stream().flatMap(e->e.getSkills().stream()).distinct().forEach(IO::println);
			}
			
			else if(choice==5) {
				System.exit(0);
			}
			
		}

	}

}
