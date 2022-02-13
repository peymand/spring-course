package com.peyman.data;


import com.peyman.data.entities.Cart;
import com.peyman.data.entities.CartItem;
import com.peyman.data.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface CartItemDao{

	List<CartItem> findUserByProduct(Product product);

	void save(CartItem cartItem);

	void removeByCart(Cart cart);
	
	List<CartItem> findAllCartItemsBycart(Cart cart);
	
//	@Modifying
//	@Transactional
//	@Query(value="DELETE  FROM cartItem  WHERE cartItemId = :cartItemId ",nativeQuery=true)
    void deleteCartItemById(long cartItemId);
//
	
	
	
}
