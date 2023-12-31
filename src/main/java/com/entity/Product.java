package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	@Column(name = "product_name", unique = true)
	private String productName;
	@Column(name = "price", precision = 3)
	private double price;
	@Column(name = "details")
	private String details;
	@Column(name = "brand")
	private String brand;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "made_in")
	private MadeIn madeIn;
	
	@Column(name = "rating", precision = 3)
	private double rating;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category")
	private Category category;
	
	@Column(name = "image")
	private String image;

	
	public Product() {
		super();	
	}

	public Product(int productId, String productName, double price, String details, String brand, MadeIn madeIn,
			double rating, Category category, String image) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.details = details;
		this.brand = brand;
		this.madeIn = madeIn;
		this.rating = rating;
		this.category = category;
		this.image = image;
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

	
	public MadeIn getMadeIn() {
		return madeIn;
	}

	public void setMadeIn(MadeIn madeIn) {
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

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", details="
				+ details + ", brand=" + brand + ", madeIn=" + madeIn + ", rating=" + rating + ", category=" + category
				+ ", image=" + image + "]";
	}



}
