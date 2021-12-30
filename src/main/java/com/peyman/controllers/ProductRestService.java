package com.peyman.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peyman.entities.Product;
import com.peyman.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product/rest")
public class ProductRestService {

    Logger logger = Logger.getLogger(ProductRestService.class);

    List<ProductDTO> list = new ArrayList<ProductDTO>()
    {
        {
            add(new ProductDTO(102,"glass",1000));
            add(new ProductDTO(21,"mobile",2000));
        }
    };


    @GetMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ProductDTO detailWithPathParam(@PathVariable("id") int id) throws JsonProcessingException {
        logger.debug(id);
        //TODO: get the product and add it to model and the dispatch it to the view

        return list.get(0);
    }
}
