package com.sri.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sri.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Query("from Employee where dept=:dept")
	List<Employee> searchByDept(@Param("dept") String dept);
    @Query("from Employee where sal between :first and :second")
    List<Employee> searchBySal(@Param("first")Double first,@Param("second")Double second);
    @Query("from Employee where exp > :exp")
    List<Employee> searchByExp(@Param("exp") Integer exp);
    @Query("select count(*) from Employee where dept=?1")
    int countEmployeesInDept(String dept);
    @Query(" from Employee where sal= (select max(sal) from Employee)")
    Optional<Employee> getHighestSalEmp();
    @Query("update Employee set sal=sal+(sal*?1 /100)where sal=?2")
    @Modifying
    @Transactional
    int increaseSal(Double percentage,Long id);
    @Query("delete from Employee where sal<?1 ")
    @Modifying
    @Transactional
    int deleteLowestSal(Double sal);
}
