package com.peyman.services;

import com.peyman.models.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    void save(ProductDTO dto);

    List<ProductDTO> findAll();

    void delete(ProductDTO.DELETE dto);
}
