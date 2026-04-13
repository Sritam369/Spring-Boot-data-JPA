package com.sri.service;

import java.util.List;

import com.sri.entity.Employee_Date_Time;

public interface EmployeeMgmtService  {
String saveEmployee(Employee_Date_Time dateTime);
List<Employee_Date_Time> getAllEmployees();
List<Integer> showEmployeeAgesByDesg(String desg);
}
