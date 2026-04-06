package com.sri.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Student;
import com.sri.service.StudentService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private StudentService serv;
	
	@Override
	public void run(String... args) throws Exception {
		Student s1 = new Student("sritam","java",90.0,"A","hyd",true);
		Student s2 = new Student("konda","java",50.0,"c","hyd",false);
		Student s3 = new Student("subrat","javascript",90.0,"A","hyd",true);
		Student s4 = new Student("jeevan","javascript",90.0,"A","hyd",true);
		Student s5 = new Student("hemanta","java",95.0,"A+","hyd",true);
        List<Student> list = List.of(s1,s2,s3,s4,s5);
        IO.println(serv.save(list));
        List<Student> byCourse = serv.findByCourse("javas");
        if(byCourse.size()>0) {
        	byCourse.forEach(IO::println);
        }
        else {
        	IO.println("No such course found");
        }
        List<Student> byMarksGreaterThan = serv.findByMarksGreaterThan(70.0);
        if(byMarksGreaterThan.size()>0) {
        	byMarksGreaterThan.forEach(IO::println);
        }
        else {
        	IO.println("No marks found");
        }
        List<Student> byMarksBetween = serv.findByMarksBetween(90.0, 96.0);
        if(byMarksBetween.size()>0) {	
        	byMarksBetween.forEach(IO::println);
        }
        else {
        	IO.println("No marks found");
        }
        List<Student> byGrade = serv.findByGrade("A");
        if(byGrade.size()>0) {
        	byGrade.forEach(IO::println);
        }
        else {
        	IO.println("No grade found");
        }
        List<Student> byCity = serv.findByCity("hyd");
        if(byCity.size()>0) {
        	byCity.forEach(IO::println);
        }
        else {
        	IO.println("no city found");
        }
        List<Student> byPassedTrue = serv.findByPassedTrue();
        if(byPassedTrue.size()>0) {
        	byPassedTrue.forEach(IO::println);
        }
        else {
        	IO.println("no passed found");
        }
        List<Student> byCourseAndPassed = serv.findByCourseAndPassed("java",true);
        if(byCourseAndPassed.size()>0) {
        	byCourseAndPassed.forEach(IO::println);
        }
        else {
        	IO.println("No passed found in this course");
        }
        List<Student> top3 = serv.findTop3();
        if(top3.size()>0) {
        	top3.forEach(IO::println);
        }
        else {
        	IO.println("no top3 found");
        }
        List<Student> byCityNotIn = serv.findByCityNotIn(List.of("vizag","chennai"));
        if(byCityNotIn.size()>0) {
        	byCityNotIn.forEach(IO::println);
        }
        else {
        	IO.println("No cities found");
        }
	}

}
