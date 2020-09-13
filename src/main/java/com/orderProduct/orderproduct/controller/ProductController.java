package com.orderProduct.orderproduct.controller;

import com.orderProduct.orderproduct.model.Product;
import com.orderProduct.orderproduct.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = {"/product/list"}, method = RequestMethod.GET)
    public String productList(Model model) {
        model.addAttribute("productList", productService.getProductList());
        return "product/product-list";
    }

    @RequestMapping(value = {"/product/new"}, method = RequestMethod.GET)
        public String productNew(Model model) {
            model.addAttribute("product", new Product());
            model.addAttribute("action", "update");
            return "product/product-form";
        }

    @RequestMapping(value = {"/product/update"}, method = RequestMethod.POST)
    public String productNew(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/product/list";
    }
}
