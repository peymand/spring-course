package com.peyman.controllers;


import com.peyman.data.entities.Cart;
import com.peyman.data.entities.Customer;
import com.peyman.exceptions.CustomError;
import com.peyman.services.CartService;
import com.peyman.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/customer/cart")
public class CartController implements HandlerExceptionResolver {

	
	
	 @Autowired
	 private CustomerService customerService;

	@Autowired
	private CartService cartService;

	    @RequestMapping
	    public String getCart(@AuthenticationPrincipal User activeUser){
	    	Customer customer = customerService.findCustomerByUsername(activeUser.getUsername());
//	        long cartId = customer.getCart().getCartId();
			Cart cart =cartService.getCartById(customer.getCustomerId());
			long cartId = cart.getCartId();

	        return "redirect:/customer/cart/" + cartId;
	    }

	    @RequestMapping("/{cartId}")
	    public String getCartRedirect(@PathVariable(value = "cartId") long cartId, Model model){
	        model.addAttribute("cartId", cartId);

	        return "cart";
	    }

	
	    
	    
	  
		public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                             Exception ex) {
			ModelAndView modelAndView=new ModelAndView();
			CustomError error=new CustomError();
		
			
			error.setMessage("Your request is not valid.Please Enter a valid request.");
			modelAndView.addObject("customError", error);
			modelAndView.setViewName("error_page");
			
			return modelAndView;
		}
	
}
