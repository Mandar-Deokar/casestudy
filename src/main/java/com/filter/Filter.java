package com.filter;

public class Filter {
	int max;
	int min;
	int rating;
	String madein;
	String brand;
	
	public Filter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Filter(int max, int min, int rating, String madein, String brand) {
		super();
		this.max = max;
		this.min = min;
		this.rating = rating;
		this.madein = madein;
		this.brand = brand;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getMadein() {
		return madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Filter [max=" + max + ", min=" + min + ", rating=" + rating + ", madein=" + madein + ", brand=" + brand
				+ "]";
	}
	
	
}
