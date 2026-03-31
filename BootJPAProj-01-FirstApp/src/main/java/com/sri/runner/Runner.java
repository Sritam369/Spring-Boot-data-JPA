package com.sri.runner;

import java.util.List;

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
		Doctor doc2 = new Doctor();
		doc.setDocName("sritam");
		doc.setSpecialization("orthopedic");
		doc.setIncome(66000D);
		doc2.setDocName("subrat");
		doc2.setSpecialization("dermatology");
		doc2.setIncome(67000D);
		List<Doctor> list = List.of(doc,doc2); // of() gives nullpointerexception because it's immutable
		//IO.println(docService.registerDoctor(doc)); 
		Iterable<Doctor> bulkRegister = docService.bulkRegister(list);
		bulkRegister.forEach(d->{
			IO.println("doctor obj is saved with id: "+d.getDocId());		
		});
		IO.println("there are total "+docService.fetchDoctorsCount()+" objects");
	}

}
