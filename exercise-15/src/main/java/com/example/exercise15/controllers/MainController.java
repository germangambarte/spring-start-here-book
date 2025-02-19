package com.example.exercise15.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home(Model page) {
        page.addAttribute("username", "Ger");
        page.addAttribute("color", "red");
        return "home.html";
    }
}
