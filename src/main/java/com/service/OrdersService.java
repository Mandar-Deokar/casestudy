package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Orders;
import com.entity.User;
import com.repository.OrdersRepository;
import com.repository.UserRepository;

@Service
public class OrdersService {
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	UserRepository userRepository;

	public Orders orderHistory(int userId) {
		Orders orders = ordersRepository.getOrdersbyuserId(userId);		
		
		return orders;
	}

	public Orders create(int userId) throws Exception {	
		
		User user =  userRepository.findById(userId).orElse(null);
		if(user == null) {
			throw new Exception("user not found");
		}
		
		Orders orders = ordersRepository.getOrdersbyuserId(userId);
		if(orders == null) {
			orders = new Orders();
			orders.setUser(user);
			ordersRepository.save(orders);
		}
		return orders;
	}
	
	
}
