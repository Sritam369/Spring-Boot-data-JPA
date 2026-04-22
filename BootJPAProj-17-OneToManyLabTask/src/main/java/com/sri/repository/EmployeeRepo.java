package com.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sri.entity.Department;
import com.sri.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	@Query("from Employee where dept = ?1")
	List<Employee>fetchEmpsByDept(Department dept);
	@Query("from Employee where salary > 50000")
	List<Employee>fetchEmpsWithSalGreaterThan50000();
	@Query("delete from Employee where id=?1")
	Employee deleteEmpById(Long id);
}
