package com.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sri.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

	@Query("select d.id,d.name,d.location,e.id,e.name,e.salary,e.designation from Department d inner join d.emps e")
    List<Object[]>fetchOnlyCommonData();
}
