package com.orderProduct.orderproduct.controller;

import com.orderProduct.orderproduct.model.Product;
import com.orderProduct.orderproduct.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//Product List
    @RequestMapping(value = {"/product/list"}, method = RequestMethod.GET)
    public String productList(Model model) {
        model.addAttribute("productList", productService.getProductList());
        return "product/product-list";
    }
//Product form
    @RequestMapping(value = {"/product/new"}, method = RequestMethod.GET)
        public String productNew(Model model) {
            model.addAttribute("product", new Product());
            model.addAttribute("idView", "readonly disabled");
            return "product/product-form";
        }
// Add new product
    @RequestMapping(value = {"/product/save"}, method = RequestMethod.POST)
    public String productNew(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/product/list";
    }
//Update product list
    @RequestMapping(value = {"/product/update/list"}, method = RequestMethod.GET)
    public String productUpdateList(Model model) {
        model.addAttribute("productList", productService.getProductList());
        return "product/product-update-list";
    }
//Update product
    @RequestMapping("/product/update")
    public String productUpdate(@RequestParam("id") Long id, Model model) {
        model.addAttribute("product", productService.getOneProduct(id));
        model.addAttribute("idView","readonly");
        return "product/product-form";
    }
    @RequestMapping("/product/delete")
    public String productDelete(@RequestParam("id") Long id, Model model) {
        productService.deleteProduct(id);
        model.addAttribute("productList", productService.getProductList());
        return "product/product-update-list";
    }
}
