package com.peyman.services;


import com.peyman.data.CartItemDao;
import com.peyman.data.entities.Cart;
import com.peyman.data.entities.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class CartItemServiceImpl implements CartItemService{

	@Autowired
	private ProductService productService;
	
	@Autowired
		private CartItemDao cartItemDao;
	
	
	
	@Transactional()
	@Override
	public void addCartItem(CartItem cartItem) {
		
		cartItemDao.save(cartItem);
	}
	@Transactional()
	@Override
	public void deleteCartItem(CartItem cartItem) {
		
		
		
	
			
			
			
			cartItemDao.deleteCartItemById(cartItem.getCartItemId());
			
		
		
	}

	
	@Override
	public void removeAllCartItems(Cart cart) {
	
		List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems){
           deleteCartItem(item);
        }
		
	}
	@Transactional(readOnly = true)
	@Override
	public CartItem getCartItemByProduct(long productId) {
		
		List<CartItem> cartItems=cartItemDao.findUserByProduct(productService.find(productId));
		
		return cartItems.get(0);
	}
	@Transactional(readOnly = true)
	@Override
	public List<CartItem> findAllCartItemsBycart(Cart cart) {
		
		return cartItemDao.findAllCartItemsBycart(cart);
	}

	

	

	
}
