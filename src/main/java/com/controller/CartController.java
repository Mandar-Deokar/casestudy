package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cart;
import com.entity.CartItem;
import com.service.CartItemService;
import com.service.CartService;
import com.service.ProductService;
import com.service.UserService;

@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartItemService cartItemService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/cart/{userId}/getCart")
	public ResponseEntity<?> getCartbyuserId(@PathVariable int userId) {
		try {
			Cart cart = cartService.getbyuserId(userId);  
			if (cart != null) {
				return ResponseEntity.ok(cart);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
	@GetMapping("/cart/{userId}/getCartItem/{cartItemId}")
	public ResponseEntity<?> getCartItembycartItemId(@PathVariable int userId, @PathVariable int cartItemId) {
		try {
			
			CartItem cartItem = cartItemService.getbycartItemId(cartItemId);
			if (cartItem != null) {
				return ResponseEntity.ok(cartItem);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/cart/{userId}/add/{productId}")
	public ResponseEntity<?> addtocart(@PathVariable int userId, @PathVariable int productId) {
		try {
			CartItem  cartItem = cartItemService.add(userId, productId);
			if (cartItem != null) {
				return ResponseEntity.ok(cartItem);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/cart/{userId}/remove/{productId}")
	public ResponseEntity<?> removefromcart(@PathVariable int userId, @PathVariable int productId) {
		try {
			String  productName = cartItemService.remove(userId, productId);
			if (productName != null) {
				return ResponseEntity.ok(productName);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
	 
	@PostMapping("/cart/{userId}/changeQuantity/{productId}")
	public ResponseEntity<?> changeQantityOfcartItem(@RequestParam int quantity, @PathVariable int userId, @PathVariable int productId) {
		try {
			System.out.println("in the api");
			CartItem cartItem = cartItemService.changeQuantity(userId, productId,quantity);
			if (cartItem != null) {
				return ResponseEntity.ok(cartItem);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
	
	
	
	
}
