package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Orders;
import com.service.OrdersService;

@RestController
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	
	
	
	
	@GetMapping("/order/{userId}/getOrders")
	public ResponseEntity<?> getOrderHistory(@PathVariable int userId) {
		try {
			Orders orders = ordersService.orderHistory(userId);
			if (orders != null) {
				return ResponseEntity.ok(orders);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/order/{userId}/createOrder")
	public ResponseEntity<?> createOrder(@PathVariable int userId) {
		try {
			Orders orders = ordersService.create(userId);
			if (orders != null) {
				return ResponseEntity.ok(orders);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
}
