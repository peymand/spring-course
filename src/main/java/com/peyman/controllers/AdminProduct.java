package com.peyman.controllers;

import com.peyman.data.entities.Product;
import com.peyman.exceptions.CustomError;
import com.peyman.exceptions.DatabaseForeignKeyException;
import com.peyman.services.ProductService;
import com.peyman.validators.ProductFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin")
public class AdminProduct implements HandlerExceptionResolver {

    private Path path;
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductFormValidator productFormValidator;

    @RequestMapping("/product/addProduct")
    public String addProduct(Model model){



        Product product=new Product();
        product.setProductStatus("Brand New");
        model.addAttribute("product",product);
        model.addAttribute("categoryList",product.getCategoryList());
        return "addProduct";
    }


    @RequestMapping(value="/product/addProduct",method= RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product")Product product, BindingResult result, Model model, HttpServletRequest request){

        try {
            if (result.hasErrors()) {
                model.addAttribute("categoryList",product.getCategoryList());
                return "addProduct";
            }




            byte[] imgByte = product.getProductImage().getBytes();
            product.setImg(imgByte);



            productService.addProduct(product);

            MultipartFile productImage=product.getProductImage();
            String rootDir=request.getSession().getServletContext().getRealPath("/");
            path= Paths.get(rootDir+"\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");

            if (productImage!=null && !productImage.isEmpty()) {
                try {
                    productImage.transferTo(new File(path.toString()));

                    //System.out.println("IMage Save at:"+path.toString());
                } catch (Exception e) {

                    e.printStackTrace();
                    throw new RuntimeException("Product image saving failed",e);
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }







        return "redirect:/admin/productManagement/1";
    }


    @RequestMapping("/product/updateProduct/{productId}")
    public String updateProduct(@PathVariable("productId")long productId, Model model){

        Product product=productService.getProductById(productId);

        model.addAttribute("product",product);
        model.addAttribute("categoryList",product.getCategoryList());
        return "updateProduct";


    }




    @RequestMapping(value="/product/updateProduct",method=RequestMethod.POST)
    public String updateProductPost(@ModelAttribute("product")Product product,BindingResult result,HttpServletRequest request) throws IOException {

        if (result.hasErrors()) {

            return "addProduct";
        }







        byte[] imgByte = product.getProductImage().getBytes();
        product.setImg(imgByte);


        MultipartFile productImage=product.getProductImage();
        String rootDir=request.getSession().getServletContext().getRealPath("/");
        path=Paths.get(rootDir+"\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");


        if (productImage!=null && !productImage.isEmpty()) {

            //System.out.println("OKKKK--------------------");
            try {


                productImage.transferTo(new File(path.toString()));

                //System.out.println("IMage Save at:"+path.toString());
            } catch (Exception e) {

                e.printStackTrace();
                throw new RuntimeException("Product image saving failed",e);
            }
        }




        productService.addProduct(product);


        return "redirect:/admin/productManagement/1";
    }


    @RequestMapping("/product/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable("productId")long productId,Model model,HttpServletRequest request) throws Exception{

        try {
            String rootDir=request.getSession().getServletContext().getRealPath("/");
            path=Paths.get(rootDir+"\\WEB-INF\\resources\\images\\"+productId+".png");

            if (Files.exists(path)) {

                try {
                    Files.delete(path);
                } catch (IOException e) {

                    e.printStackTrace();


                }
            }




            productService.deleteProduct(productId);
        } catch (Exception e) {

            System.out.println("------------------------------------------------------------------");
            throw new DatabaseForeignKeyException();
        }

        return "redirect:/admin/productManagement/1";


    }





    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        ModelAndView modelAndView=new ModelAndView();
        CustomError error=new CustomError();
        if (ex instanceof DatabaseForeignKeyException) {



            error.setMessage("You can not delete a product until you clear customer order.In customer order this product exist.");
            modelAndView.addObject("customError", error);
            modelAndView.setViewName("error_page");
            return modelAndView;
        }



        error.setMessage("Your request is not valid.Please Enter a valid request.");
        modelAndView.addObject("customError", error);
        modelAndView.setViewName("error_page");

        return modelAndView;
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(productFormValidator);
    }
}
