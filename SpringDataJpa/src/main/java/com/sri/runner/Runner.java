package com.sri.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Bank;
import com.sri.service.IBankService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private IBankService serv;
	
	@Override
	public void run(String... args) throws Exception {
		while(true) {
			IO.println("1.add");
			IO.println("2.find");
			IO.println("3.update");
			IO.println("4.delete");
			IO.println("5.find by id");
			IO.println("6.exit");
			
			int c = Integer.parseInt(IO.readln("enter choice"));
			switch(c) {
			
			case 1 ->{
				Bank b = new Bank(1, "sritam",20000.0,"savings");
				IO.println(serv.create(b));
			}
			
		case 2 ->{
			Iterable<Bank> display = serv.display();
			display.forEach(IO::println);
		}
		case 3 ->{
			Double bal = Double.parseDouble(IO.readln("enter balance to update"));
			Bank b = new Bank();
			b.setBalance(bal);
			IO.println(serv.update(b));
		}
		case 4 ->{
			Integer id = Integer.parseInt(IO.readln("enter id to delete"));
			IO.println(serv.delete(id));
		}
		case 5 ->{
			Integer id = Integer.parseInt(IO.readln("enter id to find"));
			Optional<Bank> optional = serv.find(id);
			if(optional.isPresent()) {
				IO.println(optional.get());				
			}
			else {
				IO.println("id not found");
			}
				
		}
		}
		}

	}

}
