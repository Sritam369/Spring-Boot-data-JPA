package com.sri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.Entity.FoodOrder;
import com.sri.repository.FoodOrderRepository;

@Service
public class FoodOrderService implements IFoodOrderService {

	@Autowired
	private FoodOrderRepository repo;
	
	@Override
	public FoodOrder addOrder(FoodOrder order) {
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
	
		FoodOrder orders = repo.save(order);
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
	public void deleteOrderById(Long id) {
		if(repo.existsById(id)) {
		repo.deleteById(id);
		}
		else {
			IO.println(id+"id not found");
		}
	}

	@Override
	public void deleteOrdersByIds(List<Long> ids) {
		repo.deleteAllById(ids);
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
	public void deleteSelectedOrders(List<FoodOrder> list) {
			repo.deleteAll(list);	
	}

	@Override
	public void deleteAllOrders() {
		repo.deleteAll();		
	}

}
