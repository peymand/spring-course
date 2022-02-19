package com.peyman.data;

import com.peyman.data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product , Long> {


    //Method Query

    List<Product> findAllProductByProductCategory(String productCategory);

    List<Product> findAllByProductNameAndProductBrand(String name, String brand);

    @Query("SELECT p from Product p WHERE p.productBrand like %:searchTerm% OR p.productModel like %:searchTerm% AND p.productCategory = :category")
    List<Product> findAllProductByBrandOrModel(@Param("searchTerm") String brand , @Param("category")String category);

}
