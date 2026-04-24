package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
