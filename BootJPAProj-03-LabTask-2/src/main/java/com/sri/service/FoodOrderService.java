package com.sri.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.Entity.FoodOrder;
import com.sri.repository.FoodOrderRepository;

@Service
public class FoodOrderService implements IFoodOrderService {

	@Autowired
	private FoodOrderRepository repo;
	
	@Override
	public Optional<FoodOrder> addOrder(FoodOrder order) {
		if(order.getQuantity()<0) {
			IO.println("Quantity can't be 0 or less than 0");
			System.exit(0);
		}
		if(order.getPricePerItem()<0) {
			IO.println("Price per item can't be 0 or less than 0");
			System.exit(0);
		}
		Double totalAmount = order.getQuantity()*order.getPricePerItem();
		if(order.getQuantity()>5) {
			totalAmount-=totalAmount*0.10;
		}
		 if(totalAmount>1000) {
			totalAmount-=100;
		}
		order.setTotalAmount(totalAmount);
	
		Optional<FoodOrder> orders = Optional.of(repo.save(order));
		return orders;
	}

	@Override
	public Iterable<FoodOrder> addBulk(List<FoodOrder> list) {
		list.forEach(order->{
			if(order.getQuantity()<0) {
				IO.println("Quantity can't be 0 or less than 0");
				System.exit(0);
			}
			if(order.getPricePerItem()<0) {
				IO.println("Price per item can't be 0 or less than 0");
				System.exit(0);
			}
			Double totalAmount = order.getQuantity()*order.getPricePerItem();
			if(order.getQuantity()>5) {
				totalAmount-=totalAmount*0.10;
			}
			 if(totalAmount>1000) {
				totalAmount-=100;
			}
			order.setTotalAmount(totalAmount);
		});
		Iterable<FoodOrder> saveAll = repo.saveAll(list);
		return saveAll;
	}

	@Override
	public Iterable<FoodOrder> viewAllOrders() {
		Iterable<FoodOrder> all = repo.findAll();
		return all;
	}

	@Override
	public FoodOrder viewOrderById(Long id) {
		Optional<FoodOrder> byId = repo.findById(id);
		return byId.orElseThrow(()-> new IllegalArgumentException("id not found"));
	}

	@Override
	public Iterable<FoodOrder> viewOrdersByIds(List<Long> id) {
		Iterable<FoodOrder> allById = repo.findAllById(id);
		return allById;
	}

	@Override
	public Boolean checkOrderExists(Long id) {
		boolean existsById = repo.existsById(id);
		return existsById;
	}

	@Override
	public Long countOrders() {
		Long count = repo.count();
		return count;
	}

	@Override
	public String deleteOrderById(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "order with id "+id+" deleted";
		}
		else {
			return id+" Id not found";
		}
	}

	@Override
	public String deleteOrdersByIds(List<Long> ids) {
		
		Iterable<FoodOrder> allById = repo.findAllById(ids);
		Long count = StreamSupport.stream(allById.spliterator(), false).count();
//		if (allById.iterator().hasNext()) {
//			repo.deleteAllById(ids);
//			return "All records with matching id deleted successfully";
//	    } else {
//	    	return "records not found";
//	    }
		
		if(count>0) {
			repo.deleteAllById(ids);
			return "All records with matching id deleted successfully";
		}
		else {
			return "records not found";
		}
	}

	@Override
	public void deleteSpecificOrder() {
		Iterable<FoodOrder> all = repo.findAll();	
		all.forEach(a->{
			if(a.getPricePerItem()<10) {
				repo.delete(a);
			}
		});
	}

	@Override
	public String deleteSelectedOrders(List<FoodOrder> list) {
		List<Long>ids =new ArrayList<>();
		list.forEach(l->{
			ids.add(l.getId());
		});
		
		Iterable<FoodOrder> allById = repo.findAllById(ids);
		if(allById.iterator().hasNext()) {
			repo.deleteAll(list);	
				return "Selected orders deleted";
			}
			else {
				return "Orders not deleted";
			}
			
	}

	@Override
	public String deleteAllOrders() {
		repo.deleteAll();
		Long count = repo.count();
		if(count==0) {
			return "All orders deleted";
		}
		else {
			return "Orders not deleted";
		}
	}

}
