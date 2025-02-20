package com.example.application.models;

import com.example.application.services.LoggedUsernameManagementService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessors {
    private String username;
    private String password;
    private final LoggedUsernameManagementService loggedUsernameManagementService;

    public LoginProcessors(LoggedUsernameManagementService loggedUsernameManagementService) {
        this.loggedUsernameManagementService = loggedUsernameManagementService;
    }

    public boolean login() {
        String username = this.getUsername();
        String password = this.getPassword();
        System.out.println("username: " + username);

        boolean loginResult = false;

        if ("ger".equals(username) && "pass".equals(password)) {
            loginResult = true;
            loggedUsernameManagementService.setUsername(username);
        }
        return loginResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
