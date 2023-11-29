package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.OrderDto;
import com.dto.OrderItemDto;
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

	
	public List<OrderDto> getByuserId(int userId) {
		List<Orders> ordersList = ordersRepository.getOrdersbyuserId(userId);
		List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
		
		for(Orders order : ordersList) {
			List<OrderItemDto> orderItems = new ArrayList<OrderItemDto>();
			OrderDto orderDto= new OrderDto();
			for(OrderItem orderItem : order.getOrderItems()) {
				OrderItemDto orderItemDto= new OrderItemDto();
				orderItemDto.setOrderItemId(orderItem.getOrderItemId());
				orderItemDto.setProductName(orderItem.getPrduct().getProductName());
				orderItemDto.setProductPrice(orderItem.getPrduct().getPrice());
				orderItemDto.setQuantity(orderItem.getQuantity());
				orderItems.add(orderItemDto);
			}
			
			orderDto.setOrderItems(orderItems);
			orderDto.setAddress(order.getAddress());
			orderDto.setContact(order.getContact());
			orderDto.setTotalPrice(order.getTotalPrice());
			orderDto.setOrderId(order.getOrderId());
			orderDto.setUserId(order.getUser().getUserId());
			
			orderDtoList.add(orderDto);
		
		}
		return orderDtoList;
	}

	public OrderDto create(OrderDto orderDto) throws Exception {

		User user = userRepository.findById(orderDto.getUserId()).get();
		
		String addressString = null;
		if(orderDto.getAddress() != null) {
			addressString = orderDto.getAddress();
		}
		else {
			addressString = user.getAddress().toString();
		}	

		Cart cart = cartService.getbyuserId(orderDto.getUserId());

		List<CartItem> cartItemList = cartItemRepository.getuserIdCartItems(cart);
		
		Orders orders = new Orders();
		
		List<OrderItem> orderItemList= new ArrayList<OrderItem>();
		orders.setUser(user);
		orders.setAddress(addressString);
		

		for (CartItem cartItem : cartItemList) {
			OrderItem orderItem = new OrderItem();
			orderItem.setPrduct(cartItem.getProduct());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setOrders(orders);
			orderItemList.add(orderItem);
		}
		orders.setOrderItems(orderItemList);
		orders.setTotalPrice(orderDto.getTotalPrice());
		orders = ordersRepository.save(orders);
			
		
			List<OrderItemDto> orderItems = new ArrayList<OrderItemDto>();
			for(OrderItem orderItem : orderItemList) {
				OrderItemDto orderItemDto= new OrderItemDto();
				orderItemDto.setOrderItemId(orderItem.getOrderItemId());
				orderItemDto.setProductName(orderItem.getPrduct().getProductName());
				orderItemDto.setProductPrice(orderItem.getPrduct().getPrice());
				orderItemDto.setQuantity(orderItem.getQuantity());
				orderItems.add(orderItemDto);
			}
			
			orderDto.setOrderItems(orderItems);
			orderDto.setAddress(orders.getAddress());
			orderDto.setContact(orders.getContact());
			orderDto.setTotalPrice(orders.getTotalPrice());
			orderDto.setOrderId(orders.getOrderId());
			orderDto.setUserId(orders.getUser().getUserId());
			
		
		return orderDto;
	}

}
