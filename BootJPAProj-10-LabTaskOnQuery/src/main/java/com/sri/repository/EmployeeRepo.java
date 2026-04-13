package com.sri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sri.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	@Query("from Employee where department= :dept")
	List<Employee> findByDept(String dept);
	@Query("from Employee where salary>:sal")
	List<Employee> findBySalaryGreaterThan(Double sal);
	@Query("from Employee where Lower(name) like %:prefix% ")
	List<Employee> findByName(String prefix);
	@Query("select count(*) from Employee where department = :dept")
	int countEmployeeInDept(String dept);
	@Query("from Employee where designation=:desg AND department=:dept")
	List<Employee> findEmpInDesgnAndDept(String desg,String dept);
	@Query(value=" select * from employee_lab_jpa where salary between :sal1 and :sal2",nativeQuery = true)
	List<Employee> findBySalRange(Double sal1,Double sal2);
	@Query(value = "SELECT * FROM (SELECT * FROM employee_lab_jpa ORDER BY salary DESC) WHERE ROWNUM <= 5", 
		       nativeQuery = true)
		List<Employee> fetchTop5();
	@Query(value="select count(*) from employee_lab_jpa",nativeQuery = true)
	int countTotalEmployees();
	@Query(value="select avg(salary) from employee_lab_jpa",nativeQuery = true)
	double avgSalary();
	@Query(value="update employee_lab_jpa set salary =72000 where id=:id ",nativeQuery = true)
	@Modifying
	@Transactional
	int updateSal(Long id);
	@Query(value="update employee_lab_jpa set salary=salary+5000 where department=:dept",nativeQuery=true)
	@Modifying
	@Transactional
	int increaseSal(String dept);
	@Query(value="delete from employee_lab_jpa where department=:dept",nativeQuery=true)
	@Modifying
	@Transactional
	int deleteEmployeeByDept(String dept);
	
	
}
