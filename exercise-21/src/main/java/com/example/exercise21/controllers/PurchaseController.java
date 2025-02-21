package com.example.exercise21.controllers;

import com.example.exercise21.models.Purchase;
import com.example.exercise21.repositories.PurchaseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping
    public List<Purchase> getPurchases() {
        return purchaseRepository.findAll();
    }

    @PostMapping
    public void postPurchase(@RequestBody Purchase purchase) {
        System.out.println("Saving purchase " + purchase.getProduct());
        purchaseRepository.save(purchase);
    }

}
