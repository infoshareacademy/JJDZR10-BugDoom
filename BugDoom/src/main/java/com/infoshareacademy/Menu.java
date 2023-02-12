package com.infoshareacademy;

import java.util.Scanner;

public class Menu {
    // logowanie się i str główna
    public static void mainMenu() {
        System.out.println("Witaj w aplikacji!\nxxxx?\n1-->Trasa\n2-->Punkt kontrolny");
        int menu;
        do {
            Scanner scanner = new Scanner(System.in);
            menu = scanner.nextInt();


            switch (menu) {
                case 0:
                    mainMenu();
                case 1:
                    menuTrasa();
                    break;
                case 2:
                    System.out.println("edytowanie trasy");
                    break;
                case 3:
                    System.out.println("pokazanie tras");
                    break;
                case 4:
                    System.out.println("usuwanie trasy");
                default:
                    System.out.println("wybierz ponownie");
            }
        } while (menu < 0 || menu > 4);
    }

    private static void menuTrasa() {
        System.out.println("Witaj w aplikacji!\nCo chcesz robić?\n1-->uwórz nową trasę\n2-->edytuj trasę\n3-->pokaż trasę\n4-->usuń trasę\n0-->Wróć do poprzedniego menu");
        int menu;
        do {
            Scanner scanner = new Scanner(System.in);
            menu = scanner.nextInt();


            switch (menu) {
                case 0:
                    mainMenu();
                case 1:
                    System.out.println("tworzenie nowej trasy");
                    break;
                case 2:
                    System.out.println("edytowanie trasy");
                    break;
                case 3:
                    System.out.println("pokazanie tras");
                    break;
                case 4:
                    System.out.println("usuwanie trasy");
                default:
                    System.out.println("wybierz ponownie");
            }
        } while (menu < 1 || menu > 4);
    }
}
