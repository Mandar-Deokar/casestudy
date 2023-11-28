package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Cart;
import com.entity.CartItem;
import com.entity.OrderItem;
import com.entity.Orders;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{
	
	@Query("SELECT oi FROM OrderItem oi WHERE oi.orders = :orders")
	List<OrderItem> getOrderItemsByOrders(@Param("orders")  Orders orders);

}
