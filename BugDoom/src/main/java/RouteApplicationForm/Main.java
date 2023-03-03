package RouteApplicationForm;

import com.infoshareacademy.model.ControlPoint;
import com.infoshareacademy.model.Track;

import javax.naming.ldap.Control;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void createTrack() {
        Track newTrack = new Track();

        newTrack.setCompetitionName(setCompetitionName());
        newTrack.setLength(setCompetitionLength());
        newTrack.setDifficulty(setCompetitionDifficulty(newTrack.getLength()));
        newTrack.setLocation(setCompetitionLocation());
        newTrack.setStartPoint(setCompetitionStartPoint());
        // meta
        // punkty kontrolne

        System.out.println(newTrack);
//        ApplicationForm diffType = new ApplicationForm();
//        diffType.ApplicationForm();
//        newTrack.createMap();
        System.out.println("Dziękujemy za wypełnienie formularza! :) ");
    }
    private static String setCompetitionName () {
        System.out.println("Witaj w formularzu zgłoszeniowym do Twojej nowej trasy :) ");
        boolean nameFormatIncorrect = true;
        while (nameFormatIncorrect) {
            System.out.println("Podaj nazwę Twojego biegu:");

            Scanner scanner1 = new Scanner(System.in);
            String competitionName = scanner1.nextLine();
            if (ExcludeIntegers.containsIntegers(competitionName)) {
                System.out.println("Podana wartość musi zostać zapisana w formie tekstu! Spróbuj ponownie.");

            } else {
                return competitionName;
            }
        }
        return "";
    }
    private static int setCompetitionLength() {

        ArrayList<String> items = new ArrayList<String>();
        items.add("łatwa 5 km");
        items.add("normalna 10km");
        items.add("trudna 15km");

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Wybierz poziom trudności trasy z listy: ");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i+1) + ". " + items.get(i));
        }
        int choice = 0;
        boolean validChoice = false;
        do {
            try {
                choice = scanner2.nextInt();
                if (choice >= 1 && choice <= items.size()) {
                    validChoice = true;
                } else {
                    System.out.println("Niepoprawna wartość! Wybierz numer pomiędzy 1 a " + items.size() + ".");
                }
            } catch (Exception e) {
                System.out.println("Niepoprawna wartość! Wybierz numer.");
                scanner2.nextLine();
            }
        } while (!validChoice);
        return switch (choice) {
            case 1 -> 5;
            case 2 -> 10;
            case 3 -> 15;
            default -> 0;
        };
    }
    private static String setCompetitionDifficulty(int length) {
        return switch (length) {
            case 5 -> "łatwa";
            case 10 -> "średnia";
            case 15 -> "trudna";
            default -> "";
        };
    }
    private static String setCompetitionLocation() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    Wybierz lokalizację biegu:
                    1 -> Las
                    2 -> Miasto
                    3 -> Góry""");
            try {
                int choice = scanner.nextInt();
                return switch (choice) {
                    case 1 -> "las";
                    case 2 -> "miasto";
                    case 3 -> "góry";
                    default -> "nieokreślono";
                };
            } catch (InputMismatchException e) {
                System.out.println("Musisz wybrać liczbę od 1 do 3");
            }
        }
    }
    private static ControlPoint setCompetitionStartPoint () {
        ControlPoint controlPoint = new ControlPoint();
        boolean coordinatesNotGiven = true;
        while (coordinatesNotGiven) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Podaj współrzędne startu (od 0 do 5)");
                System.out.println("Podaj współrzędną x:");
                int x = scanner.nextInt();
                scanner = new Scanner(System.in);
                System.out.println("Podaj współrzędną y:");
                int y = scanner.nextInt();
                controlPoint.x = x;
                controlPoint.y = y;
                if (controlPoint.x < 0 || controlPoint.x > 5 || controlPoint.y < 0 || controlPoint.y > 5)
                {
                    System.out.println("Współrzędne muszą być w przedziale od 0 do 5!");
                } else {
                    coordinatesNotGiven = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Podaj liczbę całkowitą");
            }
        }
        controlPoint.setControlPointID("001");
        return controlPoint;
    }
}
