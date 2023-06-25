package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.exception.UserNotFoundException;
import com.infoshareacademy.pl.model.User;
import com.infoshareacademy.pl.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(User user) {
        logger.info("Creating new user: {}", user);
        userRepository.save(user);
    }

    public void deleteUserById(Long userId) {
        logger.info("Removing user: {}");
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
