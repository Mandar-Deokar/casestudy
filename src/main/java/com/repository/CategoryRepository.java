package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	

	String string = "SELECT c FROM Category c  WHERE "
			+ "LOWER(c.categoryName) LIKE LOWER(concat('%', :categoryName, '%')) ";

	@Query(string)
	Category getcategory(@Param("categoryName") String categoryName);
}
