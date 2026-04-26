package com.sri.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Course;
import com.sri.entity.Student;
import com.sri.repository.CourseRepo;
import com.sri.repository.StudentRepo;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private CourseRepo cRepo;
	@Autowired
	private StudentRepo sRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
			while(true) {
				
				IO.println("1.add course with multiple students");
				IO.println("2.view all students");
				IO.println("3.search course by id with student list");
				IO.println("4.exit");
				
				int choice = Integer.parseInt(IO.readln("enter choice"));
				
				if(choice==1) {
					Course c = new Course();
					c.setCourseName(IO.readln("enter course name"));
					c.setDuration(IO.readln("enter course duration"));
					int size = Integer.parseInt(IO.readln("enter how many students"));
					List<Student> list = new ArrayList<>();
					for(int i=1;i<=size;i++) {
						Student s = new Student();
						s.setStudentName(IO.readln("enter student name"));
						s.setEmail(IO.readln("enter email"));
						s.setGrade(IO.readln("enter grade"));
						s.setCourse(c);
						list.add(s);
					}
					c.setStuds(list);
					Course save = cRepo.save(c);
					if(save!=null) {
						IO.println("1 course added");
					}
					else {
						IO.println("no course added");
					}
					
				}
				
				else if(choice==2) {
					List<Student> all = sRepo.findAll();
					all.forEach(s->{
						IO.println(s.getStudentId()+" "+s.getStudentName()+" "+s.getEmail()+" "+s.getGrade());
						Course c = s.getCourse();
						IO.println(c.getCourseId()+" "+c.getCourseName()+" "+c.getDuration());
					});
					
					
				}
				else if(choice==3) {
					Long id = Long.parseLong(IO.readln("enter course id"));
					Optional<Course> byId = cRepo.findById(id);
					Course course = byId.get();
					IO.println(course);
				}
				else if(choice==4) {
					System.exit(0);
				}
			}

	

}
}
