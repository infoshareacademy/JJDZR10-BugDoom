package com.infoshareacademy;
import java.util.Scanner;
public class App 
{
    public static void main( String[] args ) {
        //Create a scanner object to read from input.
        Scanner scanner = new Scanner(System.in);
        //Create an object of class.
        UserHandler userHandler = new UserHandler();
        //Infinite loop that displays a menu to the user and allows to perform actions.
        while (true) {
            //Print options.
            System.out.println("1. Create user");
            System.out.println("2. Log in");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            //Read the choice.
            int choice = scanner.nextInt();
            //Switch statement performs an action based on user's choice.
            switch (choice) {
                case 1:
                    //Call createUser method from UserHandler class.
                    UserHandler.createUser();
                    break;
                case 2:
                    //Call the logIn method from the UserHandler class.
                    UserHandler.logIn();
                    break;
                case 3:
                    //Exits the program.
                    System.exit(0);
                default:
                    //If the user inputs an invalid choice, print error message.
                    System.out.println("Invalid choice. Try again.");
            }

        }
    }
}
