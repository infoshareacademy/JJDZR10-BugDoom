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
                        if (UserService.logIn()) {
                            loggedInUser = UserService.getCurrentUser();
                            placeholder = false;
                        }
                    }
                    case 2 -> UserService.getNewUserDetails();
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
                1-->Uwórz nową trasę
                2-->Edytuj trasę
                3-->Pokaż wszystkie trasy
                4-->Usuń trasę
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
                        TrackService.printAllTracks();
                    }
                    case 4 -> {
                        placeholder = false;
                        System.out.println("usuwanie trasy");
                    }
                    default -> System.out.println("wybierz ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (placeholder);
    }

    private static void menuControlPoint() {
        System.out.println("""
                Punkt kontrolny:\s
                Co chcesz robić?
                1-->Uwórz nowy punkt kontrolny
                2-->Edytuj punkt kontrolny
                3-->Pokaż wszystkie punkty kontrolne
                4-->Usuń punkt kontrolny
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
