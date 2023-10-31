package com.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@OneToMany
	private List<OrderItem> orderItems;
	private String orderStatus;
	@OneToOne
	private User user;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int orderId, List<OrderItem> orderItems, String orderStatus, User user) {
		super();
		this.orderId = orderId;
		this.orderItems = orderItems;
		this.orderStatus = orderStatus;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderItems=" + orderItems + ", orderStatus=" + orderStatus + ", user="
				+ user + "]";
	}
	
	
}
