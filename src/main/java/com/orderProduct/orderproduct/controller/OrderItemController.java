package com.orderProduct.orderproduct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderItemController {

    @RequestMapping(value = {"/order/items"}, method = RequestMethod.POST)
    public String orderItems(@RequestParam("products") String pro) {
        System.out.println(pro);
        return "redirect: product/product/list";
    }
}
