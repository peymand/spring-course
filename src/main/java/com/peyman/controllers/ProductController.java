package com.peyman.controllers;

import com.peyman.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/product")
public class ProductController {

    Logger logger = Logger.getLogger(ProductController.class);

    @GetMapping("/show")
    public String show(){
        return "product-show";
    }
    @PostMapping(value = "/save")
    public String save(ProductDTO productDTO){

        logger.debug(productDTO);
        //
        return "redirect:/";
    }

}
