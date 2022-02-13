package com.peyman.controllers;

import com.peyman.data.entities.Product;
import com.peyman.exceptions.CustomError;
import com.peyman.models.ProductDTO;
import com.peyman.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/product")
public class ProductController  implements HandlerExceptionResolver {


    @Autowired
    private ProductService productService;

    @ResponseBody
    @GetMapping(value = "/getImage/{productId}", produces = "image/jpeg")
    public byte[] getProductImage(@PathVariable("productId") long productId) {
        Product product = productService.find(productId);
        return product.getImg();
    }

    @RequestMapping("/productList/{productCategory}/{pageNumber}")
    public String getProductByCategory(@PathVariable("pageNumber")int pageNumber,@PathVariable("productCategory")String productCategory,Model model){

        List<Product> products;
        if(productCategory.equalsIgnoreCase("all"))
            products = productService.findAll();
        else
            products = productService.getAllProductByCategory(pageNumber, productCategory);





        if (products.size()==0) {
            model.addAttribute("msg","No product to show");
        }

        model.addAttribute("products",products);
        model.addAttribute("productCategory",productCategory);
        model.addAttribute("totalPages",1);
        model.addAttribute("currentPageNumber",1);
        model.addAttribute("beginIndex",1);
        model.addAttribute("endIndex",1);


        return "productList";
    }







    @RequestMapping(value="/productList/{productCategory}/{pageNumber}",method=RequestMethod.POST)
    public String getProductBySearch(@RequestParam("searchTerm")String searchTerm,@PathVariable("pageNumber")int pageNumber,@PathVariable("productCategory")String productCategory,Model model){



        List<Product> products=productService.getAllProductByBrandOrModel(pageNumber, searchTerm, productCategory);


        if (products.size()==0) {
            model.addAttribute("msg","No product to show");
        }



        model.addAttribute("products",products);
        model.addAttribute("productCategory",productCategory);
        model.addAttribute("totalPages",1);
        model.addAttribute("currentPageNumber",1);
        model.addAttribute("beginIndex",1);
        model.addAttribute("endIndex",1);


        return "productList";
    }






    @RequestMapping("/productList")
    public String getAllProduct(Model model){

        List<Product> products=productService.findAll();
        model.addAttribute("products",products);



        return "productList";
    }


    @RequestMapping("/viewProduct/{productId}")
    public String ProductDetailPage(@PathVariable("productId")long productId, Model model){

        Product product=productService.find(productId);


        model.addAttribute("product",product);
        model.addAttribute("search","search");
        return "productDetail";
    }



    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        ModelAndView modelAndView=new ModelAndView();
        CustomError error=new CustomError();


        error.setMessage("Your request is not valid.Please Enter a valid request.");
        modelAndView.addObject("customError", error);
        modelAndView.setViewName("error_page");

        return modelAndView;
    }
}
