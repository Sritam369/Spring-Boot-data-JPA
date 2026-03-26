package com.sri.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Doctor;
import com.sri.service.IDoctorService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private IDoctorService docService;
	
	@Override
	public void run(String... args) throws Exception {
		Doctor doc = new Doctor();
		doc.setDocName("sritam");
		doc.setSpecialization("orthopedic");
		doc.setIncome(66000D);
		IO.println(docService.registerDoctor(doc));

	}

}
