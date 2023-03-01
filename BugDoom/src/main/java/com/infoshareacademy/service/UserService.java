package com.infoshareacademy.service;

import com.infoshareacademy.model.User;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;


public class UserService {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String USERS_FILE_PATH = "User.json";
    private static final DataService<User> dataHandler;

    static {
        try {
            String usersFilePath = "User.json";
            dataHandler = new DataService<>(usersFilePath);
        } catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

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
        List<User> users = dataHandler.readFromFile(User[].class);
        if (users.isEmpty()) {
            users.add(new User("default", "password"));
        }
        users.add(user);
        dataHandler.saveToFile(users);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean logIn() throws IOException {
        System.out.println("Wprowadź imię: ");
        String name = scanner.nextLine();
        System.out.println("Wprowadź hasło: ");
        String password = scanner.nextLine();
        List<User> users = dataHandler.readFromFile(User[].class);
        for (User user : users) {
            if (user.getName() != null && !user.getName().isEmpty() && user.getName().equals(name) && user.getPassword().equals(password)) {
                System.out.println("Login pomyślny.");
                currentUser = user;
                return true;
            }
        }
        System.out.println("Nieprawidłowe imię lub hasło.");
        return false;
    }
}
