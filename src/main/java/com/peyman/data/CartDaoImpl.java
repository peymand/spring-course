package com.peyman.data;

import com.peyman.data.entities.Cart;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class CartDaoImpl implements CartDao {
    @Override
    public Cart findUserBycartId(long cartId) {
        return null;
    }

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Cart cart) {
        entityManager.persist(cart);
        entityManager.close();
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
        return entityManager.find(Cart.class,  id);
    }
}
