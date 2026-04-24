package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Faculty;

public interface FacultyRepo extends JpaRepository<Faculty, Integer>{

}
