package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	@Query("SELECT c FROM Cart c WHERE c.user.userId = :userId")
	Cart getuserIdCart(@Param("userId") int userId);
	
//	@Query("SELECT ci.cartItem FROM Cart ci WHERE ci.cartId = :cartId AND ci.cartItem.cartItemId = :carItemtId")
//	CartItem findByCartItemIdCartItem(@Param("cartId") int cartId,@Param("cartItemId") int cartItemId);

}
