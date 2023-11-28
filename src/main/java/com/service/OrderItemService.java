package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CartItem;
import com.entity.OrderItem;
import com.entity.Orders;
import com.repository.OrderItemRepository;
import com.repository.OrdersRepository;
import com.repository.UserRepository;

@Service
public class OrderItemService {



	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrdersRepository ordersRepository;

	

	public List<OrderItem> getOrderById(int orderId) {
		
		Orders orders = ordersRepository.findById(orderId).get();
		List<OrderItem> orderList = orderItemRepository.getOrderItemsByOrders(orders);
		
		return orderList;
		
	}
	
	public OrderItem create(CartItem cartItem, Orders orders) throws Exception {

		OrderItem orderItem = new OrderItem();
		orderItem.setPrduct(cartItem.getProduct());
		orderItem.setQuantity(cartItem.getQuantity());
		orderItem.setOrders(orders);
		
		orderItemRepository.save(orderItem);

		return orderItem;

	}

}
