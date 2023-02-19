package com.infoshareacademy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
public class UserHandler {

    private static File file = new File("users.txt");
//Create username with password
    static void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("name ");
        String username = scanner.nextLine();
        System.out.println("Last name ");
        String userLastName = scanner.nextLine();
        System.out.println("password ");
        String password = scanner.nextLine();
        User user = new User(username, userLastName, password);
        //Make sure that text file is in place.
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            //Save user with password in file.
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(user.getUsername() + "," + user.getUserLastName() + "," + user.getPassword());
            bufferedWriter.newLine();
            bufferedWriter.close();
            System.out.println("User created successfully.");
            //Prevention from crash that might occur while reading or writing to the file.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Login menu. Might add more later on, like name, lastname etc.
    static void logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("name ");
        String username = scanner.nextLine();
        System.out.println("last name");
        String userLastName = scanner.nextLine();
        System.out.println("password ");
        String password = scanner.nextLine();
//           Check if in saved file username (part[0]), userLastName (part[1]) and password (part[2])
//           match to any saved in array of strings separeted by a comma.
//           If both conditions are true, it means that the username and password match a record in the file,
//           and the code will print "Login successfull." and return.
//           If the username and password don't match any record in the file,
//           the code will continue looping until it has read all the lines in the file or until it finds a match.
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(userLastName) && parts[2].equals(password)) {
                    System.out.println("Login successfull.");
                    return;
                }
            }
            System.out.println("Incorrect username or password.");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
