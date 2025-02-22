package com.example.exercise23.controllers;

import com.example.exercise23.models.Account;
import com.example.exercise23.models.TransferRequest;
import com.example.exercise23.services.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts() {
        return transferService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable Long id) {
        return transferService.findById(id);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest transferRequest) {
        transferService.transfer(
                transferRequest.getFromId(),
                transferRequest.getToId(),
                transferRequest.getAmount()
        );
    }
}
