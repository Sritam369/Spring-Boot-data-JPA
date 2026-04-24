package com.sri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Faculty;
import com.sri.entity.Student;
import com.sri.repository.FacultyRepo;
import com.sri.repository.StudentRepo;

@Service
public class CollegeService {

	@Autowired
	private FacultyRepo facRepo;
	@Autowired
	private StudentRepo stuRepo;
	
	public String addDataUsingParent() {
		Faculty f1 = new Faculty("sritam","hyd");
		Faculty f2 = new Faculty("subrat","delhi");
		Student s1 = new Student("anil","hyd","CBIET");
		Student s2 = new Student("sunil","hyd","JBIET");
		Student s3 = new Student("sagar","hyd","NBIET");
		
		f1.getStudentInfo().add(s1);
		f1.getStudentInfo().add(s2);
		f1.getStudentInfo().add(s3);
		f2.getStudentInfo().add(s1);
		f2.getStudentInfo().add(s2);
		
		s1.getFacultyInfo().add(f1);
		s1.getFacultyInfo().add(f2);
		s2.getFacultyInfo().add(f1);
		s1.getFacultyInfo().add(f2);
		s3.getFacultyInfo().add(f1);
		
		facRepo.saveAll(List.of(f1,f2));
		return "Faculties and associated students are saved";
		
	}
	
	public List<Faculty> fetchDataUsingParent(){
		List<Faculty> all = facRepo.findAll();
		return all;
	}
}
