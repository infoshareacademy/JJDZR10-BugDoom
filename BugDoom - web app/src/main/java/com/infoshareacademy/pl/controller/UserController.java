package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.logger.BaseLogger;
import com.infoshareacademy.pl.model.User;
import com.infoshareacademy.pl.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController extends BaseLogger {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        logger.info("Wywołano metodę login()");
        return "UserLogin";
    }

    @GetMapping("/register")
    public String register() {
        logger.info("Wywołano metodę register()");
        return "NewUserForm";
    }

    @GetMapping("/users")
    public String getUsers(Model model) throws IOException {
        logger.info("Wywołano metodę getUsers()");
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/welcome")
    public String getWelcome(){
        return "WelcomePage";
    }

}

