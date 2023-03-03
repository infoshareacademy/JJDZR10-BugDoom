package RouteApplicationForm;

import com.infoshareacademy.model.Track;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static Track createTrack(String[] args) {
        Track newTrack = new Track();

        newTrack.setCompetitionName(setCompetitionName());
        newTrack.setLength(setCompetitionLength());
        newTrack.setDifficulty(setCompetitionDifficulty(newTrack.getLength()));
        newTrack.setLocation(setCompetitionLocation());

        ApplicationForm diffType = new ApplicationForm();
        diffType.ApplicationForm();
        // tu wołane metody Grzesia
        System.out.println("Dziękujemy za wypełnienie formularza! :) ");
        return newTrack;
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
}
