package com.peyman.controllers;

import com.peyman.data.entities.Product;
import com.peyman.models.ProductDTO;
import com.peyman.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/product")
@Log4j
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @GetMapping("/show")
    public String show(@ModelAttribute("dto") ProductDTO.CREATE productDTO){
        return "product-show";
    }
    @PostMapping(value = "/save")
    public String save(HttpServletRequest r, @ModelAttribute("dto") @Valid ProductDTO productDTO, BindingResult result, Locale locale){


        if(result.hasErrors()){
            return "product-show";
        }

        productService.save(productDTO);

        return "redirect:/";
    }
    @GetMapping(value = "/get-all")
    public ModelAndView getAll(ModelAndView modelAndView){
        modelAndView.setViewName("product-list");
        List<ProductDTO> productDTOList =  productService.findAll();
        modelAndView.addObject("list", productDTOList);
        return modelAndView;
    }

    @GetMapping("/detail")
    public String detailWithQueryString(@RequestParam("id") int dummy){
        log.debug(dummy);
        return "product-detail";
    }


    @GetMapping("/detail/{id}")
    public String detailWithPathParam(@PathVariable("id") int id){
        log.debug(id);
        //TODO: get the product and add it to model and the dispatch it to the view
        return "product-detail";
    }
    @GetMapping("/delete")
    public String delete(ProductDTO.DELETE dto){
        productService.delete(dto);
        return "redirect:/product/get-all";
    }

}
