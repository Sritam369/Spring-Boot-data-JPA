package com.sri.service;

import java.util.List;

import com.sri.Entity.FoodOrder;

public interface IFoodOrderService {
FoodOrder addOrder(FoodOrder order);
Iterable<FoodOrder> addBulk(List<FoodOrder> list);
Iterable<FoodOrder> viewAllOrders();
FoodOrder viewOrderById(Long id);
Iterable<FoodOrder> viewOrdersByIds(List<Long> id);
Boolean checkOrderExists(Long id);
Long countOrders();
void deleteOrderById(Long id);
void deleteOrdersByIds(List<Long> ids);
void deleteSpecificOrder();
void deleteSelectedOrders(List<FoodOrder> list);
void deleteAllOrders();
}
