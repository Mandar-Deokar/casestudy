package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	@Column(name = "productname", unique = true)
	private String productName;
	@Column(name = "price", precision = 3, nullable = false)
	private double price;
	@Column(name = "details", nullable = false)
	private String details;
	@Column(name = "brand", nullable = false)
	private String brand;
	@Column(nullable = false)
	private String madeIn;
	@Column(name = "rating", precision = 3)
	private double rating;
	@OneToOne
	@JoinColumn(name = "category_id") // This specifies the join column
	private Category category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, double price, String details, String brand, String madeIn,
			double rating, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.details = details;
		this.brand = brand;
		this.madeIn = madeIn;
		this.rating = rating;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMadeIn() {
		return madeIn;
	}

	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", details="
				+ details + ", brand=" + brand + ", madeIn=" + madeIn + ", rating=" + rating + ", category=" + category
				+ "]";
	}

}
