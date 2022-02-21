package com.peyman.controllers;


import com.peyman.data.entities.*;
import com.peyman.exceptions.CustomError;
import com.peyman.services.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController implements HandlerExceptionResolver{

    @Autowired
    private ProductService productService;


    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerContactService customerContactService;

    @RequestMapping
    public String adminPage(){

        return "admin";
    }



    @RequestMapping("/productManagement/{pageNumber}")
    public String productManagement(@PathVariable Integer pageNumber,Model model){


        Page<Product> page=productService.getAllProduct(pageNumber);

        int currentPageNumber=page.getNumber()+1;
        int beginIndex=Math.max(1, currentPageNumber-6);
        int endIndex=Math.min(beginIndex+10, page.getTotalPages());



        List<Product> products=new ArrayList<>();



        for (Product product : page) {
            products.add(product);
        }

        model.addAttribute("products",products);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("currentPageNumber",currentPageNumber);
        model.addAttribute("beginIndex",beginIndex);
        model.addAttribute("endIndex",endIndex);

        return "productInventory";
    }



//
    @RequestMapping(value="/productManagement/search/{pageNumber}",method=RequestMethod.POST)
    public String productSearch(@RequestParam("searchTerm")String searchTerm,@PathVariable Integer pageNumber,Model model){


//        Page<Product> page=productService.getAllProductByBrandOrModelOrCategory(pageNumber, searchTerm);
          List<Product> products=productService.getAllProductByBrandOrModelOrCategory (searchTerm);

//        int currentPageNumber=page.getNumber()+1;
//        int beginIndex=Math.max(1, currentPageNumber-6);
//        int endIndex=Math.min(beginIndex+10, page.getTotalPages());
//
//
//
//        List<Product> products=new ArrayList<>();
//
//
//
//        for (Product product : page) {
//            products.add(product);
//        }

//        model.addAttribute("products",products);
//        model.addAttribute("totalPages",page.getTotalPages());
//        model.addAttribute("currentPageNumber",currentPageNumber);
//        model.addAttribute("beginIndex",beginIndex);
//        model.addAttribute("endIndex",endIndex);

        model.addAttribute("products",products);
        model.addAttribute("totalPages",1);
        model.addAttribute("currentPageNumber",1);
        model.addAttribute("beginIndex",1);
        model.addAttribute("endIndex",1);

        model.addAttribute("search","search");
        return "productInventory";
    }



    @RequestMapping("/customerManagement")
    public String customerManagement(Model model){


        List<Customer> customers=customerService.getAllCustomers();
        model.addAttribute("customers",customers);

        return "customerManagement";
    }


    @RequestMapping("/customerManagement/address/{customerId}")
    public String customerShippingBillingAddress(@PathVariable("customerId")long customerId,Model model){


        Customer customer=customerService.getCustomerBycustomerId(customerId);

        model.addAttribute("customer",customer);

        return "customerAddressDetail";
    }



    @RequestMapping("/customerOrder")
    public String customerOrder(Model model){


        List<CustomerOrder> customerOrders=customerOrderService.getAllCustomerOrder();
        model.addAttribute("orders",customerOrders);
        return "orderList";
    }



    @RequestMapping("/customerOrder/deletOrder/{customerOrderId}")
    public String deleteCustomerOrder(@PathVariable("customerOrderId")long customerOrderId,Model model){


        CustomerOrder customerOrder=customerOrderService.getCustomerOrderById(customerOrderId);

        Cart cart=customerOrder.getCart();
        cartItemService.removeAllCartItems(cart);
        customerOrderService.deleteCustomerOrderById(customerOrderId);

        return "redirect:/admin/customerOrder";
    }



    @RequestMapping("/customerOrder/productList/{customerOrderId}")
    public String getCustomerOrderProduct(@PathVariable("customerOrderId")long customerOrderId,Model model){


        CustomerOrder customerOrder=customerOrderService.getCustomerOrderById(customerOrderId);


        //List<CartItem> cartItems=customerOrder.getCart().getCartItems();


        model.addAttribute("order",customerOrder);

        return "orderDetails";
    }




    @RequestMapping("/customerMessages/{pageNumber}")
    public String customerMessage(@PathVariable Integer pageNumber,Model model){






        Page<CustomerContact> page=customerContactService.getAllCustomerMessage(pageNumber);

        int currentPageNumber=page.getNumber()+1;
        int beginIndex=Math.max(1, currentPageNumber-5);
        int endIndex=Math.min(beginIndex+10, page.getTotalPages());



        List<CustomerContact> customerContacts=new ArrayList<>();



        for (CustomerContact contact : page) {
            customerContacts.add(contact);
        }


        if (customerContacts.size()==0) {
            model.addAttribute("msg","No Customer Message To show");
        }

        model.addAttribute("customerContacts",customerContacts);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("currentPageNumber",currentPageNumber);
        model.addAttribute("beginIndex",beginIndex);
        model.addAttribute("endIndex",endIndex);


        return "customerMessage";
    }


    @RequestMapping("/customerMessages/deleteMessage")
    public String customerMessageDelete(@RequestParam("customerMessageId")int customerMessageId,@RequestParam("currentPageNumber")int currentPageNumber){




        customerContactService.deleteMessageById(customerMessageId);




        return "redirect:/admin/customerMessages/"+currentPageNumber;
    }


    @Override
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
