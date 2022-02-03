package com.peyman.controllers;

import com.peyman.data.entities.Product;
import com.peyman.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminProduct {

    @Autowired
    ProductService productService;

    @GetMapping("/product/addProduct")
    public String showProductPage(@ModelAttribute("product")Product product){

        product.setProductStatus("Brand New");
        return "addProduct";
    }
    @PostMapping("/product/addProduct")
    public String addProduct(@Valid @ModelAttribute("product")Product product, BindingResult result) throws IOException {

        if(result.hasErrors()){
            return "addProduct";
        }
        byte[] imgByte = product.getProductImage().getBytes();
        product.setImg(imgByte);
        productService.save(product);
        return "redirect:/admin/productManagement/1";
    }

    @ResponseBody
    @GetMapping(value = "/product/getImage/{productId}" , produces="image/jpeg")
    public byte[] getProductImage(@PathVariable("productId") long productId){
        Product product =  productService.find(productId);
        return product.getImg();
    }

}
