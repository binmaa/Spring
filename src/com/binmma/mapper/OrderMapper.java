package com.binmma.mapper;

import java.util.List;

import com.binmma.model.Order;



public interface OrderMapper {
	List<Order> getOrderList();
	int getOrderNumbers();
	List<Order> getOrderListMap();
	List<Order> getOrderUser();
}
