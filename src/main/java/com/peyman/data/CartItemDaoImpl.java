package com.peyman.data;

import com.peyman.data.entities.Cart;
import com.peyman.data.entities.CartItem;
import com.peyman.data.entities.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class CartItemDaoImpl implements CartItemDao {
    @PersistenceContext
    EntityManager  entityManager;

    @Override
    public List<CartItem> findUserByProduct(Product product) {
        return null;
    }

    @Override
    public void save(CartItem cartItem) {
        entityManager.persist(cartItem);
        entityManager.close();
    }

    @Override
    public void removeByCart(Cart cart) {

    }

    @Override
    public List<CartItem> findAllCartItemsBycart(Cart cart) {
        return null;
    }

    @Override
    public void deleteCartItemById(long cartItemId) {

    }
}
