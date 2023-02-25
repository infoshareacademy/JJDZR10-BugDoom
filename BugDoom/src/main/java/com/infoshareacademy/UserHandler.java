package com.infoshareacademy;

import com.infoshareacademy.model.User;
import com.infoshareacademy.service.DataHandler;

import java.util.Arrays;
import java.util.Scanner;


public class UserHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static User getNewUserDetails() {
        System.out.println("Wprowadź imię: ");
        String name = scanner.nextLine();
        System.out.println("Wprowadź hasło: ");
        String password = scanner.nextLine();
        User user = new User(name, password);
        UserHandler.appendToFile("users.json", user);
        return user;
    }

    public static void appendToFile(String filename, User user) {
        DataHandler dataHandler = new DataHandler();
        User[] users = dataHandler.readUsers();
        User[] updatedUsers = Arrays.copyOf(users, users.length + 1);
        updatedUsers[updatedUsers.length - 1] = user;
        dataHandler.writeUsers(updatedUsers);

    }


    public static boolean logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź imię: ");
        String name = scanner.nextLine();
        System.out.println("Wprowadź hasło: ");
        String password = scanner.nextLine();
        DataHandler dataHandler = new DataHandler();
        User[] users = dataHandler.readUsers();
        for (User user : users) {
            if (user.getName() != null && !user.getName().isEmpty() && user.getName().equals(name) && user.getPassword().equals(password)) {
                System.out.println("Login pomyślny.");
                return true;
            }
        }
        System.out.println("Nie prawidłowe imie albo hasło.");
        return false;
    }

    public static void appendToFile(String filename, String toString) {

    }
}
