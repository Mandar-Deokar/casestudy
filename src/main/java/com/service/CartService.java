package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cart;
import com.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	UserService userService;
	
	public Cart getbyuserId(int userId) {
		Cart cart = cartRepository.getuserIdCart(userId);
		return cart;
	}
	
	
}
