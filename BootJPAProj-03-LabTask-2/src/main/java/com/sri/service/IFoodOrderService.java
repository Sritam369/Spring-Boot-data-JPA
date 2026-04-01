package com.sri.service;

import java.util.List;
import java.util.Optional;

import com.sri.Entity.FoodOrder;

public interface IFoodOrderService {
Optional<FoodOrder> addOrder(FoodOrder order);
Iterable<FoodOrder> addBulk(List<FoodOrder> list);
Iterable<FoodOrder> viewAllOrders();
FoodOrder viewOrderById(Long id);
Iterable<FoodOrder> viewOrdersByIds(List<Long> id);
Boolean checkOrderExists(Long id);
Long countOrders();
String deleteOrderById(Long id);
String deleteOrdersByIds(List<Long> ids);
void deleteSpecificOrder();
String deleteSelectedOrders(List<FoodOrder> list);
String deleteAllOrders();
}
