package com.peyman.data;

import com.peyman.data.entities.Cart;
import com.peyman.data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface CartDao extends JpaRepository<Cart, Long> {

	Cart findUserBycartId(long cartId);




}
