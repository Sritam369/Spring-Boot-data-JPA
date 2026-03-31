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
			IO.println("4.delete travel details by id");
			IO.println("5.check travel by id");
			IO.println("6.count travel details");
			IO.println("7.delete travel details by object");
			IO.println("8.delete all travel details");
			IO.println("9.exit");
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
				Long id = Long.parseLong(IO.readln("Enter id"));
				service.deleteTravelById(id);
			}
			else if(choice==5) {
				Long id = Long.parseLong(IO.readln("Enter id"));
				IO.println("Travel booking with id: "+id+" exists: "+service.existsById(id));
			}
			else if(choice==6) {
				Long count = service.count();
				if(count>0) {
					IO.println("Total "+count+" objects are present");
				}
				else {
					IO.println("No object is available");
				}
			}
			else if(choice==7) {
				t.setId(Long.parseLong(IO.readln("enter id")));
				t.setDestination(IO.readln("enter destination"));
				t.setPrice(Double.parseDouble(IO.readln("enter price")));
				service.delete(t);
			}
			else if(choice==8) {
				service.delete();
			}
			else if(choice==9) {
				System.exit(0);
			}
			else {
				IO.println("Invalid choice");
			}
		}
	}

}
