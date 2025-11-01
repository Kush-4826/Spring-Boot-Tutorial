package org.example.oauthdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetController {

    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> greet() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello World");
        return ResponseEntity.ok(map);
    }
}
