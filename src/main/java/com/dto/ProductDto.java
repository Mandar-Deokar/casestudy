package com.dto;



public class ProductDto {
	private int productId;
	private String productName;
	private double price;
	private String details;
	private String brand;
	private String madeIn;
	private double rating;
	private String category;
	private String image;
	
	public ProductDto() {
		super();
	}

	public ProductDto(int productId, String productName, double price, String details, String brand, String madeIn,
			double rating, String category, String image) {
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getMadeIn() {
		return madeIn;
	}

	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
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
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", price=" + price + ", details="
				+ details + ", brand=" + brand + ", madeIn=" + madeIn + ", rating=" + rating + ", category=" + category
				+ ", image=" + image + "]";
	}
	
	
}
