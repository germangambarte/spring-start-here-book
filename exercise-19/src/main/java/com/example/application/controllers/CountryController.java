package com.example.application.controllers;

import com.example.application.models.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        Country c = Country.of("France", 67);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Paris")
                .header("favorite_food", "cheese and wine")
                .body(c);
    }

    @GetMapping("/all")
    public List<Country> getAll() {
        var c1 = Country.of("Argentina", 45);
        var c2 = Country.of("Brasil", 37);
        return List.of(c1, c2);
    }
}
