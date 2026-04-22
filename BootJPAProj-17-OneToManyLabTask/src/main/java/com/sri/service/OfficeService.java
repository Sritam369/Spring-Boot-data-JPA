package com.sri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Department;
import com.sri.entity.Employee;
import com.sri.repository.DepartmentRepo;
import com.sri.repository.EmployeeRepo;

@Service
public class OfficeService {

	@Autowired
	private EmployeeRepo eRepo;
	@Autowired
	private DepartmentRepo dRepo;
	
	public String saveDepartment(Department dept) {
		Department save = dRepo.save(dept);
		if(save!=null) {
			return "department saved";
		}
		else {
			return "department not saved";
		}
	}
	
	public String addEmpToDepartment(Long did,List<Employee> list) {
		Optional<Department> byId = dRepo.findById(did);
		if(byId.isEmpty()) {
			return "no department found in the id"+did;
		}
		else {
			Department department = byId.get();
			list.forEach(e->{
				e.setDept(department);
			});
			department.setEmps(list);
			eRepo.saveAll(list);
			dRepo.save(department);
			return "employees added to department with id: "+did;
			
		}
	}
	
	public Department fetchDeptById(Long id) {
		return dRepo.findDeptById(id);
	}
	
	public List<Department> fetchAllDept(){
		List<Department> fetchAllDept = dRepo.fetchAllDept();
		return fetchAllDept;
	}
	
	public List<Employee> getEmployeesByDept(Long id){
		Optional<Department> byId = dRepo.findById(id);
		Department department = byId.get();
		return eRepo.fetchEmpsByDept(department);
	}
	
	public List<Employee> fetchEmpWithSalGt50k(){
		return eRepo.fetchEmpsWithSalGreaterThan50000();
	}
	
	public String deleteEmpById(Long id) {
		Optional<Employee> byId = eRepo.findById(id);
		if(byId.isEmpty()) {
			return "no employee found with id : "+id;
		}
		else {
			Employee employee = byId.get();
			employee.setDept(null);
			eRepo.save(employee);
			eRepo.delete(employee);
			return "Employee with id "+id+" deleted";
		}
	}
	
	public String transferEmpByIdToNewDept(Long eid,Long did) {
		Employee emp = eRepo.findById(eid).orElseThrow(()-> new IllegalArgumentException("no id matched"));
		Department dept = dRepo.findById(did).orElseThrow(()-> new IllegalArgumentException("no id matched"));
		emp.setDept(dept);
		eRepo.save(emp);
		return "employee with id : "+eid+" transferred to department with id : "+did;
	}
}
