package com.sri.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Employee;
import com.sri.entity.Project;
import com.sri.repository.EmployeeRepo;
import com.sri.repository.ProjectRepo;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private EmployeeRepo repo1;
	@Autowired
	private ProjectRepo repo2;
	
	@Override
	public void run(String... args) throws Exception {
		
		while(true) {
			IO.println("1. add employees");
			IO.println("2. assign projects to employee");
			IO.println("3. fetch employees with project");
			IO.println("4. find all employees under project");
			IO.println("5. exit");
			
			int choice = Integer.parseInt(IO.readln("enter choice"));
			
			if(choice==1) {
				int s = Integer.parseInt(IO.readln("enter how many employee"));
				List<Employee> list1 = new ArrayList<>();
				for(int i=1;i<=s;i++) {
					Employee emp = new Employee();
					emp.setEmpName(IO.readln("enter employee name"));
					emp.setDepartment(IO.readln("enter department"));
					int s2 = Integer.parseInt(IO.readln("enter how many projects"));
					List<Project> list2 = new ArrayList();
					for(int j=0;j<s2;j++) {
						Project p = new Project();
						p.setProjName(IO.readln("enter project name"));
						p.setEmps(List.of(emp));
						list2.add(p);
					}
					emp.setProjects(list2);
					list1.add(emp);
				}
				List<Employee> saveAll = repo1.saveAll(list1);
				if(saveAll.size()>0) {
					IO.println("employee added with projects");
				}
				else {
					IO.println("employee not added");
				}
			}
			
			else if(choice==2) {
				IO.println("These are all the employee ids : ");
				List<Employee> all = repo1.findAll();
				all.forEach(e->{
				   IO.print(e.getEid()+" ");	
				});
				IO.println();
				int s2 = Integer.parseInt(IO.readln("enter how many projects"));
				Long id = Long.parseLong(IO.readln("enter employee id"));
				Employee emp = repo1.findById(id).orElseThrow(()-> new IllegalArgumentException("no matching id found"));
				List<Project> list2 = new ArrayList();
				for(int j=0;j<s2;j++) {
					Project p = new Project();
					p.setProjName(IO.readln("enter project name"));
					p.setEmps(List.of(emp));
					list2.add(p);				
				}
				List<Project> projects = emp.getProjects();
				projects.addAll(list2);
				Employee save = repo1.save(emp);
				if(save!=null) {
					IO.println(s2+" projects added to employee with id : "+id);
				}
				else {
					IO.println("projects not added");
				}
			}
			
			else if(choice==3) {
				Long id = Long.parseLong(IO.readln("enter employee id"));
				Employee emp = repo1.findById(id).orElseThrow(()-> new IllegalArgumentException("no id found"));
				IO.print(emp.getEid()+" "+emp.getEmpName()+" "+emp.getDepartment());IO.println();
				IO.println("--------projects--------");
				List<Project> projects = emp.getProjects();
				projects.forEach(IO::println);
				
			}
			else if(choice==4) {
				Long id = Long.parseLong(IO.readln("enter project id"));
				Project p = repo2.findById(id).orElseThrow(()-> new IllegalArgumentException("id not found"));
				List<Employee> emps = p.getEmps();
				emps.forEach(IO::println);
			}
			else if(choice==5) {
				System.exit(0);
			}
			else {
				IO.println("invalid choice");
			}
		}
	}

}
