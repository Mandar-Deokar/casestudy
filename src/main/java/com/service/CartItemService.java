package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CartItem;
import com.entity.Product;
import com.repository.CartItemRepository;

@Service
public class CartItemService {
	
	@Autowired
	CartItemRepository cartItemRepository;

	public CartItem add(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
