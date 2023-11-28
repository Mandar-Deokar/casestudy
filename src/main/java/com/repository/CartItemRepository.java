package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Cart;
import com.entity.CartItem;
import com.entity.Product;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
	
	 @Query("SELECT ci FROM CartItem ci WHERE ci.product = :product AND ci.cart = :cart")
	 CartItem findByProductAndCart(@Param("product") Product product, @Param("cart") Cart cart);
	 
	 @Query("SELECT ci FROM CartItem ci WHERE ci.cartItemId = :cartItemId")
	 CartItem getByCartItemId(@Param("cartItemId") int cartItemId);
	 
	 @Modifying
	 @Query("DELETE FROM CartItem ci WHERE ci.product = :product AND ci.cart = :cart")
	 void removeByProductAndCart(@Param("product") Product product,@Param("cart") Cart cart);
	 
	 
	 @Query("SELECT ci FROM CartItem ci WHERE ci.cart = :cart")
	 List<CartItem> getuserIdCartItems(@Param("cart") Cart cart);
	 
	 @Modifying
	 @Query("DELETE FROM CartItem ci WHERE ci.cartItemId = :cartItemId")
	 void removeById(@Param("cartItemId") int cartItemId);
}

