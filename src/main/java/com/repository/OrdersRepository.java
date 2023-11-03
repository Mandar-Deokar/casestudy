package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	
	@Query("SELECT o FROM Orders o WHERE o.user.userId = :userId")
	Orders getOrdersbyuserId(int userId);
	
}
