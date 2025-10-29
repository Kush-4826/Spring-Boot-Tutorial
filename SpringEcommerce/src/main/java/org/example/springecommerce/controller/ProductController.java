package org.example.springecommerce.controller;

import org.example.springecommerce.model.Product;
import org.example.springecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @GetMapping("products/{id}")
    public ResponseEntity<Object> show(@PathVariable String id) {
        Product p = this.productService.getProductById(id);

        if (p == null)
            return new ResponseEntity<>(Map.of("error", "Product Not Found"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<?> store(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product savedProduct = null;
        try {
            savedProduct = this.productService.storeProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(Map.of("error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
