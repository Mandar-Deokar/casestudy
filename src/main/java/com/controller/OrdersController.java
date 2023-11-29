package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.OrderDto;
import com.entity.OrderItem;
import com.entity.Orders;
import com.service.OrderItemService;
import com.service.OrdersService;

@RestController
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	
	@Autowired
	OrderItemService orderItemService;
	
	
	@GetMapping("/orders/{userId}")
	public ResponseEntity<?> getOrderHistory(@PathVariable int userId) {
		try {
			List<OrderDto> ordersList = ordersService.getByuserId(userId);
			if (ordersList != null) {
				return ResponseEntity.ok(ordersList);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/order/createOrder")
	public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
		try {
			OrderDto orderDtoRes = ordersService.create(orderDto);
			if (orderDtoRes != null) {
				return ResponseEntity.ok(orderDtoRes);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/order/{ordersId}")
	public ResponseEntity<?> getOrder(@PathVariable int ordersId) {
		try {
			List<OrderItem> orderList = orderItemService.getOrderById(ordersId);
			if (orderList != null) {
				return ResponseEntity.ok(orderList);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
}
