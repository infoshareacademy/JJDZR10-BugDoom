package com.infoshareacademy;

import java.util.Scanner;


public class Map {
    private int coordinateX;
    private int coordinateY;
    private int numberOfCheckpoints;
    private String[][] tablica;

    public String[][] getTablica() {
        tablica = new String[6][6];
        tablica[0][0] = "0.0";
        tablica[0][1] = "0.1";
        tablica[0][2] = "0.2";
        tablica[0][3] = "0.3";
        tablica[0][4] = "0.4";
        tablica[0][5] = "0.5";
        tablica[1][0] = "1.0";
        tablica[1][1] = "1.1";
        tablica[1][2] = "1.2";
        tablica[1][3] = "1.3";
        tablica[1][4] = "1.4";
        tablica[1][5] = "1.5";
        tablica[2][0] = "2.0";
        tablica[2][1] = "2.1";
        tablica[2][2] = "2.2";
        tablica[2][3] = "2.3";
        tablica[2][4] = "2.4";
        tablica[2][5] = "2.5";
        tablica[3][0] = "3.0";
        tablica[3][1] = "3.1";
        tablica[3][2] = "3.2";
        tablica[3][3] = "3.3";
        tablica[3][4] = "3.4";
        tablica[3][5] = "3.5";
        tablica[4][0] = "4.0";
        tablica[4][1] = "4.1";
        tablica[4][2] = "4.2";
        tablica[4][3] = "4.3";
        tablica[4][4] = "4.4";
        tablica[4][5] = "4.5";
        tablica[5][0] = "5.0";
        tablica[5][1] = "5.1";
        tablica[5][2] = "5.2";
        tablica[5][3] = "5.3";
        tablica[5][4] = "5.4";
        tablica[5][5] = "5.5";

        return tablica;
    }

    public void setTablica(String[][] tablica) {
        this.tablica = tablica;
    }

    public void drawMap() {
        System.out.println("| --->Y\nV X");
        for (int i = 0; i < tablica.length; i++) { // wiersze
            for (int j = 0; j < tablica.length; j++) { // kolumny
                System.out.print(tablica[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void setCoordinateXY() {
        boolean placeholder = true;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("podaj współrzedną X");
                coordinateX = scanner.nextInt();
                System.out.println("podaj współrzedną Y");
                coordinateY = scanner.nextInt();
                if (coordinateX >= 0 && coordinateX <= 5 && coordinateY >= 0 && coordinateY <= 5) {
                    placeholder = false;
                } else {
                    System.out.println("zakres współrzędnych <0;5>");
                }
            } catch (Exception e) {
                System.out.println("musisz wprowadzić liczbę");
            }
        } while (placeholder);
        return;
    }

    public int getNumberOfCheckpoints() {
        return numberOfCheckpoints;
    }

    public int setNumberOfCheckpoints() {
        boolean placeholder = true;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("podaj ilość checkpointów");
                numberOfCheckpoints = scanner.nextInt();
                if (numberOfCheckpoints > 0 && numberOfCheckpoints <= 3) { //3 checkpointy dla sprawdzenia programu
                    placeholder = false;
                } else {
                    System.out.println("maksymalna ilość checkpointów wynosi 3");
                }
            } catch (Exception e) {
                System.out.println("musisz wprowadzić liczbę");
            }
        } while (placeholder);
        return numberOfCheckpoints;
    }
    public void createCheckpoints() {
        setNumberOfCheckpoints();
        boolean notEqualStartAndEndAndCheckpoints = true;

        for (int k = 1; k <= numberOfCheckpoints; k++) {
            do {

                try {
                    System.out.println("zdefiniuj checkpoint nr " + k);
                    setCoordinateXY();
                    if ((tablica[coordinateX][coordinateY] != "STR") && (tablica[coordinateX][coordinateY] != "END") && (tablica[coordinateX][coordinateY] != "CHP")) {
                        tablica[coordinateX][coordinateY] = "CHP";
                        notEqualStartAndEndAndCheckpoints = false;
                        drawMap();
                    } else {
                        System.out.println("Punkt musi mieć inne współrzędne od wcześniejszej zdefiniowanych");
                    }
                } catch (Exception e) {
                    System.out.println("musisz wprowadzić liczbę");
                }
            } while (notEqualStartAndEndAndCheckpoints);
        }
    }



    public void createStart() {
        getTablica();
        System.out.println("zdefiniuj punkt startowy");
        setCoordinateXY();
        tablica[coordinateX][coordinateY] = "STR";
        drawMap();
        }

    public void createEnd() {
        System.out.println("zdefiniuj punkt końcowy");
        boolean notEqualStart = true;
        do {
            try {
                setCoordinateXY();
                if (tablica[coordinateX][coordinateY] != "STR") {
                    tablica[coordinateX][coordinateY] = "END";
                    notEqualStart = false;
                } else {
                    System.out.println("Meta musi mieć inne współrzędne niż start");
                }
            } catch (Exception e) {
                System.out.println("musisz wprowadzić liczbę");
            }
        } while (notEqualStart);
        drawMap();
    }
}