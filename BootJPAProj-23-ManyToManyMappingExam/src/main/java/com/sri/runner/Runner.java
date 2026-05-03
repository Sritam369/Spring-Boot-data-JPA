package com.sri.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Employee;
import com.sri.entity.Skill;
import com.sri.repository.EmpRepo;
import com.sri.repository.SkillRepo;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private EmpRepo repo1;
	@Autowired
	private SkillRepo repo2;
	
	@Override
	public void run(String... args) throws Exception {
		while(true) {
			
			IO.println("1. add employee");
			IO.println("2. add skills");
			IO.println("3. assign skill to employee");
			IO.println("4. view employee with skills");
			IO.println("5. delete employee");
			
			int choice = Integer.parseInt(IO.readln("enter choice"));
			if(choice==1) {
				int size = Integer.parseInt(IO.readln("enter size"));
				List<Employee> list = new ArrayList<>();
				for(int i=1;i<=size;i++) {
					Employee emp = new Employee();
					emp.setName(IO.readln("enter name"));
					list.add(emp);
				}
				List<Employee> saveAll = repo1.saveAll(list);
				IO.println(saveAll.size()+" no. of employee are added");
			}
			else if(choice==2) {
				List<Skill> list = new ArrayList<>();
				int size = Integer.parseInt(IO.readln("enter size"));
				for(int i=1;i<=size;i++) {
					Skill emp = new Skill();
					emp.setSName(IO.readln("enter skill name"));
					list.add(emp);
					
				}
				List<Skill> saveAll = repo2.saveAll(list);
				IO.println(saveAll.size()+" no. of skills are added");
			}
			else if(choice==3) {
				List<Employee> all = repo1.findAll();
				IO.println("these are emp ids");
				all.forEach(e->{
					IO.print(e.getId()+" ");
				});
				IO.println("these are skills id");
				List<Skill> all2 = repo2.findAll();
				all2.forEach(e->{
					IO.print(e.getSid()+" ");
				});
				
				Long id = Long.parseLong(IO.readln("enter emp id"));
				Long id2 = Long.parseLong(IO.readln("enter skill id"));
				Employee employee = repo1.findById(id).get();
				employee.getSkills().add(repo2.findById(id2).get());
				repo1.save(employee);
				IO.println("skill added to the employee");
			}
			else if(choice==4) {
				List<Employee> all = repo1.findAll();
				all.forEach(e->{
					IO.println(e.getId()+" "+e.getName());
					List<Skill> skills = e.getSkills();
					skills.forEach(IO::println);
				});
			}
			else if(choice==5) {
				Long id = Long.parseLong(IO.readln("enter emp id"));
				repo1.deleteById(id);
				IO.println("emp deleted");
			}
		}

	}

}
