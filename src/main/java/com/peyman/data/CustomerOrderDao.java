package com.peyman.data;

import com.peyman.data.entities.Cart;
import com.peyman.data.entities.CustomerOrder;
import com.peyman.data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerOrderDao extends JpaRepository<CustomerOrder , Long> {

	CustomerOrder getCustomerOrderBycart(Cart cart);


}
