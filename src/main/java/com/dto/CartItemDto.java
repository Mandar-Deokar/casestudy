package com.dto;


public class CartItemDto {
	
	private int productId;
	private String productName;
	private double price;
	private String details;
	private String brand;
	private String madeIn;
	private double rating;
	private String category;
	private String image;
	private int quantity;
	private int cartId;
	private int userId;
	private int cartItemId;
	
	public CartItemDto() {
		super();
	}

	public CartItemDto(int productId, String productName, double price, String details, String brand, String madeIn,
			double rating, String category, String image, int quantity, int cartId, int userId, int cartItemId) {
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
		this.quantity = quantity;
		this.cartId = cartId;
		this.userId = userId;
		this.cartItemId =cartItemId;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CartItemDto [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", details=" + details + ", brand=" + brand + ", madeIn=" + madeIn + ", rating=" + rating
				+ ", category=" + category + ", image=" + image + ", quantity=" + quantity + ", cartId=" + cartId
				+ ", userId=" + userId + ", cartItemId=" + cartItemId + "]";
	}
	    
	   
}

