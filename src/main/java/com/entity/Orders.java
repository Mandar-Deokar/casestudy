package com.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;
	
	private String orderStatus =  "pay on delivery";
	
	private String address;
	
	@ManyToOne
	private User user;
	
	private double totalPrice;
	
	private String contact;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Orders(int orderId, List<OrderItem> orderItems, String orderStatus, String address, User user,
			double totalPrice, String contact) {
		super();
		this.orderId = orderId;
		this.orderItems = orderItems;
		this.orderStatus = orderStatus;
		this.address = address;
		this.user = user;
		this.totalPrice = totalPrice;
		this.contact = contact;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderItems=" + orderItems + ", orderStatus=" + orderStatus
				+ ", address=" + address + ", user=" + user + ", totalPrice=" + totalPrice + ", contact=" + contact
				+ "]";
	}

	
	
	
	
}
