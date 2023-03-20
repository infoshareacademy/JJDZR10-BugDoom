package com.infoshareacademy.service;

import com.infoshareacademy.model.User;

import java.io.IOException;

import com.infoshareacademy.model.Track;

import java.util.InputMismatchException;
import java.util.Optional;
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

    private static void login() throws IOException {
        boolean loginMenu = true;
        do {
            System.out.println("1-->Zaloguj się\n2-->Zarejestruj się\n0-->Wyjdź z programu");
            try {
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                switch (option) {
                    case 0 -> {
                        System.out.println("Koniec programu. Do zobaczenia!");
                        loginMenu = false;
                    }
                    case 1 -> {
                        if (UserService.logIn()) {
                            loggedInUser = UserService.getCurrentUser();
                            loginMenu = false;
                        }
                    }
                    case 2 -> UserService.getNewUserDetails();
                    default -> System.out.println("Wybierz ponownie.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            }
        }while (loginMenu);
    }

    public static void displayMainMenu() {
        System.out.println("Witaj " + loggedInUser.getName() + "!\n" +
                "Wybierz sekcję\n" +
                "1-->Trasa\n" +
                "2-->Punkt kontrolny");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int menu = scanner.nextInt();
                switch (menu) {
                    case 0 -> displayMainMenu();
                    case 1 -> trackMenu();
                    case 2 -> menuControlPoint();
                    default -> System.out.println("wybierz ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            }
        }
    }

    private static void trackMenu() {
        System.out.println("""
                Trasa:
                Co chcesz robić?
                1-->Uwórz nową trasę
                2-->Wyświetl pojedynczą trasę
                3-->Pokaż wszystkie trasy
                4-->Edytuj trasę
                5-->Usuń trasę
                0-->Wróć do poprzedniego menu""");

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int menu = scanner.nextInt();
                switch (menu) {
                    case 0 -> displayMainMenu();
                    case 1 -> {
                        TrackService.createTrack();
                        trackMenu();
                    }
                    case 2 -> {
                        allTrackMenu();
                    }
                    case 3 -> {
                        TrackService.printAllTracks();
                        trackMenu();
                    }
                    case 4 -> {
                        System.out.println("usuwanie trasy");
                    }
                    default -> System.out.println("wybierz ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void allTrackMenu() throws IOException {
        System.out.println("""
                Co chcesz robić?
                1-->Pokaż detale jednej z tras
                0-->Wróć do poprzedniego menu""");
        boolean stillInMenu = true;
        while (stillInMenu) {
            try {
                Scanner scanner = new Scanner(System.in);
                int userChoice = scanner.nextInt();
                switch (userChoice) {
                    case 0 -> trackMenu();
                    case 1 -> {
                        TrackService.printAllTracks();
                        System.out.println("Wybierz id trasy:");
                        scanner = new Scanner(System.in);
                        String trackId = scanner.nextLine();
                        Optional<Track> optionalTrack = TrackService.findTrackById(trackId);
                        if (optionalTrack.isPresent()) {
                            stillInMenu = false;
                            oneTrackMenu(optionalTrack.get());
                            trackMenu();
                        } else {
                            System.out.println("Nie znaleziono trasy o takim id");
                        }
                    }
                    default -> System.out.println("Wybierz ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            }
        }
    }

    private static void oneTrackMenu(Track track) throws IOException {
        boolean stillInMenu = true;
        System.out.println(track);
        System.out.println("""
                Co chcesz zrobić?
                1-->Edytuj trasę
                2-->Usuń trasę
                0-->Wróć do poprzedniego menu""");
        while (stillInMenu) {
            try {
                Scanner scanner = new Scanner(System.in);
                int userChoice = scanner.nextInt();
                switch (userChoice) {
                    case 0 -> {
                        stillInMenu = false;
                        allTrackMenu();
                    }
                    case 1 -> {
                        stillInMenu = false;
                        System.out.println("Edytowanie trasy");
                        allTrackMenu();
                    }
                    case 2 -> {
                        stillInMenu = false;
                        TrackService.deleteTrack(track);
                        allTrackMenu();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            }
        }
    }

    private static void menuControlPoint() {
        System.out.println("""
                Punkt kontrolny:
                Co chcesz robić?
                1-->pokaż punkty kontrolne
                2-->dodaj punkt kontrolny
                0-->Wróć do głównego menu""");
        int menu;
        boolean stillInMenu = true;
        while (stillInMenu) {
            try {
                Scanner scanner = new Scanner(System.in);
                menu = scanner.nextInt();
                switch (menu) {
                        case 0 -> displayMainMenu();
                        case 1 -> {
                            TrackService.printAllTracks();
                            stillInMenu = false;
                            System.out.println("Wybierz id trasy:");
                            scanner = new Scanner(System.in);
                            String trackId = scanner.nextLine();
                            Optional<Track> optionalTrack = TrackService.findTrackById(trackId);
                            if (optionalTrack.isPresent()) {
                                stillInMenu = false;
                                oneTrackMenu(optionalTrack.get());
                                trackMenu();
                            } else {
                                System.out.println("Nie znaleziono trasy o takim id");
                            }
                        }
                        case 2 -> {
                            stillInMenu = false;
                            System.out.println("edytowanie punktu");
                        }
                        default -> System.out.println("wybierz ponownie");
                }
            } catch (InputMismatchException | IOException e) {
                System.out.println("Zła opcja!");
            }
        }
    }
}
