package com.peyman.services;

import com.peyman.data.ProductDAO;
import com.peyman.data.entities.Product;
import com.peyman.models.ProductDTO;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@Log4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ModelMapper mapper;

    @Override
    public void save(Product product) {
//        Product product = mapper.map(dto, Product.class);
        productDAO.save(product);
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productDAO.findAll();

        List<ProductDTO> productDTOList = products.stream()
                .map(product -> mapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
//        mapper.map(products, productDTOList);
        return productDTOList;
    }

    @Override
    public void delete(ProductDTO.DELETE dto) {
        log.info("");
        productDAO.delete(dto.getId());
    }
}
