package com.orderProduct.orderproduct.controller;

import com.orderProduct.orderproduct.model.Customer;
import com.orderProduct.orderproduct.repository.CustomerRepository;
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

    public CustomerController(CustomerValidator customerValidator, CustomerRepository customerRepository) {
        this.customerValidator = customerValidator;
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = {"/", "/signup" }, method = RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/sign-up";
    }

    @RequestMapping(value = {"/customer/save"}, method = RequestMethod.POST)
    public String customerSave(Model model, @ModelAttribute Customer customer, BindingResult bindingResult) {
        System.out.println("before: "+ customer);
        customerValidator.validate(customer, bindingResult);
        System.out.println("after: "+customer);
        System.out.println("bin erorru: "+bindingResult);
        if(bindingResult.hasErrors()) {
            return "customer/sign-up";
        }
        return "product/product-list";
    }
}
