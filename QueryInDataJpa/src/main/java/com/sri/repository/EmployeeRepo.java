package com.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sri.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	@Query("from Employee where department = ?1")
	public List<Employee> findEmployeesByDept(String dept);
	@Query("from Employee where salary > ?1")
	public List<Employee> findEmployeeWithGreaterSal(Double sal);
	@Query("from Employee where Lower(name) = ?1")
	public List<Employee> findByName(String name);
}
