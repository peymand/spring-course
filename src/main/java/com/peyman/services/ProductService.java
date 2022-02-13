package com.peyman.services;

import com.peyman.data.entities.Product;
import com.peyman.models.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    void save(Product dto);

    List<Product> findAll();

    void delete(long dto);

    Product find(long productId);

    List<Product> getAllProductsByBrandOrModelOrCategory(String searchTerm);

    List<Product> getAllProductByCategory(int pageNumber, String productCategory);

    List<Product> getAllProductByBrandOrModel(int pageNumber, String searchTerm, String productCategory);

    List<Product> getAllProductByBrandOrModelOrCategory(Integer pageNumber, String searchTerm);
}
