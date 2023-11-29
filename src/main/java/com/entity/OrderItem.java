
package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;

	@OneToOne
	private Product prduct;
	
	private int quantity;
	
	@ManyToOne
	@JsonIgnore
	private Orders orders;

	public OrderItem() {
		super();
	}

	public OrderItem(int orderItemId, Product prduct, int quantity) {
		super();
		this.orderItemId = orderItemId;
		this.prduct = prduct;
		this.quantity = quantity;

	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Product getPrduct() {
		return prduct;
	}

	public void setPrduct(Product prduct) {
		this.prduct = prduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
