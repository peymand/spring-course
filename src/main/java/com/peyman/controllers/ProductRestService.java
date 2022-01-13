package com.peyman.controllers;

import com.peyman.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/rest")
public class ProductRestService {

    @Autowired
    Logger logger;

    @GetMapping(value = "/get/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO get(@PathVariable("id") int id){
        logger.debug(id);
        ProductDTO dto = new ProductDTO(1,"Glass", 1000, "Home");
        return dto;
    }


}
