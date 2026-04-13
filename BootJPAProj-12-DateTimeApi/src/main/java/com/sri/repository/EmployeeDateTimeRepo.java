package com.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sri.entity.Employee_Date_Time;

public interface EmployeeDateTimeRepo extends JpaRepository<Employee_Date_Time, Integer> {

	@Query(value="select floor(months_between(sysdate,dob)/12) from Employee_Date_Time where desg=:desg",nativeQuery=true)
	List<Integer> getEmployeeAgesByDesg(String desg);
}
