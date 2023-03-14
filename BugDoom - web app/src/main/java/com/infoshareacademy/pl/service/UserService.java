package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.model.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    private static final String USERS_FILE_PATH = FilePathConstants.USERS_FILE_PATH;
    private static final DataService <User> dataService = new DataService();

    public static void addNewUser(User user) throws IOException {
        List<User> users = new ArrayList<>(dataService.readFromFile(USERS_FILE_PATH, User[].class));
        users.add(user);
        dataService.saveToFile(users, USERS_FILE_PATH);
    }
    public static boolean loginValidation (String username, String userPassword) throws IOException {
        List<User> users = dataService.readFromFile(USERS_FILE_PATH, User[].class);
        Optional<String> optionalUsername = users.stream()
                .map(User::getName)
                .filter(name -> name.equals(username))
                .findFirst();
        Optional<String> optionalPassword = users.stream()
                .map(User::getPassword)
                .filter(password -> password.equals(userPassword))
                .findFirst();
        return optionalUsername.isPresent() && optionalPassword.isPresent();
    }
}
