package com.dto;

import java.util.List;

public class OrderDto {
	
	private int orderId;
	private String address;
    private String contact;
    private double totalPrice;
    private int userId;
    private List<OrderItemDto> orderItems;
    
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDto(int orderId, String address, String contact, double totalPrice, int userId,
			List<OrderItemDto> orderItems) {
		super();
		this.orderId = orderId;
		this.address = address;
		this.contact = contact;
		this.totalPrice = totalPrice;
		this.userId = userId;
		this.orderItems = orderItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<OrderItemDto> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDto> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", address=" + address + ", contact=" + contact + ", totalPrice="
				+ totalPrice + ", userId=" + userId + ", orderItems=" + orderItems + "]";
	}
	

	
	
	
	
	
	
    
}
