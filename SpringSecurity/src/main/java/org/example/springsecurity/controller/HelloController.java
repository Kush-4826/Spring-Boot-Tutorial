package org.example.springsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> hello(HttpServletRequest request){
        return ResponseEntity.ok().body(Map.of("message", "Hello World: " + request.getSession().getId()));
    }

    @GetMapping("/about")
    public ResponseEntity<Map<String, String>> about(){
        return ResponseEntity.ok().body(Map.of("message", "Hello World"));
    }
}
