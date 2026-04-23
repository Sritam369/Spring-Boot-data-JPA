package com.sri.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Customer;
import com.sri.entity.Passport;
import com.sri.service.CustomerService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private CustomerService serv;
	
	@Override
	public void run(String... args) throws Exception {
		while(true) {
			
			IO.println("1. add customer");
			IO.println("2. fetch customers");
			IO.println("3. update customer's passport");
			IO.println("4. fetch passports");
			
			int choice = Integer.parseInt(IO.readln("Enter choice"));
			
			if(choice==1) {
				Customer cust = new Customer();
				cust.setName(IO.readln("enter customer name"));
				cust.setNationality(IO.readln("enter nationality"));
				Passport pass = new Passport("123456","india");
				cust.setPass(pass);
				pass.setCust(cust);
				IO.println(serv.addCustomer(cust));
			}
			
			else if(choice==2) {
				List<Customer> customerDetails = serv.getCustomerDetails();
				customerDetails.forEach(IO::println);
			}
			else if(choice==3) {
				Long id = Long.parseLong(IO.readln("enter customer id"));
				String country = IO.readln("enter country");
				IO.println(serv.updatePassport(id, country));
			}
			else if(choice==4) {
				List<Passport> passports = serv.getPassports();
				passports.forEach(p->{
					IO.print(p.getId()+" "+p.getPassportNumber());
					Customer cust = p.getCust();
					IO.println(cust);
				});
			}
		}

	}

}
