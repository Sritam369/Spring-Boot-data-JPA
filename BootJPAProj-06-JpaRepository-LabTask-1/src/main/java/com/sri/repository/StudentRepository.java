package com.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByCourse(String course);
	List<Student> findByMarksGreaterThan(Double marks);
	List<Student> findByMarksBetween(Double mark1,Double mark2);
	List<Student> findByGrade(String grade);
	List<Student> findByCity(String city);
	List<Student> findByPassedTrue();
	List<Student> findByNameStartingWith(String prefix);
	List<Student> findByCourseAndPassed(String course, Boolean status);
	List<Student> findByCityNotIn(List<String> cities);
	List<Student> findTop3ByOrderByMarksDesc();
}
