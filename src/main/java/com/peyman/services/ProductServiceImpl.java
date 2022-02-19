package com.peyman.services;

import com.peyman.data.ProductDao;
import com.peyman.data.entities.Product;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service
@Log4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDAO;

    @Autowired
    ModelMapper mapper;
    @Transactional
    @Override
    public void save(Product product) {
//        Product product = mapper.map(dto, Product.class);
        productDAO.save(product);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {

        List<Product> products = productDAO.findAll();
        return products;
    }
    @Transactional
    @Override
    public void delete(long productId) {
        log.info("");
        productDAO.deleteById(productId);
    }
    @Transactional
    @Override
    public Product find(long productId){
        Product p = productDAO.findById(productId).get();
        return p;
    }
    @Transactional
    @Override
    public List<Product> getAllProductsByBrandOrModelOrCategory(String searchTerm) {
        return null;
    }
    @Transactional
    @Override
    public List<Product> getAllProductByCategory(int pageNumber, String productCategory) {
        return productDAO.findAllProductByProductCategory(productCategory);
    }
    @Transactional
    @Override
    public List<Product> getAllProductByBrandOrModel(int pageNumber, String searchTerm, String productCategory) {
        return productDAO.findAllProductByBrandOrModel(searchTerm , productCategory);
    }
    @Transactional
    @Override
    public List<Product> getAllProductByBrandOrModelOrCategory(Integer pageNumber, String searchTerm) {
        return null;
    }
    @Transactional
    @Override
    public void update(Product product) throws SQLException {
        productDAO.save(product);
    }
}
