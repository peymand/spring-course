package com.peyman.controllers;

import com.peyman.entities.Product;
import com.peyman.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    List<ProductDTO> list = new ArrayList<ProductDTO>()
    {
        {
            add(new ProductDTO(102,"glass",1000, "home"));
            add(new ProductDTO(21,"mobile",2000 , "work"));
        }
    };

    Logger logger = Logger.getLogger(ProductController.class);

    @GetMapping("/show")
    public String show(@ModelAttribute("dto") ProductDTO productDTO){
        return "product-show";
    }
    @PostMapping(value = "/save")
    public String save(@ModelAttribute("dto") ProductDTO productDTO){
        SecureRandom random = new SecureRandom();
        productDTO.setId(random.nextInt(1000));
        list.add(productDTO);
        logger.debug(productDTO);
        //TODO: must persist dto into database

        return "redirect:/";
    }
    @GetMapping(value = "/get-all")
    public ModelAndView getAll(ModelAndView modelAndView){
        modelAndView.setViewName("product-list");
        modelAndView.getModelMap().addAttribute("list",list);
        return modelAndView;
    }

    @GetMapping("/detail")
    public String detailWithQueryString(@RequestParam("id") int dummy){
        logger.debug(dummy);
        return "product-detail";
    }


    @GetMapping("/detail/{id}")
    public String detailWithPathParam(@PathVariable("id") int id){
        logger.debug(id);
        //TODO: get the product and add it to model and the dispatch it to the view
        return "product-detail";
    }




}
