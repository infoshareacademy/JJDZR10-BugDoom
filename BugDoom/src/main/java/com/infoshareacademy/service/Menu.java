package com.infoshareacademy.service;

import java.io.IOException;

import com.infoshareacademy.model.Track;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    public static void mainMenu() {
        System.out.println("Witaj w aplikacji!\n" +
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
                    case 0:
                        placeholder = false;
                        mainMenu();
                    case 1:
                        placeholder = false;
                        menuTrasa();
                        break;
                    case 2:
                        placeholder = false;
                        menuControlPoint();
                        break;
                    default:
                        System.out.println("wybierz ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            }
        } while (placeholder);
    }

    private static void menuTrasa() {
        System.out.println("""
                Trasa:
                Co chcesz robić?
                1-->Uwórz nową trasę
                2-->Pokaż wszystkie trasy
                0-->Wróć do poprzedniego menu""");
        int menu;
        boolean placeholder = true;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                menu = scanner.nextInt();
                switch (menu) {
                    case 0:
                        mainMenu();
                    case 1:
                        placeholder = false;
                        System.out.println("tworzenie nowej trasy");
                        Track track = new Track();
                        track.createMap();
                        break;
                    case 2:
                        placeholder = false;
                        allTrackMenu();
                        break;
                    default:
                        System.out.println("Wybierz ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (placeholder);
    }

    private static void allTrackMenu() throws IOException {
        TrackService.printAllTracks();
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
                    case 0 -> menuTrasa();
                    case 1 -> {
                        System.out.println("Wybierz id trasy:");
                        scanner = new Scanner (System.in);
                        String trackId = scanner.nextLine();
                        Optional<Track> optionalTrack = TrackService.findTrackById(trackId);
                        if (optionalTrack.isPresent()) {
                            stillInMenu = false;
                            oneTrackMenu(optionalTrack.get(), trackId);
                            menuTrasa();
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

    private static void oneTrackMenu(Track track, String trackId) throws IOException {
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
                    case 0:
                        mainMenu();
                        break;
                    case 1:
                        placeholder = false;
                        System.out.println("tworzenie nowego punktu");
                        break;
                    case 2:
                        placeholder = false;
                        System.out.println("edytowanie punktu");
                        break;
                    case 3:
                        placeholder = false;
                        System.out.println("pokazanie puntku");
                        break;
                    case 4:
                        placeholder = false;
                        System.out.println("usuwanie punktu");
                    default:
                        System.out.println("wybierz ponownie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zła opcja!");
            }
        } while (placeholder);
    }
}

