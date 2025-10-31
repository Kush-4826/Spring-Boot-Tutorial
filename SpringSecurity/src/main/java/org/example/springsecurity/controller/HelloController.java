package org.example.springsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> hello(){
        return ResponseEntity.ok().body(Map.of("message", "Hello World"));
    }

    @GetMapping("/about")
    public ResponseEntity<Map<String, String>> about(){
        return ResponseEntity.ok().body(Map.of("message", "Hello World"));
    }
}
