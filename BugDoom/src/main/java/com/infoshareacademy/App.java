package com.infoshareacademy;

import com.infoshareacademy.model.User;
import com.infoshareacademy.service.DataHandler;
import com.infoshareacademy.service.UserDataHandler;
import com.infoshareacademy.service.UserService;

import java.io.IOException;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException {
        UserService userService = new UserService();
//        User user1 = new User("001");
//        User user2 = new User("002");
//        User user3 = new User("003");
//        DataHandler.appendToFile(user1);
//        DataHandler.appendToFile(user2);
//        DataHandler.appendToFile(user3);
        UserDataHandler<User> udh = new UserDataHandler<>();
        List<User> users = udh.readUsersFromFile("User.json");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
