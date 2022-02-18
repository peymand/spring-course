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
        List<CartItem> resultList = entityManager.createQuery("from CartItem c WHERE c.product =:product").setParameter("product", product).getResultList();
        entityManager.close();
        return resultList;
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
        List<CartItem> resultList = entityManager.createQuery("from CartItem c WHERE c.cart =:cart").setParameter("cart", cart).getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public void deleteCartItemById(long cartItemId) {
        entityManager.createNativeQuery("DELETE  FROM cartItem WHERE cartItemId = :cartItemId ")
                .setParameter("cartItemId",cartItemId).executeUpdate();
      entityManager.close();
    }
}
