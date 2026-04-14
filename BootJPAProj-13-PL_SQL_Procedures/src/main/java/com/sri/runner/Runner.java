package com.sri.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Doctors;
import com.sri.service.DoctorsService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private DoctorsService service;
	
	@Override
	public void run(String... args) throws Exception {
		

		service.showDoctorsByIncomeRange(10000.0, 200000.0).forEach(IO::println);
	}

}
