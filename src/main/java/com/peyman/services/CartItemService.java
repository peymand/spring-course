package com.peyman.services;


import com.peyman.data.entities.Cart;
import com.peyman.data.entities.CartItem;

import java.util.List;

public interface CartItemService {

	public void addCartItem(CartItem cartItem);
	
	public void deleteCartItem(CartItem cartItem);
	
	
	public void removeAllCartItems(Cart cart);
	
	CartItem getCartItemByProduct(long productId);
	List<CartItem> findAllCartItemsBycart(Cart cart);
}
