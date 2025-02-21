package com.example.exercise22.services;

import com.example.exercise22.models.Account;
import com.example.exercise22.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(int fromAccountId, int toAccountId, BigDecimal amount) {
        Account fromAccount = accountRepository.findById(fromAccountId);
        Account toAccount = accountRepository.findById(toAccountId);

        BigDecimal fromAccountNewAmount = fromAccount.getAmount().subtract(amount);
        BigDecimal toAccountNewAmount = toAccount.getAmount().add(amount);

        accountRepository.updateAmount(fromAccountId, fromAccountNewAmount);
        accountRepository.updateAmount(toAccountId, toAccountNewAmount);
        if(fromAccountId == toAccountId) {
            throw new RuntimeException("fromAccountId and toAccountId cannot be the same");
        }
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
