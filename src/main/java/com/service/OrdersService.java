package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cart;
import com.entity.CartItem;
import com.entity.OrderItem;
import com.entity.Orders;
import com.entity.User;
import com.entity.UserAddress;
import com.repository.CartItemRepository;
import com.repository.CartRepository;
import com.repository.OrdersRepository;
import com.repository.UserRepository;

@Service
public class OrdersService {

	@Autowired
	OrdersRepository ordersRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CartService cartService;

	@Autowired
	CartItemRepository cartItemRepository;

	@Autowired
	OrderItemService orderItemService;

	
	public List<Orders> getByuserId(int userId) {
		List<Orders> ordersList = ordersRepository.getOrdersbyuserId(userId);
		return ordersList;
	}

	public Orders create(int userId) throws Exception {

		User user = userRepository.findById(userId).get();
		if (user == null) {
			throw new Exception("user not found");
		}
		
		String addressString = null;
		if(user.getAddress() != null) {
		addressString = user.getAddress().toString();
		}

		

		Cart cart = cartService.getbyuserId(userId);

		List<CartItem> cartItemList = cartItemRepository.getuserIdCartItems(cart);
		
		if(cartItemList == null) {
			throw new Exception("cart is null");
		}
		
		Orders orders = new Orders();
		orders.setUser(user);
		orders.setAddress(addressString);
		orders = ordersRepository.save(orders);

		for (CartItem cartItem : cartItemList) {
			orderItemService.create(cartItem, orders);
		}
		for (CartItem cartItem : cartItemList) {
			
			System.out.println(cart);
			System.out.println(cartItem.getCartItemId());
			cartItemRepository.removeById(cartItem.getCartItemId());
			
		}

		return orders;
	}

}
