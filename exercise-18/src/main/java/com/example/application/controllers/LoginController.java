package com.example.application.controllers;

import com.example.application.models.LoginProcessors;
import com.example.application.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginProcessors loginProcessors;
    private final LoginCountService loginCountService;

    public LoginController(LoginProcessors loginProcessors, LoginCountService loginCountService) {
        this.loginProcessors = loginProcessors;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/login")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model page
    ) {
        loginCountService.increment();
        loginProcessors.setUsername(username);
        loginProcessors.setPassword(password);
        boolean loggedIn = loginProcessors.login();

        if (loggedIn) {
            return "redirect:/";
        }

        page.addAttribute("message", "Login failed!");
        return "login.html";
    }
}
