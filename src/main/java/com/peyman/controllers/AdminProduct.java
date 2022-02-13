package com.peyman.controllers;

import com.peyman.data.entities.Product;
import com.peyman.models.ProductDTO;
import com.peyman.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin")
public class AdminProduct {

    @Autowired
    ProductService productService;

    @GetMapping("/product/addProduct")
    public String showProductPage(@ModelAttribute("product") Product product) {

        product.setProductStatus("Brand New");
        return "addProduct";
    }

    @PostMapping("/product/addProduct")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) throws IOException {

        if (result.hasErrors()) {
            return "addProduct";
        }
        byte[] imgByte = product.getProductImage().getBytes();
        product.setImg(imgByte);
        productService.save(product);
        return "redirect:/admin/productManagement/1";
    }



    @RequestMapping("/product/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable("productId") long productId){

        productService.delete(productId);


        return "redirect:/admin/productManagement/1";


    }

}
