package com.infoshareacademy.service;

import com.infoshareacademy.model.User;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    public static User loggedInUser;
    public static void mainMenu() throws IOException {
        login();
        if (loggedInUser == null) {
            System.out.println("Nie udało sie zalogować.");
            return;
        }
        displayMainMenu();
    }
    private static void login() throws IOException{
        boolean placeholder = true;
        do {
            System.out.println("1-->Zaloguj się\n2-->Zarejestruj się\n0-->Wyjdź z programu");
            int option;
            try {
                Scanner scanner = new Scanner(System.in);
                option = scanner.nextInt();
                switch (option) {
                    case 0 -> placeholder = false;
                    case 1 -> {
                        if (UserHandler.logIn()) {
                            loggedInUser = UserHandler.getCurrentUser();
                            placeholder = false;
                        }
                    }
                    case 2 -> UserHandler.getNewUserDetails();
                    default -> System.out.println("Wybierz ponownie.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            }
        } while (placeholder);
    }
    public static void displayMainMenu() {
        System.out.println("Witaj " + loggedInUser.getName() + "!\n" +
                "Wybierz sekcję\n" +
                "1-->Trasa\n" +
                "2-->Punkt kontrolny");
        boolean placeholder = true;
        int menu;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                menu = scanner.nextInt();
                switch (menu) {
                    case 0 -> {
                        placeholder = false;
                        displayMainMenu();
                    }
                    case 1 -> {
                        placeholder = false;
                        menuTrasa();
                    }
                    case 2 -> {
                        placeholder = false;
                        menuControlPoint();
                    }
                    default -> System.out.println("wybierz ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            }
        } while (placeholder);
    }

    private static void menuTrasa() {
        System.out.println("""
                Trasa:\s
                Co chcesz robić?
                1-->uwórz nową trasę
                2-->edytuj trasę
                3-->pokaż trasę
                4-->usuń trasę
                0-->Wróć do poprzedniego menu""");
        int menu;
        boolean placeholder = true;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                menu = scanner.nextInt();
                switch (menu) {
                    case 0 -> displayMainMenu();
                    case 1 -> {
                        placeholder = false;
                        System.out.println("tworzenie nowej trasy");
                    }
                    case 2 -> {
                        placeholder = false;
                        System.out.println("edytowanie trasy");
                    }
                    case 3 -> {
                        placeholder = false;
                        System.out.println("pokazanie tras");
                    }
                    case 4 -> {
                        placeholder = false;
                        System.out.println("usuwanie trasy");
                    }
                    default -> System.out.println("wybierz ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            }
        } while (placeholder);
    }

    private static void menuControlPoint() {
        System.out.println("""
                Punkt kontrolny:\s
                Co chcesz robić?
                1-->uwórz nową trasę
                2-->edytuj trasę
                3-->pokaż trasę
                4-->usuń trasę
                0-->Wróć do poprzedniego menu""");
        int menu;
        boolean placeholder = true;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                menu = scanner.nextInt();
                switch (menu) {
                    case 0 -> displayMainMenu();
                    case 1 -> {
                        placeholder = false;
                        System.out.println("tworzenie nowego punktu");
                    }
                    case 2 -> {
                        placeholder = false;
                        System.out.println("edytowanie punktu");
                    }
                    case 3 -> {
                        placeholder = false;
                        System.out.println("pokazanie puntku");
                    }
                    case 4 -> {
                        placeholder = false;
                        System.out.println("usuwanie punktu");
                    }
                    default -> System.out.println("wybierz ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            }
        } while (placeholder);
    }
}
