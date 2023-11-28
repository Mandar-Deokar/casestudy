package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.CartItemDto;
import com.entity.Cart;
import com.entity.CartItem;
import com.entity.Product;
import com.entity.User;
import com.repository.CartItemRepository;
import com.repository.CartRepository;
import com.repository.ProductRepository;
import com.repository.UserRepository;

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
	
	@Autowired
	UserRepository userRepository;

	public CartItem add(int userId, int productId, int quantity) throws Exception {

		User user = userRepository.findById(userId).get();

		if (user == null) {
			throw new Exception("user not found");
		}

		Cart cart = cartService.getbyuserId(userId);

		Product product = productRepository.findById(productId).get();

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
			cartItem.setQuantity(quantity);
			cartItem.setCart(cart);

			CartItem item = cartItemRepository.save(cartItem);
			System.out.println(item);
			return item;

		} else {
			cartItem = cartItemRepository.findByProductAndCart(product, cart);

			if (cartItem == null) {
				cartItem = new CartItem();
				cartItem.setProduct(product);
				cartItem.setQuantity(quantity);
				cartItem.setCart(cart);

				CartItem item = cartItemRepository.save(cartItem);
				System.out.println(item);

				return item;
//				cartRepository.save(cart);
			} else {
				cartItem.setQuantity(cartItem.getQuantity() + quantity);
				CartItem item = cartItemRepository.save(cartItem);
				System.out.println(item);

				return item;
//				cartRepository.save(cart);
			}

		}

	}

	public CartItemDto getbycartItemId(int cartItemId) {
		CartItem cartItem = cartItemRepository.getByCartItemId(cartItemId);
		
CartItemDto cartItemDto = new CartItemDto();
		
		cartItemDto.setBrand(cartItem.getProduct().getBrand());
		cartItemDto.setCartId(cartItem.getCart().getCartId());
		cartItemDto.setCategory(cartItem.getProduct().getCategory().getCategoryName());
		cartItemDto.setDetails(cartItem.getProduct().getDetails());
		cartItemDto.setImage(cartItem.getProduct().getDetails());
		cartItemDto.setMadeIn(cartItem.getProduct().getMadeIn().getMadeInName());
		cartItemDto.setPrice(cartItem.getProduct().getPrice());
		cartItemDto.setProductId(cartItem.getProduct().getProductId());
		cartItemDto.setProductName(cartItem.getProduct().getProductName());
		cartItemDto.setQuantity(cartItem.getQuantity());
		cartItemDto.setRating(cartItem.getProduct().getRating());
		cartItemDto.setUserId(cartItem.getCart().getUser().getUserId());
		cartItemDto.setCartItemId(cartItem.getCartItemId());
		
		return cartItemDto;
		
	}

	public CartItemDto remove(int userId, int productId) throws Exception {

		Cart cart = cartService.getbyuserId(userId);
		if (cart == null) {
			throw new Exception("cart not found");
		}

		Product product = productRepository.findById(productId).get();
		if (product == null) {
			throw new Exception("product not found");
		}

		CartItem cartItem = cartItemRepository.findByProductAndCart(product, cart);
		
		cartItemRepository.removeByProductAndCart(product, cart);
		
		CartItemDto cartItemDto = new CartItemDto();
		
		cartItemDto.setBrand(cartItem.getProduct().getBrand());
		cartItemDto.setCartId(cartItem.getCart().getCartId());
		cartItemDto.setCategory(cartItem.getProduct().getCategory().getCategoryName());
		cartItemDto.setDetails(cartItem.getProduct().getDetails());
		cartItemDto.setImage(cartItem.getProduct().getDetails());
		cartItemDto.setMadeIn(cartItem.getProduct().getMadeIn().getMadeInName());
		cartItemDto.setPrice(cartItem.getProduct().getPrice());
		cartItemDto.setProductId(cartItem.getProduct().getProductId());
		cartItemDto.setProductName(cartItem.getProduct().getProductName());
		cartItemDto.setQuantity(cartItem.getQuantity());
		cartItemDto.setRating(cartItem.getProduct().getRating());
		cartItemDto.setUserId(cartItem.getCart().getUser().getUserId());
		cartItemDto.setCartItemId(cartItem.getCartItemId());
		
		return cartItemDto;
	}

	@SuppressWarnings("deprecation")
	public CartItem changeQuantity(int userId, int productId, int quantity) throws Exception {

		Cart cart = cartService.getbyuserId(userId);
		if (cart == null) {
			throw new Exception("cart not found");
		}

		Product product = productRepository.findById(productId).get();
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
	
	public List<CartItemDto> getbyuserId(int userId) {
		
		Cart cart = cartRepository.getuserIdCart(userId);
		
		List<CartItem> cartItemList = cartItemRepository.getuserIdCartItems(cart);
		List<CartItemDto> cartItemDtoList  = new ArrayList<CartItemDto>();
		for(CartItem item : cartItemList) {
			CartItemDto cartItemDto = new CartItemDto();
			
			cartItemDto.setBrand(item.getProduct().getBrand());
			cartItemDto.setCartId(item.getCart().getCartId());
			cartItemDto.setCategory(item.getProduct().getCategory().getCategoryName());
			cartItemDto.setDetails(item.getProduct().getDetails());
			cartItemDto.setImage(item.getProduct().getDetails());
			cartItemDto.setMadeIn(item.getProduct().getMadeIn().getMadeInName());
			cartItemDto.setPrice(item.getProduct().getPrice());
			cartItemDto.setProductId(item.getProduct().getProductId());
			cartItemDto.setProductName(item.getProduct().getProductName());
			cartItemDto.setQuantity(item.getQuantity());
			cartItemDto.setRating(item.getProduct().getRating());
			cartItemDto.setUserId(item.getCart().getUser().getUserId());
			cartItemDto.setCartItemId(item.getCartItemId());

			cartItemDtoList.add(cartItemDto);
		}
		
		return cartItemDtoList;
	}
	
	public CartItemDto removeById(int cartItemId) {
		
		CartItem cartItem = cartItemRepository.findById(cartItemId).get(); 
		
		cartItemRepository.removeById(cartItemId);
		
		CartItemDto cartItemDto = new CartItemDto();
		
		cartItemDto.setBrand(cartItem.getProduct().getBrand());
		cartItemDto.setCartId(cartItem.getCart().getCartId());
		cartItemDto.setCategory(cartItem.getProduct().getCategory().getCategoryName());
		cartItemDto.setDetails(cartItem.getProduct().getDetails());
		cartItemDto.setImage(cartItem.getProduct().getDetails());
		cartItemDto.setMadeIn(cartItem.getProduct().getMadeIn().getMadeInName());
		cartItemDto.setPrice(cartItem.getProduct().getPrice());
		cartItemDto.setProductId(cartItem.getProduct().getProductId());
		cartItemDto.setProductName(cartItem.getProduct().getProductName());
		cartItemDto.setQuantity(cartItem.getQuantity());
		cartItemDto.setRating(cartItem.getProduct().getRating());
		cartItemDto.setUserId(cartItem.getCart().getUser().getUserId());
		cartItemDto.setCartItemId(cartItem.getCartItemId());
		
		return cartItemDto;
	}

}
