package com.sri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sri.entity.Employeejpa;
import com.sri.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	private EmployeeRepository repo;

	@Override
	public String saveEmployees(Iterable<Employeejpa> list) {
		Iterable<Employeejpa> saveAll = repo.saveAll(list);
		if(saveAll.iterator().hasNext()) {
			return "Employee record saved successfully";
		}
		else {
			return "Employee record didn't save";
		}
	}

	@Override
	public Page<Employeejpa> getEmployeesByPageAndSort(int pageno, int pagesize, boolean asc, String prop) {
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC , prop);	
		Pageable pageable = PageRequest.of(pageno, pagesize,sort);
		Page<Employeejpa> all = repo.findAll(pageable);
		
		return all;
	}

	@Override
	public void showDataThroughPagination(int pageSize) {
		long count = repo.count();
		long pagesCount = count/pageSize;
		if(count%pageSize!=0) {
			pagesCount++;
		}
		for(int i=0;i<pagesCount;i++) {
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<Employeejpa> page = repo.findAll(pageable);
			page.getContent().forEach(IO::println);
			IO.println("page "+(i+1)+" / "+pagesCount);
		}
		
	}
	
	
}
