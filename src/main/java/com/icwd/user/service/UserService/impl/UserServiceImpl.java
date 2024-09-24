package com.icwd.user.service.UserService.impl;

import com.icwd.user.service.UserService.entities.User;
import com.icwd.user.service.UserService.exceptions.ResourceNotFoundException;
import com.icwd.user.service.UserService.repositories.UserRepository;
import com.icwd.user.service.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server -> " + userId));
    }
}
