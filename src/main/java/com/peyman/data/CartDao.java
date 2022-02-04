package com.peyman.data;

import com.peyman.data.entities.Cart;
import com.peyman.data.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface CartDao {

	Cart findUserBycartId(long cartId);

	void save(Cart cart);

	List<Cart> findAll();

	void delete(long id);

	Cart find(long id);
}
