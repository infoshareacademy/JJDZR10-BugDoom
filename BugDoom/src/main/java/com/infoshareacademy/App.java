package com.infoshareacademy;

import com.infoshareacademy.model.User;
import com.infoshareacademy.service.Menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void appendToFile (String filename, String data) {
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("1. Nowe konto\n2. Log in\n3. Wyjście");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    User user = UserHandler.getNewUserDetails();
                    UserHandler.appendToFile("user.json", user.toString());
                    break;
                case "2":
                    UserHandler.logIn();
                    loggedIn = true;
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nie prawidłowy wybór. Spróbuj ponownie.");
            }
        }
        Menu menu = new Menu();
        Menu.displayMainMenu();
    }
}
