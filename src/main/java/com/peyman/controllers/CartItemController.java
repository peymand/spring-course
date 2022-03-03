package com.peyman.controllers;


import com.peyman.data.entities.Cart;
import com.peyman.data.entities.CartItem;
import com.peyman.data.entities.Customer;
import com.peyman.data.entities.Product;
import com.peyman.exceptions.CustomError;
import com.peyman.services.CartItemService;
import com.peyman.services.CartService;
import com.peyman.services.CustomerService;
import com.peyman.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/rest/cart")
public class CartItemController {

	@Autowired
	CartService cartService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	
	@Autowired
	CartItemService cartItemService;
	//GET CART FOR REST SERVICE
	@ApiOperation(value = "find cart by Id", response = Cart.class , produces = MediaType.APPLICATION_JSON_VALUE )
	@GetMapping("/{cartId}")
	public Cart getCartById(@PathVariable("cartId")int cartId){
		Cart cart = null;
		try{
		  cart = cartService.getCartById(cartId);
		}catch (RuntimeException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is not available", e);
		}

		return cart;
	}




	//REMOVE CART/CLEAR CART

	@DeleteMapping(value="/{cartId}")
	@ResponseStatus(value= HttpStatus.OK)
	public void clearCart(@PathVariable(value="cartId")int cartId){

		Cart cart=cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
		cartService.getCartById(cartId);
	}
	
	
	
	//ADD PRODUCT IN THE CART
	@RequestMapping(value="/add/{productId}",method= RequestMethod.PUT)
	@ResponseStatus(value= HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable("productId")int productId, @AuthenticationPrincipal User activeUser){
		
		Customer customer=customerService.findCustomerByUsername(activeUser.getUsername());
//		Cart cart=customer.getCart();
		Cart cart =cartService.getCartById(customer.getCustomerId());
		Product product=productService.getProductById(productId);
		
		
		List<CartItem> cartItems=cart.getCartItems();
		
		
	
		
		//IF PRODUCT ALREDAY EXIST IN CART THEN INCRESE ITS QUANTITY
	
		for(int i=0;i<cartItems.size();i++){
			
			if (product.getProductId()==cartItems.get(i).getProduct().getProductId()) {
//		if (product.getProductId()==cartItems.get(i).getProductId()) {
				CartItem cartItem=cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity()+1);
				cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
				
				return;
			}
		}
		
		
		//IF PRODUCT IS NEW 
		
		
		CartItem cartItem=new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
		
		
	}
	
	//REMOVE A CARTITEM FROM CART
	
	@RequestMapping(value="/remove/{productId}",method= RequestMethod.PUT)
	@ResponseStatus(value= HttpStatus.OK)
	public void removeItem(@PathVariable("productId") int productId){
		System.out.println("--------------hahah----------------");
		CartItem cartItem=cartItemService.getCartItemByProduct(productId);
		
		System.out.println("C:"+cartItem.getTotalPrice());
		System.out.println(cartItem);
		cartItemService.deleteCartItem(cartItem);
		System.out.println("c:hpoihpoifihihitih-----------");
	}
	
	


	
	//EXCEPTION HANDLING
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR,reason="")
	public void handleClientErrors(Exception e){

	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value= HttpStatus.BAD_REQUEST,reason="Illegal request,please verify your payload")
	public void handleServerErrors(Exception e){}

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND,reason="Id is is not found")
    public void handleNotFoundErrors(RuntimeException e){

    }
}
