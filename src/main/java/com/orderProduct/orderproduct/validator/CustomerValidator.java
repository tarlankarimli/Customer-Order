package com.orderProduct.orderproduct.validator;

import com.orderProduct.orderproduct.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {

       @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer=(Customer) o;
      if(customer.getName().length()==0){
          errors.rejectValue("name","customer.name.length");
      }
       if(customer.getPhoneNumber().length()!=13){
            errors.rejectValue("phoneNumber","customer.phoneNumber.invalid");
        }
       if(!(customer.getEmail().contains("@") && customer.getEmail().contains("."))){
            errors.rejectValue("email","customer.email.invalid");
        }
      if(customer.getPassword().length()<5 && testAllUpperCase(customer.getPassword())==false){
            errors.rejectValue("password","customer.password.invalid");
        }

    }
    public static boolean testAllUpperCase(String str){
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c >= 97 && c <= 122) {
                return false;
            }
        }
        //str.charAt(index)
        return true;
    }

}
