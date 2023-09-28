package com.infoshareacademy.service;

import com.infoshareacademy.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String USERS_FILE_PATH = FilePathConstants.USERS_FILE_PATH;
    private static User currentUser;

    public static void getNewUserDetails() throws IOException {
        System.out.println("Wprowadź imię: ");
        String name = scanner.nextLine();
        System.out.println("Wprowadź hasło: ");
        String password = scanner.nextLine();
        User user = new User(name, password);
        appendToFile(user);
    }

    public static void appendToFile(User user) throws IOException {
        DataService<User> dataService = new DataService<>();
        List<User> users = new ArrayList<>(dataService.readFromFile(USERS_FILE_PATH, User[].class));
        if (users.isEmpty()) {
            users.add(new User("default", "password"));
        }
        users.add(user);
        dataService.saveToFile(users, USERS_FILE_PATH);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean logIn() throws IOException {
        System.out.println("Wprowadź imię: ");
        String name = scanner.nextLine();
        System.out.println("Wprowadź hasło: ");
        String password = scanner.nextLine();
        return loginDetailsAreCorrect(name, password);
    }
    private static boolean loginDetailsAreCorrect (String name, String password) throws IOException {
        DataService<User> dataService = new DataService<>();
        List<User> users = dataService.readFromFile(USERS_FILE_PATH, User[].class);
        for (User user : users) {
            if (user.getName() != null && !user.getName().isEmpty() && user.getName().equals(name) && user.getPassword().equals(password)) {
                System.out.println("Login i hasło poprawne");
                currentUser = user;
                return true;
            }
        }
        System.out.println("Nieprawidłowe imię lub hasło.");
        return false;
    }
}
