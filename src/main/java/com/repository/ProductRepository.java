package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p JOIN p.category c WHERE c.categoryName = :category")
	List<Product> getCategoryProducts(@Param("category") String category);

	String string = "SELECT p FROM Product p  WHERE "
			+ "LOWER(p.category.categoryName) LIKE LOWER(concat('%', :searchString, '%')) "
			+ "OR LOWER(p.details) LIKE LOWER(concat('%', :searchString, '%')) "
			+ "OR LOWER(p.productName) LIKE LOWER(concat('%', :searchString, '%')) "
			+ "OR LOWER(p.brand) LIKE LOWER(concat('%', :searchString, '%'))"
			+ "OR LOWER(p.madeIn.madeInName) LIKE LOWER(concat('%', :searchString, '%'))";

	@Query(string) 
	 List<Product> getSearchStringProducts(@Param("searchString") String searchString);

	@Query("SELECT p FROM Product p WHERE p.category.categoryName = :category AND p.brand = :brand AND p.price BETWEEN :min AND :max AND p.rating >= :rating AND p.madeIn.madeInName = :madein")
	List<Product> getBrandMadeinProducts(
			@Param("category") String category,
			@Param("min") int min,
			@Param("max") int max,
			@Param("rating") int rating,
			@Param("madein") String madein,
			@Param("brand") String brand);

	@Query("SELECT p FROM Product p WHERE p.category.categoryName = :category AND p.brand = :brand AND p.price BETWEEN :min AND :max AND p.rating >= :rating")
	List<Product> getBrandProducts(
			@Param("category") String category,
			@Param("min") int min,
			@Param("max") int max,
			@Param("rating") int rating,
			@Param("brand") String brand);

	@Query("SELECT p FROM Product p WHERE p.category.categoryName = :category AND p.madeIn.madeInName = :madein AND p.price BETWEEN :min AND :max AND p.rating >= :rating")
	List<Product> getMadeinProducts(
			@Param("category") String category,
			@Param("min") int min,
			@Param("max") int max,
			@Param("rating") int rating,
			@Param("madein") String madein);
	
	@Query("SELECT p FROM Product p WHERE p.category.categoryName = :category AND p.price BETWEEN :min AND :max AND p.rating >= :rating")
	List<Product> getProducts(
			@Param("category") String category,
			@Param("min") int min,
			@Param("max") int max,
			@Param("rating") int rating);
	
	@Query("SELECT p FROM Product p")
	List<Product> getall();

}
