package com.sri.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.MarriageSeeker;
import com.sri.repository.MarriageRepo;

@Service
public class MatrimonyService implements IMatrimonyServiceMgmt {

	@Autowired
	private MarriageRepo repo;
	
	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {
		return "Marriage seeker info saved with id value : "+repo.save(seeker).getId();
	}

	@Override
	public Optional<MarriageSeeker> searchSeekerById(Long id) {
		Optional<MarriageSeeker> byId = repo.findById(id);
		return byId;
	}

}
