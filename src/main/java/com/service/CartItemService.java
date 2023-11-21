package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.ProductDto;
import com.entity.Cart;
import com.entity.CartItem;
import com.entity.Product;
import com.entity.User;
import com.repository.CartItemRepository;
import com.repository.CartRepository;
import com.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartItemService {

	@Autowired
	CartItemRepository cartItemRepository;

	@Autowired
	CartService cartService;

	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserService userService;

	@Autowired
	CartRepository cartRepository;

	public CartItem add(int userId, int productId) throws Exception {

		User user = userService.getbyId(userId);

		if (user == null) {
			throw new Exception("user not found");
		}

		Cart cart = cartService.getbyuserId(userId);

		Product product = productRepository.getById(productId);

		if (product == null) {
			throw new Exception("product not found");
		}

		CartItem cartItem = null;

		if (cart == null) {
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

		} else {
			cartItem = cartItemRepository.findByProductAndCart(product, cart);

			if (cartItem == null) {
				cartItem = new CartItem();
				cartItem.setProduct(product);
				cartItem.setQuantity(1);
				cartItem.setCart(cart);

				CartItem item = cartItemRepository.save(cartItem);
				System.out.println(item);

				return item;
//				cartRepository.save(cart);
			} else {
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				CartItem item = cartItemRepository.save(cartItem);
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

	public String remove(int userId, int productId) throws Exception {

		Cart cart = cartService.getbyuserId(userId);
		if (cart == null) {
			throw new Exception("cart not found");
		}

		Product product = productRepository.getById(productId);
		if (product == null) {
			throw new Exception("product not found");
		}

		cartItemRepository.removeByProductAndCart(product, cart);

		return product.getProductName();
	}

	@SuppressWarnings("deprecation")
	public CartItem changeQuantity(int userId, int productId, int quantity) throws Exception {

		Cart cart = cartService.getbyuserId(userId);
		if (cart == null) {
			throw new Exception("cart not found");
		}

		Product product = productRepository.getById(productId);
		if (product == null) {
			throw new Exception("product not found");
		}

		CartItem cartItem = cartItemRepository.findByProductAndCart(product, cart);
		if (cartItem == null) {
			throw new Exception("cartItem not found");
		}

		cartItem.setQuantity(quantity);
		cartItem = cartItemRepository.save(cartItem);
		System.out.println("cartItem");

		return cartItem;
	}

}
