package com.peyman.data;

import com.peyman.data.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductDao extends JpaRepository<Product, Long> {

	List<Product> findAllProductsByproductCategory(String productCategory);
	
	Page<Product> findAllProductByproductCategory(String productCategory, Pageable pageable);


	@Query("SELECT t FROM Product t WHERE t.productCategory = :category AND t.productModel LIKE %:searchTerm%  OR  t.productCategory = :category AND t.productBrand LIKE %:searchTerm%")
    Page<Product> findAllProductByBrandOrModel(@Param("searchTerm") String searchTerm, @Param("category") String category, Pageable pageable);


	@Query("SELECT t FROM Product t WHERE t.productCategory = :searchTerm OR t.productModel LIKE %:searchTerm%  OR   t.productBrand LIKE %:searchTerm%")
    Page<Product> findAllProductByBrandOrModelorCategory(@Param("searchTerm") String searchTerm, Pageable pageable);
}
