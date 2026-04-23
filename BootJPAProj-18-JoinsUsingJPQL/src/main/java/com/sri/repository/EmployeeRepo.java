package com.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sri.entity.Department;
import com.sri.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {


}
