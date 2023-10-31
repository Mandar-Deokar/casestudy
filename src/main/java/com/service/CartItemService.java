package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.CartItemRepository;

@Service
public class CartItemService {
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	
}
