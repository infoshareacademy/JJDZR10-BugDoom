package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.exception.UserNotFoundException;
import com.infoshareacademy.pl.model.User;
import com.infoshareacademy.pl.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with given id: '%s' not found".formatted(userId)));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
