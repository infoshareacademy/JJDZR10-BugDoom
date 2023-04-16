package com.infoshareacademy.pl.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String getDashboard(Model model){
        model.addAttribute("Dashboard", "dashboard");
        return "MainMenu";
    }

    @GetMapping("/login")
    public String getMainPage() {
        return "UserLogin";
    }

}
