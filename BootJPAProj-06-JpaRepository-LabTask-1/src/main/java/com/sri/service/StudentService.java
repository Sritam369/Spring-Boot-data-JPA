package com.sri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Student;
import com.sri.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;
	
	public String save(List<Student>list) {
		List<Student> saveAll = repo.saveAll(list);
		if(saveAll!=null) {
			return "Student records saved";
		}
		else {
			return "Student records not saved";
		}
	}
	public List<Student> findByCourse(String course) {
		return repo.findByCourse(course);
	}
	public List<Student> findByMarksGreaterThan(Double mark) {
		return repo.findByMarksGreaterThan(mark);
	}
	public List<Student> findByMarksBetween(Double m1,Double m2){
		return repo.findByMarksBetween( m1, m2);
	}
	public List<Student> findByGrade(String grade) {
		return repo.findByGrade(grade);
	}
	public List<Student> findByCity(String city) {
		return repo.findByCity(city);
	}
	public List<Student> findByPassedTrue() {
		return repo.findByPassedTrue();
	}
	public List<Student> findByNameStartingWith(String prefix) {
		return repo.findByNameStartingWith(prefix);
	}
	public List<Student> findByCourseAndPassed(String course,Boolean status) {
		return repo.findByCourseAndPassed(course,status);
	}
	public List<Student> findByCityNotIn(List<String>cities) {
		return repo.findByCityNotIn(cities);
	}
	public List<Student> findTop3() {
		return repo.findTop3ByOrderByMarksDesc();
	}
	
}
