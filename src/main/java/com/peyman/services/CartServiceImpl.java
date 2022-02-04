package com.peyman.services;


import com.peyman.data.CartDao;
import com.peyman.data.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	CustomerOrderService customerOrderService;
	@Transactional()
	@Override
	public void addCart(Cart cart) {
		
	
		cartDao.save(cart);
		
		
	}
	@Transactional(readOnly = true)
	@Override
	public Cart getCartById(long cartId) {
	   
		
		
		return cartDao.find(cartId);
	}
	@Transactional(readOnly = true)
	@Override
	public Cart validateCustomer(long cartId) throws IOException {
		
		Cart cart=getCartById(cartId);
		
		if (cart==null || cart.getCartItems().size()==0) {
			
			throw new IOException(cartId+"");
		}
		
		
		  // Cart cart2 = null;
		
			//cart2 = updateCart(cart);
		updateCart(cart);
			
		
		 return getCartById(cartId);
	}
	
	private Cart updateCart(Cart cart) {
		 double grandTotal=0;
		 
		 
		
		grandTotal=customerOrderService.getCustomerOrderGrandTotal(cart.getCartId());
		
		cart.setGrandTotal(grandTotal);
		cartDao.save(cart);
		
		
		return cart;
	}

}
