package com.codegym.controllers;

import com.codegym.com.codegym.service.CustomerService;
import com.codegym.com.codegym.service.CustomerServiceIplm;
import com.codegym.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller

public class CustomerController {
    private CustomerService customerService = new CustomerServiceIplm();
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("customers",customerService.findAll());
        return "index";
    }


    @GetMapping("customer/view/details")
    public String viewCustomer(@RequestParam Integer customerId, Model model){
        Customer customer = customerService.findById(customerId);
        model.addAttribute(customer);
        return "view";
    }

    @GetMapping("customer/create")
    public String showCreateForm(){
        return "create";

    }

    @PostMapping("customer/create")
    public ModelAndView createNewCustomer(@ModelAttribute Customer customer){
        ModelAndView modelAndView = new ModelAndView("success");
        customerService.update(getRandom(),customer);
        return modelAndView;

    }

    private int getRandom(){
        Random random=new Random();
        return random.nextInt(100000);
    }


}
