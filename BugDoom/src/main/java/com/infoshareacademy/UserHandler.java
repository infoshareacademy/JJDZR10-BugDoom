package com.infoshareacademy;

import com.infoshareacademy.model.User;
import com.infoshareacademy.service.DataHandler;

import java.util.Arrays;
import java.util.Scanner;


public class UserHandler {
    private static final Scanner scanner = new Scanner(System.in);
    public static User[] getUsers() {
        DataHandler dataHandler = new DataHandler();
        return dataHandler.readUsers();
    }

    public static User getNewUserDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź imię: ");
        String name = scanner.nextLine();
        System.out.println("Wprowadź hasło: ");
        String password = scanner.nextLine();
        System.out.println("Wprowadź rolę (admin/user): ");
        String role = scanner.nextLine();
        User user = new User(name, password, role);
        appendToFile("users.json", user);
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
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                System.out.println("Login pomyślny.");
                if (user.getRole().equals("admin")) {
                    displayAdminMenu();
                } else {
                    displayUserMenu();
                }
                    return true;
            }
        }
        System.out.println("Nie prawidłowe imie albo hasło.");
        return false;
    }

    public static void appendToFile(String filename, String toString) {
    }
    private static void displayAdminMenu(){
        System.out.println("=== ADMIN MENU ===");
        System.out.println("1. Pokaż użytkowników");
        System.out.println("3. Usuń użytkownika");
        System.out.println("4. Wyjście");
        System.out.print("Wybierz opcje: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                User[] users = getUsers();
                for (User user : users) {
                    System.out.println(user);
                }
                break;
            case 2:
                User newUser = getNewUserDetails();
                System.out.println("User added: " + newUser);
                break;
            case 3:
                System.out.println("Not implemented yet");
                break;
            case 4:
                System.out.println("Dowidzenia!");
                System.exit(0);
                break;
            default:
                System.out.println("Zły wybór.");
                break;
        }
    }
    private static void displayUserMenu() {

    }
}
