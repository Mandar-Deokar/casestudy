package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalApplicationListener;

import com.dto.ProductDto;
import com.entity.Category;
import com.entity.MadeIn;
import com.entity.Product;
import com.filter.Filter;
import com.repository.CategoryRepository;
import com.repository.MadeInRepository;
import com.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository catRepo;
	@Autowired
	MadeInRepository madeInRepo;

	public ProductDto get(int productId) {
		Product product = productRepository.findById(productId).orElse(null);
		
		ProductDto productDto = new ProductDto();
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setPrice(product.getPrice());
		productDto.setDetails(product.getDetails());
		productDto.setBrand(product.getBrand());
		productDto.setMadeIn(product.getMadeIn().getMadeInName());
		productDto.setRating(product.getRating());
		productDto.setCategory(product.getCategory().getCategoryName());
		productDto.setImage(product.getImage());
		
		
		return productDto;
	}

	public ProductDto create(ProductDto product) {

		Product newproduct = new Product();

		newproduct.setBrand(product.getBrand());
		
		Category category = catRepo.getcategory(product.getCategory());
		if (category == null) {
			category = new Category();
			category.setCategoryName(product.getCategory());
			catRepo.save(category);
			newproduct.setCategory(category);
		} else {
			newproduct.setCategory(category);
		}

		newproduct.setDetails(product.getDetails());

		MadeIn madeIn = madeInRepo.getmadeIn(product.getMadeIn());
		if (madeIn == null) {
			madeIn = new MadeIn();
			madeIn.setMadeInName(product.getMadeIn());
			madeInRepo.save(madeIn);
			newproduct.setMadeIn(madeIn);
		} else {
			newproduct.setMadeIn(madeIn);
		}

		newproduct.setPrice(product.getPrice());
		newproduct.setProductName(product.getProductName());
		newproduct.setRating(product.getRating());
		newproduct.setImage(product.getImage());

		newproduct = productRepository.save(newproduct);
		ProductDto productResponse = new ProductDto(newproduct.getProductId(), newproduct.getProductName(),
				newproduct.getPrice(), newproduct.getDetails(), newproduct.getBrand(),
				newproduct.getMadeIn().getMadeInName(), newproduct.getRating(),
				newproduct.getCategory().getCategoryName(),newproduct.getImage());

		return productResponse;
	}

	public ProductDto update(Product product) {
		Product tempproduct = productRepository.findById(product.getProductId()).orElse(null);
		tempproduct.setCategory(product.getCategory());
		tempproduct.setDetails(product.getDetails());
		tempproduct.setProductName(product.getProductName());
		tempproduct.setPrice(product.getPrice());
		tempproduct.setBrand(product.getBrand());
		tempproduct.setRating(product.getRating());
		tempproduct.setMadeIn(product.getMadeIn());
		tempproduct.setCategory(product.getCategory());
		productRepository.save(tempproduct);
		
		ProductDto productDto = new ProductDto();
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setPrice(product.getPrice());
		productDto.setDetails(product.getDetails());
		productDto.setBrand(product.getBrand());
		productDto.setMadeIn(product.getMadeIn().getMadeInName());
		productDto.setRating(product.getRating());
		productDto.setCategory(product.getCategory().getCategoryName());
		productDto.setImage(product.getImage());
		
		return productDto;

	}

	public List<Product> getbyCategory(String category) {
		List<Product> products = productRepository.getCategoryProducts(category);
		return products;
	}

	public List<Product> getbySearchString(String searchString) {
		List<Product> products = productRepository.getSearchStringProducts(searchString);
		return products;
	}

	public List<Product> getbyFilter(String category, Filter filter) {
		int min, max;
		int rating = 0;
		String madein;
		String brand;

		min = filter.getMin();
		max = filter.getMax();
		rating = filter.getRating();
		madein = filter.getMadein();
		brand = filter.getBrand();

		if (max == 0)
			max = 10000000;

		List<Product> products;

		if (brand != null && madein != null) {
			products = productRepository.getBrandMadeinProducts(category, min, max, rating, madein, brand);
		} else if (brand != null) {
			products = productRepository.getBrandProducts(category, min, max, rating, brand);
		} else if (madein != null) {
			products = productRepository.getMadeinProducts(category, min, max, rating, madein);
		} else {
			products = productRepository.getProducts(category, min, max, rating);
		}
		System.out.println(madein + max);
		return products;
	}

	public List<ProductDto> getallproducts() {
		List<Product> products = productRepository.getall();
		List<ProductDto> productlist = new ArrayList<ProductDto>();
		for(Product product: products) {
			
			ProductDto productDto = new ProductDto();
			productDto.setProductId(product.getProductId());
			productDto.setBrand(product.getBrand());
			productDto.setCategory(product.getCategory().getCategoryName());
			productDto.setDetails(product.getDetails());
			productDto.setImage(product.getImage());
			productDto.setMadeIn(product.getMadeIn().getMadeInName());
			productDto.setPrice(product.getPrice());
			productDto.setProductName(product.getProductName());
			productDto.setRating(product.getRating());
			
			productlist.add(productDto);
		}
		
		return productlist;
	}
	
	public ProductDto deleteproduct(int productId) {
		Optional<Product> opt = productRepository.findById(productId);
		Product product = opt.get();
		
		ProductDto productDto = new ProductDto();
		productDto.setProductId(product.getProductId());
		productDto.setBrand(product.getBrand());
		productDto.setCategory(product.getCategory().getCategoryName());
		productDto.setDetails(product.getDetails());
		productDto.setImage(product.getImage());
		productDto.setMadeIn(product.getMadeIn().getMadeInName());
		productDto.setPrice(product.getPrice());
		productDto.setProductName(product.getProductName());
		productDto.setRating(product.getRating());
		
		productRepository.deleteById(productId);
		return productDto;
	}
	
	
}
