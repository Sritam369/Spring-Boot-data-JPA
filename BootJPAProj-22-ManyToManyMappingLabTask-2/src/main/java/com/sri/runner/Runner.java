package com.sri.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.BankAccount;
import com.sri.entity.Customer;
import com.sri.repository.AccountRepo;
import com.sri.repository.CustomerRepo;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private CustomerRepo cRepo;
	@Autowired
	private AccountRepo aRepo;
	
	@Override
	public void run(String... args) throws Exception {
		while(true) {
			IO.println("1. add customer");
			IO.println("2. add accounts");
			IO.println("3. map customer to account");
			IO.println("4. fetch accounts with customer");
			IO.println("5. exit");
			
			int choice = Integer.parseInt(IO.readln("enter choice"));
			if(choice==1) {
				int size = Integer.parseInt(IO.readln("enter how many customer"));
				List<Customer> list = new ArrayList<>();
				for(int i=1;i<=size;i++) {
					Customer c = new Customer();
					c.setCustName(IO.readln("enter name"));
					c.setCity(IO.readln("enter city"));
					list.add(c);
				}
				List<Customer> saveAll = cRepo.saveAll(list);
				if(saveAll.size()>0) {
					IO.println(saveAll.size()+" no. of employees added");
				}
				else {
					IO.println("no employees added");
				}
			}
			
			else if(choice==2) {
				int size = Integer.parseInt(IO.readln("enter how many accounts"));
				List<BankAccount> list = new ArrayList<>();
				for(int i=1;i<=size;i++) {
					BankAccount b = new BankAccount();
					b.setAccType(IO.readln("enter account type"));
					b.setBalance(Double.parseDouble(IO.readln("enter balance")));
					list.add(b);
				}
				List<BankAccount> saveAll = aRepo.saveAll(list);
				if(saveAll.size()>0) {
					IO.println(saveAll.size()+" no. of accounts added");
				}
				else {
					IO.println("no accounts added");
				}
			}
			
			else if(choice==3) {
				List<Customer> all = cRepo.findAll();
				IO.println("These are all customer ids list");
				all.forEach(c->{
					IO.print(c.getCustId()+" ");
				});
				IO.println();
				
				List<BankAccount> all2 = aRepo.findAll();
				IO.println("These are all accounts ids list");
				all2.forEach(c->{
					IO.print(c.getAccId()+" ");
				});
				IO.println();
				Long id = Long.parseLong(IO.readln("enter customer id"));
				Long id2 = Long.parseLong(IO.readln("enter account id"));
				Customer c = cRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("no id matched"));
				BankAccount acc = aRepo.findById(id2).orElseThrow(()-> new IllegalArgumentException("no id matched"));
				c.getAccounts().add(acc);
				cRepo.save(c);
			}
			else if(choice==4) {
				List<BankAccount> all = aRepo.findAll();
				
				all.forEach(a->{
					List<Customer> list = a.getCusts();
					IO.println(a.getAccId()+" "+a.getAccType()+" "+a.getBalance()+" "+list);
				});
			}
			else if(choice==5) {
				System.exit(0);
			}
			else {
				IO.println("invalid choice");
			}
		}

	}

}
