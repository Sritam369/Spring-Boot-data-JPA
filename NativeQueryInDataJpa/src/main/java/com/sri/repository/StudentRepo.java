package com.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sri.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	@Query(value="select * from student_query where course= ?1",nativeQuery=true)
	List<Student> findByCourse(String course);
	@Query(value="select * from student_query where marks> ?1",nativeQuery = true)
	List<Student>findTopScoringStudent(Double marks);
	@Query(value="select avg(marks) from student_query",nativeQuery = true)
	int averageMarks();
}
