package com.orderProduct.orderproduct.service;

import com.orderProduct.orderproduct.model.Customer;
import com.orderProduct.orderproduct.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer customerSignup(Customer customer) {
        return customerRepository.save(customer);
    }
    public boolean customerAccountCheck(Customer customer) {
        Customer cust = customerRepository.findUserByEmailAndPassword(customer.getEmail(),customer.getPassword());
        if(cust.getEmail()==null && cust.getPassword()==null) {
            return false;
        }
        return true;
    }
}
