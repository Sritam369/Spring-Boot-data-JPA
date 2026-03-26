package com.sri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Doctor;
import com.sri.repository.IDoctorRepo;

@Service
public class DoctorMgmtServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo repo;
	
	public String registerDoctor(Doctor doctor) {
		IO.println("Doc id before save : "+doctor.getDocId());
		Doctor doc = repo.save(doctor);
		return "Doctor obj is saved with id value : "+doc.getDocId();
	}


}
