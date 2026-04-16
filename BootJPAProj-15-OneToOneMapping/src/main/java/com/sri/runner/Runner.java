package com.sri.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Profile;
import com.sri.entity.User;
import com.sri.service.UserService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private UserService service;
	@Override
	public void run(String... args) throws Exception {
		
		
		while(true) {
			IO.println("1. add user");
			IO.println("2. view user");
			IO.println("3. update user");
			IO.println("4. delete user");
			IO.println("5. exit");
			int s = Integer.parseInt(IO.readln("enter choice"));
			
			switch(s) {
			case 1->{
				Profile pro = new Profile("99999","hyd");
				User user = new User("sritam","xvhhds",pro);
				
				IO.println(service.addUser(user));
			}
			case 2->{
				List<User> viewUser = service.viewUser();
				viewUser.forEach(IO::println);
			}
			case 3->{
				Long id = Long.parseLong(IO.readln("enter id to update"));
				String uName = IO.readln("enter user name");
				String phone = IO.readln("enter phone number");
				IO.println(service.updateUser(id,uName,phone));
			}
			case 4->{
				Long id = Long.parseLong(IO.readln("enter id to delete"));
				IO.println(service.deleteUser(id));
			}
			case 5->{
				System.exit(0);
			}
			default ->{
				IO.println("invalid choice");
			}
			}
		}

	}

}
