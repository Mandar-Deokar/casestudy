package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;
	@ManyToOne
	private Product product;
	private int quantity;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnore
	private Cart cart;

	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(int cartItemId, Product product, int quantity) {
		super();
		this.cartItemId = cartItemId;
		this.product = product;
		this.quantity = quantity;
	}


	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", product=" + product + ", quantity=" + quantity + "]";
	}


	
}
