package com.service;

import org.springframework.stereotype.Service;

import com.entity.Cart;
import com.entity.CartItem;
import com.repository.CartRepository;

@Service
public class CartService {
	
	CartRepository cartRepository;
	
	public Cart getbyuserId(int userId) {
		Cart cart = cartRepository.getuserIdCart(userId);
		return cart;
	}
	
//	public CartItem getbycartItemId(int cartItemId, Cart cart) {
//		CartItem cartItem = cartRepository.findByCartItemIdCartItem(cart.getCartId(), cartItemId);  
//		return cartItem;
//	}
	
	
	
}
