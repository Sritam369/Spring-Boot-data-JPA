package com.sri.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
			IO.println("4. view order by id");
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
				if(service.addOrder(order).isPresent()) {
					IO.println("Order placed");
				}
				else {
					IO.println("Order not saved");
				}
				
			}
			case 2 ->{
				FoodOrder order1 = new FoodOrder();
				FoodOrder order2 = new FoodOrder();
				order1.setCustName(IO.readln("Enter 1st customer name"));
				order1.setQuantity(Integer.parseInt(IO.readln("Enter 1st quantity")));
				order1.setPricePerItem(Double.parseDouble(IO.readln("Enter 1st price per item")));
				order2.setCustName(IO.readln("Enter 2nd customer name"));
				order2.setQuantity(Integer.parseInt(IO.readln("Enter 2nd quantity")));
				order2.setPricePerItem(Double.parseDouble(IO.readln("Enter 2nd price per item")));
				List<FoodOrder> list = List.of(order1,order2);
				if(service.addBulk(list).iterator().hasNext()) {
					IO.println("Orders placed");
				}
				else {
					IO.println("Orders not placed");
				}
			}
			case 3 ->{
				Iterable<FoodOrder> viewAllOrders = service.viewAllOrders();
				if(viewAllOrders.iterator().hasNext()) {
				viewAllOrders.forEach(o->{
					IO.println(o.getId());
					IO.println(o.getCustName());
					IO.println(o.getQuantity());
					IO.println(o.getPricePerItem());
					IO.println(o.getTotalAmount());
				});
				}
				else {
					IO.println("No orders present");
				}
				
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
				Iterable<FoodOrder> view = service.viewOrdersByIds(ids);
				if(view.iterator().hasNext()) {
				view.forEach(o->{
					IO.println(o.getId());
					IO.println(o.getCustName());
					IO.println(o.getQuantity());
					IO.println(o.getPricePerItem());
					IO.println(o.getTotalAmount());
				});
				}
				else {
					IO.println("No matching ids found");
				}
			}
			case 6 ->{
				Long id = Long.parseLong(IO.readln("Enter id"));
				if(service.checkOrderExists(id)) {
					IO.println("Order exists");
				}
				else {
					IO.println("Order doesn't exist");
				}
			}
			case 7 ->{
				Long count = service.countOrders();
				if(count>0) {
					IO.println("Total "+count+" orders are there");
				}
				else {
					IO.println("No orders found");
				}
			}
			case 8 ->{
				Long id = Long.parseLong(IO.readln("Enter id"));
				IO.println(service.deleteOrderById(id));
			}
			case 9 ->{
				int size = Integer.parseInt(IO.readln("How many ids do you wanna delete"));
				List<Long> ids=new ArrayList<>();
				for(int i=1;i<=size;i++) {
					Long id = Long.parseLong(IO.readln("Enter id"));
					ids.add(id);
				}
				IO.println(service.deleteOrdersByIds(ids));
			}
			case 10 ->{
				service.deleteSpecificOrder();
			}
			case 11->{
				System.out.println("==========Delete Selected Orders==========");
				
				int num = Integer.parseInt(IO.readln("enter how many orders you want to delete"));

				List<FoodOrder> orders = new ArrayList<>();

//				for (int i = 1; i <= num; i++) {
//				    System.out.println("Enter " + i + " ID: ");
//				    Long id = Long.parseLong(IO.readln("enter id"));
//
//				    Optional<FoodOrder> byId = service.viewOrderById(id);
//
//				    if (byId.isPresent()) {
//				        orders.add(byId.get());
//				    } else {
//				        System.out.println("Order with ID " + id + " not found!");
//				    }
//				}
//
//				if (!orders.isEmpty()) {
//				    service.deleteAll(orders);
//				    System.out.println("Orders deleted successfully!");
//				} else {
//				    System.out.println("No valid orders to delete.");
//				}
				
				for(int i=1;i<=num;i++) {
					FoodOrder f = new FoodOrder();
					Long id = Long.parseLong(IO.readln("enter id"));
					String name = IO.readln("enter name");
					int qty = Integer.parseInt(IO.readln("enter qty"));
					Double price = Double.parseDouble(IO.readln("enter price"));
					f.setId(id);
					f.setCustName(name);
					f.setQuantity(qty);
					f.setPricePerItem(price);
					orders.add(f);
				}
				
				IO.println(service.deleteSelectedOrders(orders));
				
			}
			case 12->{
				IO.println(service.deleteAllOrders());
			}
			}
		}
	}

}
