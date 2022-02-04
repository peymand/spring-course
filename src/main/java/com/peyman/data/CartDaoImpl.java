package com.peyman.data;

import com.peyman.data.entities.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CartDaoImpl implements CartDao {
    @Override
    public Cart findUserBycartId(long cartId) {
        return null;
    }

    @Override
    public void save(Cart cart) {

    }

    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Cart find(long id) {
        return null;
    }
}
