package com.sri.service;

import org.springframework.data.domain.Page;

import com.sri.entity.Employeejpa;

public interface IEmployeeService {
String saveEmployees(Iterable<Employeejpa> list);
Page<Employeejpa> getEmployeesByPageAndSort(int pageno,int pagesize,boolean asc,String prop);
void showDataThroughPagination(int pageSize);
}
