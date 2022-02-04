package com.peyman.data;

import com.peyman.data.entities.Cart;
import com.peyman.data.entities.CustomerOrder;
import com.peyman.data.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface CustomerOrderDao{

	CustomerOrder getCustomerOrderBycart(Cart cart);

	void save(CustomerOrder product);

	List<CustomerOrder> findAll();

	void delete(long id);

	CustomerOrder find(long id);
}
