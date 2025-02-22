package com.example.exercise23;

import com.example.exercise23.models.Account;
import com.example.exercise23.repositories.AccountRepository;
import com.example.exercise23.services.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TransferServiceUnitTests {
    @Test
    @DisplayName("Should transfer the amount from one account to another.")
    public void transferHappyPath() {
        AccountRepository accountRepository = mock(AccountRepository.class);
        TransferService transferService = new TransferService(accountRepository);

        Account fromAccount = new Account();
        fromAccount.setId(1L);
        fromAccount.setAmount(new BigDecimal(1000));

        Account toAccount = new Account();
        toAccount.setId(2L);
        toAccount.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(fromAccount.getId()))
                .willReturn(Optional.of(fromAccount));
        given(accountRepository.findById(toAccount.getId()))
                .willReturn(Optional.of(toAccount));

        transferService.transfer(fromAccount.getId(), toAccount.getId(), new BigDecimal(100));

        verify(accountRepository).changeAmount(1L, new BigDecimal(900));
        verify(accountRepository).changeAmount(2L, new BigDecimal(1100));
    }
}
