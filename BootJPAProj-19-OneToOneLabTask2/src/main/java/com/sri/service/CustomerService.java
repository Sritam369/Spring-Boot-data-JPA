package com.sri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Customer;
import com.sri.entity.Passport;
import com.sri.repository.CustomerRepo;
import com.sri.repository.PassportRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo repo;
	@Autowired
	private PassportRepo repo2;
	
	public String addCustomer(Customer cust) {
		Customer save = repo.save(cust);
		if(save!=null) {
			return "Customer saved with passport";
		}
		else {
			return "customer not saved";
		}
	}
	
	public List<Customer> getCustomerDetails() {
		
		return repo.findAll();
	}
	
	public String updatePassport(Long id,String country) {
		Customer cust = repo.findById(id).orElseThrow(()-> new IllegalArgumentException("no id found"));
		cust.getPass().setCountry(country);
		repo.save(cust);
		return "passport updated for customer with id : "+id;
	}
	
	public List<Passport> getPassports(){
		return repo2.findAll();
	}
}
