package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CartItemDto;
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
			List<CartItemDto> cartItemList = cartItemService.getbyuserId(userId);  
			//System.out.print(cartItemList);
			if (cartItemList != null) {
				return ResponseEntity.ok(cartItemList);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
	@GetMapping("/cart/{cartItemId}")
	public ResponseEntity<?> getCartItembycartItemId(@PathVariable int userId, @PathVariable int cartItemId) {
		try {
			
			CartItemDto cartItemDto = cartItemService.getbycartItemId(cartItemId);
			if (cartItemDto != null) {
				return ResponseEntity.ok(cartItemDto);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/cart/{userId}/add/{productId}")
	public ResponseEntity<?> addtocart(@PathVariable int userId, @PathVariable int productId, @RequestBody CartItemDto cartItemDto) {
		try {
			CartItem  cartItem = cartItemService.add(userId, productId, cartItemDto.getQuantity());
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
			CartItemDto  cartItemDto = cartItemService.remove(userId, productId);
			if (cartItemDto != null) {
				return ResponseEntity.ok(cartItemDto);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("cart/remove/{cartItemId}")
	public ResponseEntity<?> removefromcart(@PathVariable int cartItemId) {
		try {
			CartItemDto  cartItemDto = cartItemService.removeById(cartItemId);
			if (cartItemDto != null) {
				return ResponseEntity.ok(cartItemDto);
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
