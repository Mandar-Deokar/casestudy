package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cart;
import com.entity.CartItem;
import com.entity.Product;
import com.entity.User;
import com.repository.CartItemRepository;
import com.repository.CartRepository;

@Service
public class CartItemService {
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	ProductService productService;
	
	@Autowired 
	UserService userService;
	
	@Autowired
	CartRepository cartRepository;

	public CartItem add(int userId,int productId) throws Exception{
		
		User user = userService.getbyId(userId);
		
		if(user == null) { throw new Exception("user not found"); }
		
		Cart cart = cartService.getbyuserId(userId);
		
		Product product = productService.get(productId);

		if(product == null) { throw new Exception("product not found"); }
		
		CartItem cartItem = null; 
		
		if(cart == null) {
			cart = new Cart();
			cart.setUser(user);
//			cartRepository.save(cart);
			cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setQuantity(1);
			cartItem.setCart(cart);
			
			CartItem item = cartItemRepository.save(cartItem);
			System.out.println(item);
			return item;
			
			
			
		}
		else {
			cartItem = cartItemRepository.findByProductAndCart(product,cart);
			
			if(cartItem == null) {
				cartItem = new CartItem();
				cartItem.setProduct(product);
				cartItem.setQuantity(1);
				cartItem.setCart(cart);
				
				CartItem item = cartItemRepository.save(cartItem)  ;
				System.out.println(item);

				return item;
//				cartRepository.save(cart);
			}
			else {
				cartItem.setQuantity(cartItem.getQuantity()+1);
				CartItem item = cartItemRepository.save(cartItem) ;
				System.out.println(item);

				return item;
//				cartRepository.save(cart);
			}
			
		}
		
		

	}

	public CartItem getbycartItemId(int cartItemId) {
		CartItem cartItem = cartItemRepository.getByCartItemId(cartItemId); 
		return cartItem;
	}

	
}
