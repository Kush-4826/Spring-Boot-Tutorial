package org.example.springsecurity.controller;

import org.example.springsecurity.model.User;
import org.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("register")
    public User register(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

}
