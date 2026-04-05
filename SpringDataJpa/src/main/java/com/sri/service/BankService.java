package com.sri.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Bank;
import com.sri.repository.IBankRepo;

@Service
public class BankService implements IBankService {

	@Autowired
	private IBankRepo repo;
	
	public String create(Bank b) {
		Bank save = repo.save(b);
		if(save!=null) {
			return "Bank account created";
		}
		else {
			return "Bank account not created";
		}
	}

	@Override
	public Iterable<Bank> display() {
		Iterable<Bank> all = repo.findAll();
		return all;
	}

	@Override
	public String update(Bank b) {
		Bank save = repo.save(b);
		if(save!=null) {
			return "Bank account updated";
		}
		else {
			return "Bank account not updated";
		}
	}

	@Override
	public String delete(Integer id) {
		Optional<Bank> byId = repo.findById(id);
		if(byId.isPresent()) {
		repo.deleteById(id);
		return "account deleted";
		}
		else
		return "account not found";
	}

	@Override
	public Optional<Bank> find(Integer id) {
		Optional<Bank> byId = repo.findById(id);
		return byId;
	}

}
