package com.dto;

public class OrderItemDto {

	private int orderItemId;
	private String productName;
	private double productPrice;
	private int quantity;
	
	
	public OrderItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemDto(int orderItemId, String productName, double productPrice, int quantity) {
		super();
		this.orderItemId = orderItemId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
	
	}


	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "OrderItemDto [orderItemId=" + orderItemId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", quantity=" + quantity + "]";
	}


	
	
	
}
