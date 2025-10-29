package org.example.springecommerce.controller;

import org.example.springecommerce.model.Product;
import org.example.springecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController extends ApiController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> index() {
        return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
    }
}
