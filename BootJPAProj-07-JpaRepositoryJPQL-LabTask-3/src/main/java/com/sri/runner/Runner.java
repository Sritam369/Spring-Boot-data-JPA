package com.sri.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.entity.Product;
import com.sri.repository.ProductRepo;

@Component
public class Runner implements CommandLineRunner{

	@Autowired
	private ProductRepo repo;
	@Override
	public void run(String... args) throws Exception {
		
		while(true) {
			
			IO.println("1. add products");
			IO.println("2. find by catagory");
			IO.println("3. find by price");
			IO.println("4. find by stock");
			IO.println("5. find by name");
			IO.println("6. update name");
			IO.println("7. exit");
			
			int i = Integer.parseInt(IO.readln("enter your choice"));
			
			switch(i) {
			
			case 1 ->{
		Product p1 = new Product(101l,"mobile","electronics",25000d,100);
		Product p2 = new Product(102l,"laptop","electronics",75000d,100);
		Product p3 = new Product(103l,"bed","furniture",15000d,0);
		Product p4 = new Product(104l,"fan","appliances",5000d,12);
		Product p5 = new Product(105l,"shoe","clothing",3000d,200);
		
		List<Product> l = List.of(p1,p2,p3,p4,p5);
		List<Product> saveAll = repo.saveAll(l);
		if(saveAll.size()>0) {
			IO.println("Products saved");
		}
		else {
			IO.println("products not saved");
		}
			}
			
			case 2 ->{
		String cat = IO.readln("enter catagory");
		List<Product> searchByCatagory = repo.SearchByCatagory(cat);
		if(searchByCatagory.size()>0) {
			searchByCatagory.forEach(IO::println);
		}
		else {
			IO.println("catagory not found");
		}
			}
			case 3 ->{
		Double price = Double.parseDouble(IO.readln("enter price"));
		List<Product> priceList = repo.searchByLessThanPrice(price);
		if(priceList.size()>0) {
			priceList.forEach(IO::println);
		}
		else {
		IO.println("price not found");
		}
	}
			case 4 ->{
				
				List<Product> stocks = repo.serchByStockGreaterThan0();
				if(stocks.size()>0) {
					stocks.forEach(IO::println);
				}
				else {
					IO.println("price not found");
				}
			}
        case 5 ->{
				String word = IO.readln("enter word to search");
				List<Product> name = repo.searchByKeyword(word.toLowerCase());
				if(name.size()>0) {
					name.forEach(IO::println);
				}
				else {
					IO.println("product not found");
				}
			}
        case 6 ->{
        	String word = IO.readln("enter old name to update");
        	String word2 = IO.readln("enter new name to update");
        	int updateName = repo.updateName(word2,word);
        	if(updateName>0) {
        		IO.println("name updated");
        	}
        	else {
        		IO.println("not updated");
        	}
        }
	}
	}
	}
}
