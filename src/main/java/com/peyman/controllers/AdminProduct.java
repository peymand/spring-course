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
import java.sql.SQLException;

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

    @ResponseBody
    @GetMapping(value = "/product/getImage/{productId}", produces = "image/jpeg")
    public byte[] getProductImage(@PathVariable("productId") long productId) {
        Product product = productService.find(productId);
        return product.getImg();
    }

    @RequestMapping("/product/updateProduct/{productId}")
    public String updateProduct(@PathVariable("productId") long productId,Model model){

        Product product = productService.find(productId);
        model.addAttribute(product);

        return "updateProduct";


    }

    @RequestMapping(value="/product/updateProduct" , method = RequestMethod.POST)
    public String updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) throws IOException{
        if (result.hasErrors()) {
            return "updateProduct";
        }

        byte[] imgByte = product.getProductImage().getBytes();
        if (imgByte.length == 0 ){
            product.setImg(this.getProductImage(product.getProductId()));
        }else {
            product.setImg(imgByte);
        }


        try {
            productService.update(product);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "redirect:/admin/productManagement/1";
    }

}
