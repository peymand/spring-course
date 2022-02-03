package com.peyman.controllers;

import com.peyman.data.entities.BillingAddress;
import com.peyman.data.entities.Cart;
import com.peyman.data.entities.Customer;
import com.peyman.data.entities.ShippingAddress;
import com.peyman.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
@AllArgsConstructor
@Data
public class CustomerRegisterController {


	private CustomerService customerService;
	
	@GetMapping("/register")
	public String registerCustomer(@ModelAttribute("customer") Customer customer){
		return "registerCustomer";
	}

	@PostMapping("/register")
	public String save(@Valid @ModelAttribute("customer") Customer customer , BindingResult result){

		if(result.hasErrors()){
			return "registerCustomer";
		}

		customerService.addCustomer(customer);
		//TODO: create user based on customer data
		//TODO: SET Authority as a ROLE_USER and update authority table
		//TODO : persist user to database with is connected to the customer
		return "registerCustomerSuccess";
	}
	
	
	

	
	
	

}
