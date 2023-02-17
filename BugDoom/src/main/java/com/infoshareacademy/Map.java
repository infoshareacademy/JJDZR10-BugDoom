package com.infoshareacademy;

import java.util.Scanner;


public class Map {
    private int coordinateX;
    private int coordinateY;


    public void drawMap() {
        String tablica[][] = new String[5][5];

        tablica[0][0] = "0.0";
        tablica[0][1] = "0.1";
        tablica[0][2] = "0.2";
        tablica[0][3] = "0.3";
        tablica[0][4] = "0.4";

        tablica[1][0] = "1.0";
        tablica[1][1] = "1.1";
        tablica[1][2] = "1.2";
        tablica[1][3] = "1.3";
        tablica[1][4] = "1.4";

        tablica[2][0] = "2.0";
        tablica[2][1] = "2.1";
        tablica[2][2] = "2.2";
        tablica[2][3] = "2.3";
        tablica[2][4] = "2.4";

        tablica[3][0] = "3.0";
        tablica[3][1] = "3.1";
        tablica[3][2] = "3.2";
        tablica[3][3] = "3.3";
        tablica[3][4] = "3.4";

        tablica[4][0] = "4.0";
        tablica[4][1] = "4.1";
        tablica[4][2] = "4.2";
        tablica[4][3] = "4.3";
        tablica[4][4] = "4.4";

        for (int i = 0; i < tablica.length; i++) { // wiersze
            for (int j = 0; j < tablica.length; j++) { // kolumny
                System.out.print(tablica[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public int setCoordinateX() {
        boolean placeholder = true;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("podaj współrzedną X");
                coordinateX = scanner.nextInt();
                if (coordinateX >= 0 && coordinateX <= 4) {
                    placeholder = false;
                } else {
                    System.out.println("zakres <0;4>");
                }
            } catch (Exception e) {
                System.out.println("musisz wprowadzić liczbę");
            }
        } while (placeholder);
        System.out.println("współrzędna X = " + coordinateX);
        return coordinateX;
    }

    public int setCoordinateY() {
        boolean placeholder = true;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("podaj współrzedną Y");
                coordinateY = scanner.nextInt();
                if (coordinateY >= 0 && coordinateY <= 4) {
                    placeholder = false;

                } else {
                    System.out.println("zakres <0;4>");
                }
            } catch (Exception e) {
                System.out.println("musisz wprowadzić liczbę");
            }
        } while (placeholder);
        System.out.println("współrzędna Y = " + coordinateY);
        return coordinateY;
    }

    public void createStart() {
        setCoordinateX();
        setCoordinateY();
        String tablica[][] = new String[5][5];

        tablica[0][0] = "0.0";
        tablica[0][1] = "0.1";
        tablica[0][2] = "0.2";
        tablica[0][3] = "0.3";
        tablica[0][4] = "0.4";

        tablica[1][0] = "1.0";
        tablica[1][1] = "1.1";
        tablica[1][2] = "1.2";
        tablica[1][3] = "1.3";
        tablica[1][4] = "1.4";

        tablica[2][0] = "2.0";
        tablica[2][1] = "2.1";
        tablica[2][2] = "2.2";
        tablica[2][3] = "2.3";
        tablica[2][4] = "2.4";

        tablica[3][0] = "3.0";
        tablica[3][1] = "3.1";
        tablica[3][2] = "3.2";
        tablica[3][3] = "3.3";
        tablica[3][4] = "3.4";

        tablica[4][0] = "4.0";
        tablica[4][1] = "4.1";
        tablica[4][2] = "4.2";
        tablica[4][3] = "4.3";
        tablica[4][4] = "4.4";

        tablica[coordinateX][coordinateY] = "ST ";
        for (int i = 0; i < tablica.length; i++) { // wiersze
            for (int j = 0; j < tablica.length; j++) { // kolumny
                System.out.print(tablica[i][j] + " ");
            }
            System.out.println("");
        }
    }
}