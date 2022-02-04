package com.peyman.services;


import com.peyman.data.entities.Customer;

import java.util.List;

public interface CustomerService {

	public void addCustomer(Customer customer);
	public Customer findCustomerByUsername(String username);
	
	List<Customer> getAllCustomers();
	
	public Customer getCustomerBycustomerId(long customerId);
	
	Customer findCustomerByusernameAndpassword(String username, String password);

    void updateCustomer(Customer customer);
}
