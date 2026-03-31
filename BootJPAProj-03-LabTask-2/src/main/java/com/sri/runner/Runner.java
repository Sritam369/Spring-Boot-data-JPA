package com.sri.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.Entity.FoodOrder;
import com.sri.service.IFoodOrderService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private IFoodOrderService service;
	@Override
	public void run(String... args) throws Exception {
		
		FoodOrder order = new FoodOrder();
		
		while(true) {
			IO.println("1. Add order");
			IO.println("2. Add bulk orders");
			IO.println("3. view all order");
			IO.println("4. view all order by id");
			IO.println("5. view all order by ids");
			IO.println("6. check order");
			IO.println("7. count order");
			IO.println("8. delete order by id");
			IO.println("9. delete orders by ids");
			IO.println("10. delete specific orders");
			IO.println("11. delete selected orders");
			IO.println("12. delete all order");
			int choice = Integer.parseInt(IO.readln("enter choice"));
			switch(choice) {
			
			case 1 ->{
				order.setCustName(IO.readln("Enter customer name"));
				order.setQuantity(Integer.parseInt(IO.readln("Enter quantity")));
				order.setPricePerItem(Double.parseDouble(IO.readln("Enter price per item")));
				service.addOrder(order);
			}
			case 2 ->{
				FoodOrder order1 = new FoodOrder();
				FoodOrder order2 = new FoodOrder();
				order1.setCustName(IO.readln("Enter 1st customer name"));
				order1.setQuantity(Integer.parseInt(IO.readln("Enter 1st quantity")));
				order1.setPricePerItem(Double.parseDouble(IO.readln("Enter 1st price per item")));
				order2.setCustName(IO.readln("Enter 2nd customer name"));
				order2.setQuantity(Integer.parseInt(IO.readln("Enter 2nd quantity")));
				order2.setPricePerItem(Double.parseDouble(IO.readln("Enter 1s2ndt price per item")));
				List<FoodOrder> list = List.of(order1,order2);
				service.addBulk(list);
			}
			case 3 ->{
				Iterable<FoodOrder> viewAllOrders = service.viewAllOrders();
				viewAllOrders.forEach(o->{
					IO.println(o.getId());
					IO.println(o.getCustName());
					IO.println(o.getQuantity());
					IO.println(o.getPricePerItem());
					IO.println(o.getTotalAmount());
				});
			}
			case 4 ->{
				Long id = Long.parseLong(IO.readln("Enter id"));
				IO.println(service.viewOrderById(id));
			}
			case 5 ->{
				int size = Integer.parseInt(IO.readln("How many ids do you wanna find"));
				List<Long> ids=new ArrayList<>();
				for(int i=1;i<=size;i++) {
					Long id = Long.parseLong(IO.readln("Enter id"));
					ids.add(id);
				}
				Iterable<FoodOrder> viewOrdersByIds = service.viewOrdersByIds(ids);
				viewOrdersByIds.forEach(o->{
					IO.println(o.getId());
					IO.println(o.getCustName());
					IO.println(o.getQuantity());
					IO.println(o.getPricePerItem());
					IO.println(o.getTotalAmount());
				});
			}
			case 6 ->{
				Long id = Long.parseLong(IO.readln("Enter id"));
				IO.println("order with id: "+id+" exists: "+service.checkOrderExists(id));
			}
			case 7 ->{
				Long count = service.countOrders();
				if(count>0) {
					IO.println("Total "+count+" objects are there");
				}
				else {
					IO.println("No objects found");
				}
			}
			case 8 ->{
				Long id = Long.parseLong(IO.readln("Enter id"));
				service.deleteOrderById(id);
			}
			case 9 ->{
				int size = Integer.parseInt(IO.readln("How many ids do you wanna delete"));
				List<Long> ids=new ArrayList<>();
				for(int i=1;i<=size;i++) {
					Long id = Long.parseLong(IO.readln("Enter id"));
					ids.add(id);
				}
				service.deleteOrdersByIds(ids);
			}
			case 10 ->{
				service.deleteSpecificOrder();
			}
			case 11 ->{
				FoodOrder order1 = new FoodOrder();
				FoodOrder order2 = new FoodOrder();
				FoodOrder order3 = new FoodOrder();
				order1.setCustName(IO.readln("Enter 1st customer name"));
				order1.setQuantity(Integer.parseInt(IO.readln("Enter 1st quantity")));
				order1.setPricePerItem(Double.parseDouble(IO.readln("Enter 1st price per item")));
				order2.setCustName(IO.readln("Enter 2nd customer name"));
				order2.setQuantity(Integer.parseInt(IO.readln("Enter 2nd quantity")));
				order2.setPricePerItem(Double.parseDouble(IO.readln("Enter 3rd price per item")));
				order3.setCustName(IO.readln("Enter 3rd customer name"));
				order3.setQuantity(Integer.parseInt(IO.readln("Enter 3rd quantity")));
				order3.setPricePerItem(Double.parseDouble(IO.readln("Enter 3rd price per item")));
				List<FoodOrder> list = List.of(order1,order2,order3);
				service.addBulk(list);
				List<FoodOrder> list2 = List.of(order1,order2);
				service.deleteSelectedOrders(list2);
			}
			case 12->{
				service.deleteAllOrders();
			}
			}
		}
	}

}
