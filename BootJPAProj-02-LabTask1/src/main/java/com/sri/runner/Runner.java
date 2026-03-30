package com.sri.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Travel;
import com.sri.service.ITravelService;

@Component
public class Runner implements CommandLineRunner {
	@Autowired
	private ITravelService service;

	@Override
	public void run(String... args) throws Exception {
		while(true) {
			Travel t = new Travel();
			IO.println("1.add travel details");
			IO.println("2.view all travel details");
			IO.println("3.find travel details by id");
			IO.println("4.exit");
			int choice = Integer.parseInt(IO.readln("Enter choice"));
			if(choice==1) {
				t.setDestination(IO.readln("enter destination"));
				t.setTransportationMode(IO.readln("enter transportation mode"));
				t.setPrice(Double.parseDouble(IO.readln("enter price")));
		        service.addTravel(t);
			}
			else if(choice==2) {
		Iterable<Travel> allTravel = service.getAllTravel();
		allTravel.forEach(travel->{
			IO.println(travel.getId());
			IO.println(travel.getDestination());
			IO.println(travel.getTransportationMode());
			IO.println(travel.getPrice());			
		});
		}
			else if(choice==3) {
				Long id = Long.parseLong(IO.readln("Enter id"));
				Optional<Travel> travelById = service.findTravelById(id);
//				if(travelById.isPresent()) {
//					IO.println(travelById);
//					}
//					else {
//						throw new IllegalArgumentException("id not found");
//					}
				
				IO.println(travelById.orElseThrow(()->  new IllegalArgumentException("id not found")));
			}
			else if(choice==4) {
				System.exit(0);
			}
			else {
				IO.println("Invalid choice");
			}
		}
	}

}
