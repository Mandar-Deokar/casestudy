
package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderitemid;

	@ManyToOne
	private Product prduct;
	private int quantity;
	
	@ManyToOne
	private Orders orders;

	public OrderItem() {
		super();
	}

	public OrderItem(int orderitemid, Product prduct, int quantity) {
		super();
		this.orderitemid = orderitemid;
		this.prduct = prduct;
		this.quantity = quantity;

	}

	public int getOrderitemid() {
		return orderitemid;
	}

	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
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

	@Override
	public String toString() {
		return "OrderItem [orderitemid=" + orderitemid + ", prduct=" + prduct + ", quantity=" + quantity + "]";
	}

}
