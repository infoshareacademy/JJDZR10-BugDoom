package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.model.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    private static final String USERS_FILE_PATH = FilePathConstants.USERS_FILE_PATH;
    private static final DataService <User> dataService = new DataService<>();
    private static User currentUser;

    public static void addNewUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        dataService.saveToFile(users, USERS_FILE_PATH);
    }

    public static void deleteUser (User userToDelete) throws IOException{
        List<User> users = getAllUsers();
        users.remove(userToDelete);
        dataService.saveToFile(users, USERS_FILE_PATH);
    }

    public static boolean loginValidation (String emailAddress, String password) throws IOException {
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

    public static User getCurrentUser() {
        return currentUser;
    }

    private static List<User> getAllUsers() throws IOException{
        return new ArrayList<>(dataService.readFromFile(USERS_FILE_PATH, User[].class));
    }
}
