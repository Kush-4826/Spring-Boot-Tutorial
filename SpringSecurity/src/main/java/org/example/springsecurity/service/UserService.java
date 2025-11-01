package org.example.springsecurity.service;

import org.example.springsecurity.model.User;
import org.example.springsecurity.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return this.userRepository.save(user);

    }
}
