package com.peyman.data;


import com.peyman.data.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerDao extends JpaRepository<Customer , Long> {


	public Customer findUserByusername(String username);
	Customer findCustomerByUsernameAndPassword(String username, String password);


}
