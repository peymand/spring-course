package com.peyman.controllers;

import com.peyman.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    @Autowired
    Logger logger;

    @Autowired
    MessageSource messageSource;

//    Logger logger = Logger.getLogger(ProductController.class);

    @GetMapping("/show")
    public String show(@ModelAttribute("dto") ProductDTO productDTO){
        return "product-show";
    }
    @PostMapping(value = "/save")
    public String save(HttpServletRequest r, @ModelAttribute("dto") @Valid ProductDTO productDTO, BindingResult result, Locale locale){
//
//        messageSource.getMessage( "error.name" , new Locale(locale.getLanguage()));


        if(result.hasErrors()){
            return "product-show";
        }
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
