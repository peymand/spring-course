package com.peyman.services;


import com.peyman.data.entities.Cart;

import java.io.IOException;

public interface CartService {

	public void addCart(Cart cart);
	
	public Cart getCartById(long cartId);

	public Cart getCartByCustomerId(long customerId);

	Cart validateCustomer(long cartId) throws IOException;
}
