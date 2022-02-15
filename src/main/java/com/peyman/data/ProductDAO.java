package com.peyman.data;

import com.peyman.data.entities.Product;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


public interface ProductDAO {

    void save(Product product);

    List<Product> findAll();

    void delete(long productId);

    Product find(long productId);

    List<Product> getAllProductByCategory(int pageNumber, String productCategory);

    void update(Product product) throws SQLException;
}
