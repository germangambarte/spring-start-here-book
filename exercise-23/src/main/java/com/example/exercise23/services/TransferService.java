package com.example.exercise23.services;

import com.example.exercise23.exceptions.AccountNotFoundException;
import com.example.exercise23.models.Account;
import com.example.exercise23.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException());
    }

    @Transactional
    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        if (fromId == toId) {
            System.out.println(fromId + " -> " + toId);
            throw new RuntimeException("fromId and toId cannot be the same");
        }
        Account fromAccount = accountRepository.findById(fromId).orElseThrow(() -> new AccountNotFoundException());
        Account toAccount = accountRepository.findById(toId).orElseThrow(() -> new AccountNotFoundException());

        BigDecimal fromAccountNewAmount = fromAccount.getAmount().subtract(amount);
        BigDecimal toAccountNewAmount = toAccount.getAmount().add(amount);

        accountRepository.changeAmount(fromId, fromAccountNewAmount);
        accountRepository.changeAmount(toId, toAccountNewAmount);
    }
}
