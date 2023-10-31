package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Category;
import com.entity.Product;
import com.filter.Filter;
import com.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public Product get(int productId) {
		Product product =  productRepository.findById(productId).orElse(null);
		return product;
	}
	
	
	public Product create(Product product) {
		Product createdproduct= productRepository.save(product);
		return createdproduct;
	}
	
	public Product update(Product product) {
		Product tempproduct =  productRepository.findById(product.getProductId()).orElse(null);
		tempproduct.setCategory(product.getCategory());
		tempproduct.setDetails(product.getDetails());
		tempproduct.setProductName(product.getProductName());
		tempproduct.setPrice(product.getPrice());
		tempproduct.setBrand(product.getBrand());
		tempproduct.setRating(product.getRating());
		tempproduct.setMadeIn(product.getMadeIn());
		tempproduct.setCategory(product.getCategory());
		Product updatedproduct= productRepository.save(tempproduct);
		return updatedproduct;

	}
	
//	public List<Product> getbyCategory(String category){
//		List<Product> products = productRepository.getCategoryProducts(category);
//		return products;
//	}
	
	/*
	 * public List<Product> getbySearchString(String searchString){ List<Product>
	 * products = productRepository.getSearchStringProducts(searchString); return
	 * products; }
	 */
	
	/*
	 * public List<Product>getbyFilter(String category,Filter filter){ int min=0,
	 * max=10000000; int rating = 0; String madein; String brand;
	 * 
	 * min = filter.getMin(); max = filter.getMax(); rating = filter.getRating();
	 * madein = filter.getMadein(); brand = filter.getBrand();
	 * 
	 * List<Product> products;
	 * 
	 * 
	 * if(brand!=null && madein!=null) { products =
	 * productRepository.getBrandMadeinProducts(category,min,max,rating,
	 * madein,brand); } else if(brand!=null) { products =
	 * productRepository.getBrandProducts(category,min,max,rating,brand); } else
	 * if(madein!=null){ products =
	 * productRepository.getMadeinProducts(category,min,max,rating,madein); } else {
	 * products = productRepository.getProducts(category,min,max,rating); }
	 * 
	 * return products; }
	 * 
	 */
	
}
