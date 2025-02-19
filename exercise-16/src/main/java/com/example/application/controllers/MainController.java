package com.example.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @RequestMapping("/params")
    public String homeRequestParams(@RequestParam String color, @RequestParam String user, Model page) {
        page.addAttribute("username", user);
        page.addAttribute("color", color);
        return "home.html";
    }
    @RequestMapping("/pathvar/{color}/{user}")
    public String homePathVariables(@PathVariable String color,@PathVariable String user, Model page){
        page.addAttribute("username",user);
        page.addAttribute("color",color);
        return "home.html";
    }
}
