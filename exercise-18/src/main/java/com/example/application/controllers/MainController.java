package com.example.application.controllers;

import com.example.application.services.LoggedUsernameManagementService;
import com.example.application.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUsernameManagementService loggedUsernameManagementService;
    private final LoginCountService loginCountService;

    public MainController(LoggedUsernameManagementService loggedUsernameManagementService, LoginCountService loginCountService) {
        this.loggedUsernameManagementService = loggedUsernameManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/")
    public String home(
            @RequestParam(required = false) String logout,
            Model page
    ) {
        if (logout != null) {
            loggedUsernameManagementService.setUsername(null);
        }

        var username = loggedUsernameManagementService.getUsername();

        if (username == null) {
            return "redirect:/login";
        }
        page.addAttribute("username", username);
        page.addAttribute("count", loginCountService.getCount());
        return "home.html";
    }
}
