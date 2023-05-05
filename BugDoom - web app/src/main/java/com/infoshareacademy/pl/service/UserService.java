package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.model.User;
import com.infoshareacademy.pl.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements UserRepository {
    private final String USERS_FILE_PATH = FilePathConstants.USERS_FILE_PATH;
    private final DataService<User> dataService;
    private User currentUser;

    public UserService(DataService<User> dataService) {
        this.dataService = dataService;
    }

    public void addNewUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        dataService.saveToFile(users, USERS_FILE_PATH);
    }

    public void deleteUser(User userToDelete) throws IOException {
        List<User> users = getAllUsers();
        users.remove(userToDelete);
        dataService.saveToFile(users, USERS_FILE_PATH);
    }

    public User findUserById(long id) throws NoSuchElementException, IOException {
        List<User> users = getAllUsers();
        return users.stream()
                .filter(user -> user.getUserId() == id)
                .findFirst()
                .orElseThrow();
    }

    public boolean loginValidation(String emailAddress, String password) throws IOException {
        List<User> users = dataService.readFromFile(USERS_FILE_PATH, User[].class);
        for (User user : users) {
            if (user.getUserEmailAddress() != null
                    && !user.getUserEmailAddress().isEmpty()
                    && user.getUserEmailAddress().equals(emailAddress)
                    && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public List<User> getAllUsers() throws IOException {
        return new ArrayList<>(dataService.readFromFile(USERS_FILE_PATH, User[].class));
    }
}
