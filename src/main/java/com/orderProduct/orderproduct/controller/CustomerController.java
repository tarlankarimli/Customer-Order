package com.orderProduct.orderproduct.controller;

import com.orderProduct.orderproduct.model.Customer;
import com.orderProduct.orderproduct.repository.CustomerRepository;
import com.orderProduct.orderproduct.service.CustomerService;
import com.orderProduct.orderproduct.validator.CustomerValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    CustomerValidator customerValidator;
    CustomerRepository customerRepository;
    CustomerService customerService;

    public CustomerController(CustomerValidator customerValidator, CustomerRepository customerRepository, CustomerService customerService) {
        this.customerValidator = customerValidator;
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @RequestMapping(value = {"/signup" }, method = RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/sign-up";
    }
    @RequestMapping(value = {"/signin" }, method = RequestMethod.GET)
    public String signin(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/sign-in";
    }

    @RequestMapping(value = {"/customer/save"}, method = RequestMethod.POST)
    public String customerSave(Model model, @ModelAttribute Customer customer, BindingResult bindingResult) {
        customerValidator.validate(customer, bindingResult);
    customerService.customerSignup(customer);
    return "redirect:/signin";
    }

    @RequestMapping(value = {"/customer"}, method = RequestMethod.POST)
    public String customer(@ModelAttribute Customer customer) {
   if( customerService.customerAccountCheck(customer)) {
       return "redirect:/product/list";
   }
    return "redirect:/signin";
    }
}
