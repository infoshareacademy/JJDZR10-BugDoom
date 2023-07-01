package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.User;
import com.infoshareacademy.pl.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "UserLogin";
    }

    @GetMapping("/register")
    public String register() {
        return "NewUserForm";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/welcome")
    public String getWelcome(){
        return "WelcomePage";
    }

}

