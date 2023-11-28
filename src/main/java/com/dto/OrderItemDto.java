package com.dto;

public class OrderItemDto {

	private String email;
	private String address;
	private String contact;
	private int totalPrice;
	private int userId;
	private int orderItemId;
	
	public OrderItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemDto(String email, String address, String contact, int totalPrice, int userId, int orderItemId) {
		super();
		this.email = email;
		this.address = address;
		this.contact = contact;
		this.totalPrice = totalPrice;
		this.userId = userId;
		this.orderItemId = orderItemId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	@Override
	public String toString() {
		return "OrderItemDto [email=" + email + ", address=" + address + ", contact=" + contact + ", totalPrice="
				+ totalPrice + ", userId=" + userId + ", orderItemId=" + orderItemId + "]";
	}
	
	
}
