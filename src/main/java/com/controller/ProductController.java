package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ProductDto;
import com.entity.Product;
import com.filter.Filter;
import com.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/products/getById/{productId}")
	public ResponseEntity<?> get(@PathVariable int productId) {
		try {
			ProductDto productDto = productService.get(productId);
			if (productDto != null)
				return ResponseEntity.ok(productDto);
			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("/products/addProduct")
	public ResponseEntity<?> addproduct(@RequestBody ProductDto product) {
		try {
			if (product != null) {
				ProductDto newproduct = productService.create(product);
				return ResponseEntity.ok(newproduct);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("/products/update")
	public ResponseEntity<?> updateproduct(@RequestBody Product product) {
		try {
			if (product != null) {
				ProductDto updatedproduct = productService.update(product);
				return ResponseEntity.ok(updatedproduct);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/products/{category}")
	public ResponseEntity<?> getProductbyCategory(@PathVariable String category) {
		try {
			if (category != null) {
				List<Product> products = productService.getbyCategory(category);
				return ResponseEntity.ok(products);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/products/search/{searchString}")
	public ResponseEntity<?> getbyProductSearchString(@PathVariable String searchString) {
		try {
			if (searchString != null) {
				List<Product> products = productService.getbySearchString(searchString);
				return ResponseEntity.ok(products);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("/products/{category}/getFilteredProducts")
	public ResponseEntity<?> getbyProductFilter(@PathVariable String category, @RequestBody Filter filter) {
		try {
			if (filter != null) {
				List<Product> products = productService.getbyFilter(category, filter);
				return ResponseEntity.ok(products);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/products")
	public ResponseEntity<?> getallProducts() {
		try {
			List<ProductDto> products = productService.getallproducts();
			if (products!=null) {
				
				return ResponseEntity.ok(products);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable int productId) {
		try {
			ProductDto productDto = productService.deleteproduct(productId);
			if (productDto!=null) {
				
				return ResponseEntity.ok(productDto);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
