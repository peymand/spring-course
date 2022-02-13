package com.peyman.controllers;

import com.peyman.data.entities.*;
import com.peyman.exceptions.CustomError;
import com.peyman.services.AuthoritiesService;
import com.peyman.services.CartService;
import com.peyman.services.CustomerService;
import com.peyman.services.UsersService;
import com.peyman.validators.PasswordValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
@AllArgsConstructor
@Data
public class CustomerRegisterController implements HandlerExceptionResolver{


	private CustomerService customerService;
	private UsersService usersService;
	private CartService cartService;
	private AuthoritiesService authoritiesService;
	private PasswordValidator passwordValidator;

	@GetMapping("/register")
	public String registerCustomer(@ModelAttribute("customer") Customer customer){
//		customer.setCustomerEmailAddress("a@a.com");
//		customer.setCustometPhoneNumber("09121111111");
//		customer.setCustomerName("dummy");

		return "registerCustomer";
	}

	@PostMapping("/register")
	public String save(@Valid @ModelAttribute("customer") Customer customer , BindingResult result, Model model, HttpServletRequest request){

		if(result.hasErrors()){
			return "registerCustomer";
		}


		List<Customer> customerList=customerService.getAllCustomers();

		 if(customerList == null)
		 	customerList = new ArrayList<>();

		for (Customer customer2 : customerList) {

			if (customer2.getCustomerEmailAddress().equals(customer.getCustomerEmailAddress())) {
				model.addAttribute("emailMsg","Email already exists");
				return "registerCustomer";
			}

			if (customer2.getUsername().equals(customer.getUsername())) {
				model.addAttribute("usernameMsg","Username already exists");
				return "registerCustomer";
			}
		}

		customer.setEnabled(true);
		customerService.addCustomer(customer);
		Users users=new Users();
		users.setCustomerId(customer.getCustomerId());
		users.setEnabled(true);
		users.setPassword(customer.getPassword());
		users.setUsername(customer.getUsername());

		usersService.addUsers(users);


		Authorities authorities=new Authorities();
		authorities.setAuthorityType("ROLE_USER");
		authorities.setUsername(customer.getUsername());



		authoritiesService.addAuthorities(authorities);



		Cart cart=new Cart();
		cart.setCustomer(customer);
		cart.setGrandTotal(0);

		cartService.addCart(cart);

		customer.setCart(cart);
		customerService.updateCustomer(customer);


		autoLogin(customer,request);


		return "registerCustomerSuccess";
	}


	private void autoLogin(Customer customer,HttpServletRequest request) {

		String username=customer.getUsername();
		String password=customer.getPassword();



		// generate session if one doesn't exist
		request.getSession();


		Authentication authentication=new UsernamePasswordAuthenticationToken(username, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);


	}


	@RequestMapping("/customer/update")
	public String customerUpdate(){

		return "updateCustomer";
	}


	@RequestMapping(value="/customer/update",method=RequestMethod.POST)
	public String customerUpdatePost(@RequestParam("username")String username,@RequestParam("password")String password,Model model){

		Customer customer=customerService.findCustomerByusernameAndpassword(username, password);

		if (customer==null) {

			return "updateCustomer";
		}

		model.addAttribute("customer",customer);


		model.addAttribute("update","update");
		return "registerCustomer";
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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(passwordValidator);
	}





}
