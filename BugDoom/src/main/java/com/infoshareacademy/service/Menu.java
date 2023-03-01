package com.infoshareacademy.service;

import java.io.IOException;

import com.infoshareacademy.model.Track;

import java.util.InputMismatchException;
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
        System.out.println("Trasa: \n" +
                "Co chcesz robić?\n" +
                "1-->uwórz nową trasę\n" +
                "2-->edytuj trasę\n" +
                "3-->Pokaż wszystkie trasy\n" +
                "4-->usuń trasę\n" +
                "0-->Wróć do poprzedniego menu");
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
                        System.out.println("edytowanie trasy");
                        break;
                    case 3:
                        placeholder = false;
                        TrackService.printAllTracks();
                        break;
                    case 4:
                        placeholder = false;
                        TrackService.printAllTracks();
                        TrackService.deleteTrack();
                        menuTrasa();
                        break;
                    default:
                        System.out.println("wybierz ponownie");
                }
            } catch (InputMismatchException e){
                System.out.println("Zła opcja!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (placeholder);
    }
    private static void menuControlPoint() {
        System.out.println("Punkt kontrolny: \n" +
                "Co chcesz robić?\n" +
                "1-->uwórz nową trasę\n" +
                "2-->edytuj trasę\n" +
                "3-->pokaż trasę\n" +
                "4-->usuń trasę\n" +
                "0-->Wróć do poprzedniego menu");
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
            } catch (InputMismatchException e){
                System.out.println("Zła opcja!");
            }
        } while (placeholder);
    }
}
