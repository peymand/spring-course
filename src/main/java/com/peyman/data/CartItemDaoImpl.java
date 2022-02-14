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
//        entityManager.persist(cartItem);
        entityManager.merge(cartItem);
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
//        @Query(value="DELETE  FROM cartItem  WHERE cartItemId = :cartItemId ",nativeQuery=true)
//        entityManager.createNativeQuery("DELETE  FROM cartItem WHERE cartItemId = :cartItemId ")
//                .setParameter("cartItemId",cartItemId).executeUpdate();
        CartItem cartItem = entityManager.find(CartItem.class, cartItemId);
        entityManager.remove(cartItem);
        entityManager.close();
    }
}
