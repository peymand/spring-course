package com.peyman.controllers;


import com.peyman.data.entities.Product;
import com.peyman.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    ProductService productService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/productManagement/{pageNumber}")
    public ModelAndView productManagement(@PathVariable Integer pageNumber, ModelAndView modelAndView) {
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("productInventory");
        return modelAndView;

    }

    @RequestMapping("/productManagement/search/{pageNumber}")
    public ModelAndView productManagement(@PathVariable Integer pageNumber,
                                          ModelAndView modelAndView , @RequestParam("searchTerm") String searchTerm) {
        List<Product> products = productService.getAllProductsByBrandOrModelOrCategory(searchTerm);
        //TODO : fix the getall method
        modelAndView.addObject("products", products);
        modelAndView.setViewName("productInventory");
        return modelAndView;

    }
}