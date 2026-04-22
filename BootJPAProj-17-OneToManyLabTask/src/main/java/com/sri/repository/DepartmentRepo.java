package com.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sri.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

	@Query("from Department where id=?1")
	Department findDeptById(Long did);
	@Query("from Department")
	List<Department>fetchAllDept();
}
