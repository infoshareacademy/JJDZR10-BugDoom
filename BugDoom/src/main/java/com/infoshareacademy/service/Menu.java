package com.infoshareacademy.service;

import com.infoshareacademy.model.Admin;
import com.infoshareacademy.model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void displayMainMenu() {
        System.out.println("Witaj w aplikacji!\n" +
                "Wybierz sekcję\n" +
                "1-->Trasa\n" +
                "2-->Punkt kontrolny\n" +
                "0-->Wróć do poprzedniego menu");
        boolean placeholder = true;
        int menu;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                menu = scanner.nextInt();
                if (menu == 0) {
                    placeholder = false;
                    displayMainMenu();
//                    case 1:
//                        placeholder = false;
//                        menuTrasa();
//                        break;
//                    case 2:
//                        placeholder = false;
//                        menuControlPoint();
//                        break;
                } else {
                    System.out.println("wybierz ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            }
        } while (placeholder);
    }

    public static void displayAdminMenu(Admin admin) {
        System.out.println("Witaj " + admin.getName() + "!\n" +
                "Wybierz sekcję\n" +
                "1-->Lista użytkowników\n" +
                "0-->Wyloguj");
        boolean placeholder = true;
        int menu;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                menu = scanner.nextInt();
                switch (menu) {
                    case 0:
                        placeholder = false;
                        displayMainMenu();
                        break;
                    case 1:
                        placeholder = false;
                        displayUserList(admin);
                        break;
                    default:
                        System.out.println("wybierz ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            }
        } while (placeholder);
    }

    private static void displayUserList(Admin admin) {
        User[] users = admin.getUsers();
        System.out.println("Lista użytkowników:");
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

//    private static void menuTrasa() {
//        System.out.println("Trasa: \n" +
//                "Co chcesz robić?\n" +
//                "1-->uwórz nową trasę\n" +
//                "2-->edytuj trasę\n" +
//                "3-->pokaż trasę\n" +
//                "4-->usuń trasę\n" +
//                "0-->Wróć do poprzedniego menu");
//        int menu;
//        boolean placeholder = true;
//        do {
//            try {
//                Scanner scanner = new Scanner(System.in);
//                menu = scanner.nextInt();
//                switch (menu) {
//                    case 0:
//                        displayMainMenu();
//                        break;
//                    case 1:
//                        placeholder = false;
//                        System.out.println("tworzenie nowej trasy");
//                        break;
//                    case 2:
//                        placeholder = false;
//                        System.out.println("edytowanie trasy");
//                        break;
//                    case 3:
//                        placeholder = false;
//                        System.out.println("pokazanie tras");
//                        break;
//                    case 4:
//                        placeholder = false;
//                        System.out.println("usuwanie trasy");
//                        break;
//                    default:
//                        System.out.println("wybierz ponownie");
//                        break;
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Zła opcja!");
//            }
//        } while (placeholder);
//    }
//
//    private static void menuControlPoint() {
//        System.out.println("Punkt kontrolny: \n" +
//                "Co chcesz robić?\n" +
//                "1-->uwórz nową trasę\n" +
//                "2-->edytuj trasę\n" +
//                "3-->pokaż trasę\n" +
//                "4-->usuń trasę\n" +
//                "0-->Wróć do poprzedniego menu");
//        int menu;
//        boolean placeholder = true;
//        do {
//            try {
//                Scanner scanner = new Scanner(System.in);
//                menu = scanner.nextInt();
//                switch (menu) {
//                    case 0:
//                        displayMainMenu();
//                        break;
//                    case 1:
//                        placeholder = false;
//                        System.out.println("tworzenie nowego punktu");
//                        break;
//                    case 2:
//                        placeholder = false;
//                        System.out.println("edytowanie punktu");
//                        break;
//                    case 3:
//                        placeholder = false;
//                        System.out.println("pokazanie puntku");
//                        break;
//                    case 4:
//                        placeholder = false;
//                        System.out.println("usuwanie punktu");
//                        break;
//                    default:
//                        System.out.println("wybierz ponownie");
//                        break;
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Zła opcja!");
//            }
//        } while (placeholder);
}
