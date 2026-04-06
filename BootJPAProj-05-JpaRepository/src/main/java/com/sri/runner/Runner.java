package com.sri.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.JobSeeker;
import com.sri.repository.JobSeekerRepository;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private JobSeekerRepository jsRepo;
	
	@Override
	public void run(String... args) throws Exception {
	
		JobSeeker js = new JobSeeker("sritam","hyd","b.tech",25000.0f,"chakra@gmail.com","ameerpet");
		JobSeeker js2 = new JobSeeker("subrat","hyd","b.tech",26000.0f,"subu@gmail.com","ameerpet");
		JobSeeker js3 = new JobSeeker("konda","chennai","b.tech",28000.0f,"konda@gmail.com","vada");
		JobSeeker js4 = new JobSeeker("jeevan","hyd","b.tech",29000.0f,"jeevi@gmail.com","ameerpet");
		List<JobSeeker> jss = List.of(js,js2,js3,js4);
		
		List<JobSeeker> saveAll = jsRepo.saveAll(jss);
		try {
		    // List<JobSeeker> list = jsRepo.findByJsaddrsEquals("hyd");
		    // List<JobSeeker> list = jsRepo.readByJsaddrsIs("hyd");
		    List<JobSeeker> list = jsRepo.getByJsaddrs("hyd");
		    list.forEach(System.out::println);
		}
		catch(Exception e) {
		    e.printStackTrace();
		}

		try {
		    jsRepo.findByExpectedSalaryBetween(10000.0, 200000.0)
		          .forEach(System.out::println);
		}
		catch(Exception e) {
		    e.printStackTrace();
		}
 
		try {
		    jsRepo.findByExpectedSalaryGreaterThanEqualAndExpectedSalaryLessThanEqual(10000.0, 200000.0)
		          .forEach(System.out::println);
		}
		catch(Exception e) {
		    e.printStackTrace();
		}

		try {
		    jsRepo.findByJsaddrsInOrderByJsaddrsDesc(List.of("hyd", "vizag", "delhi"))
		          .forEach(System.out::println);
		}
		catch(Exception e) {
		    e.printStackTrace();
		}
	
		try {
		    jsRepo.findByJsnameStartingWith("s").forEach(System.out::println);
		    System.out.println("------------------------------------");
		    jsRepo.findByJsnameEndingWith("h").forEach(System.out::println);
		    System.out.println("------------------------------------");
		    jsRepo.findByJsnameContaining("e").forEach(System.out::println);
		}
		catch(Exception e) {
		    e.printStackTrace();
		}
		
		try {
		    jsRepo.findByJsnameEqualsIgnoreCase("Mahesh")
		          .forEach(System.out::println);
		}
		catch(Exception e) {
		    e.printStackTrace();
		}
	
		try {
		    jsRepo.findByJsaddrsLikeAndQlfyIn("h%", List.of("BE", "MCA"))
		          .forEach(System.out::println);
		}
		catch(Exception e) {
		    e.printStackTrace();
		}
		

		try {
		    jsRepo.findByJsaddrsNotInOrQlfyNotLike(List.of("hyd", "vizag"), "B%")
		          .forEach(System.out::println);
		}
		    catch(Exception e) {
			    e.printStackTrace();
			}
	}

}
