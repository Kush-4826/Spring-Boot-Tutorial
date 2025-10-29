package org.example.springecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController extends ApiController {
    @GetMapping("products")
    public String index() {
        return "Hello World";
    }
}
