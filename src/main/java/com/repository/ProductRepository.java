package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("SELECT p FROM Product p JOIN p.category c WHERE c.categoryName = :category")
    List<Product> getCategoryProducts(@Param("category") String category);

	/*
	 * String
	 * str="SELECT p FROM product p WHERE LOWER(p.category.getCategoryname()) LIKE LOWER(concat('%', :searchString, '%')) "
	 * + "OR LOWER(p.detail) LIKE LOWER(concat('%', :searchString, '%')) " +
	 * "OR LOWER(p.name) LIKE LOWER(concat('%', :searchString, '%'))  " +
	 * "OR LOWER(p.madein) LIKE LOWER(concat('%', :searchString, '%'))  "
	 * +"OR LOWER(p.brand) LIKE LOWER(concat('%', :searchString, '%'))  " ;
	 * 
	 * @Query(str) List<Product> getSearchStringProducts(@Param("searchSting")
	 * String searchString);
	 * 
	 * @Query("SELECT p FROM product p WHERE p.category = :category AND p.brand = :brand AND p.price BETWEEN :min AND :max AND p.rating >= :rating AND p.madein = :madein"
	 * ) List<Product> getBrandMadeinProducts(
	 * 
	 * @Param("category") String category,
	 * 
	 * @Param("min") int min,
	 * 
	 * @Param("max") int max,
	 * 
	 * @Param("rating") int rating,
	 * 
	 * @Param("madein") String madein,
	 * 
	 * @Param("brand") String brand );
	 * 
	 * @Query("SELECT p FROM product p WHERE p.category = :category AND p.brand = :brand AND p.price BETWEEN :min AND :max AND p.rating >= :rating"
	 * ) List<Product> getBrandProducts(
	 * 
	 * @Param("category") String category,
	 * 
	 * @Param("min") int min,
	 * 
	 * @Param("max") int max,
	 * 
	 * @Param("rating") int rating,
	 * 
	 * @Param("brand") String brand );
	 * 
	 * @Query("SELECT p FROM product p WHERE p.category = :category AND p.madein = :madein AND p.price BETWEEN :min AND :max AND p.rating >= :rating"
	 * ) List<Product>getMadeinProducts(
	 * 
	 * @Param("category") String category,
	 * 
	 * @Param("min") int min,
	 * 
	 * @Param("max") int max,
	 * 
	 * @Param("rating") int rating,
	 * 
	 * @Param("madein") String madein );
	 * 
	 * @Query("SELECT p FROM product p WHERE p.category = :category AND p.price BETWEEN :min AND :max AND p.rating >= :rating"
	 * ) List<Product> getProducts(
	 * 
	 * @Param("category") String category,
	 * 
	 * @Param("min") int min,
	 * 
	 * @Param("max") int max,
	 * 
	 * @Param("rating") int rating );
	 */

	
}
