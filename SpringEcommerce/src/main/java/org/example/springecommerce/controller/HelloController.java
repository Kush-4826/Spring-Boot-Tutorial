package org.example.springecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("")
    public ResponseEntity<Map<String, String>> hello() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new HashMap<String, String>(Map.of("message", "Hello World!")));
    }

}
