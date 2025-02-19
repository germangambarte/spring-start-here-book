package com.example.application.controller;

import com.example.application.model.Product;
import com.example.application.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

//    @PostMapping("/products")
//    public String createProduct(
//            @RequestParam String name,
//            @RequestParam double price,
//            Model model
//    ) {
//        Product newProduct = new Product();
//        newProduct.setName(name);
//        newProduct.setPrice(price);
//        productService.addProduct(newProduct);
//
//        var products = productService.findAll();
//        model.addAttribute("products", products);
//        return "products.html";
//    }

    @PostMapping("/products")
    public String createProduct(
            Product newProduct,
            Model model
    ) {
        productService.addProduct(newProduct);

        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }
}
