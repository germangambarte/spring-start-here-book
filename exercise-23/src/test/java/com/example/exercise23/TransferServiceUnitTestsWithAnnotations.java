package com.example.exercise23;

import com.example.exercise23.exceptions.AccountNotFoundException;
import com.example.exercise23.models.Account;
import com.example.exercise23.repositories.AccountRepository;
import com.example.exercise23.services.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTestsWithAnnotations {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    TransferService transferService;

    @Test
    public void transferToNotFoundDestination() {
        Account fromAccount = new Account();
        fromAccount.setId(1L);
        fromAccount.setAmount(new BigDecimal(1000));

        Account toAccount = new Account();
        toAccount.setId(2L);
        toAccount.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(fromAccount.getId()))
                .willReturn(Optional.of(fromAccount));
        given(accountRepository.findById(toAccount.getId()))
                .willReturn(Optional.empty());

        assertThrows(
                AccountNotFoundException.class,
                () -> transferService.transfer(fromAccount.getId(), toAccount.getId(), new BigDecimal(100))
        );


        verify(accountRepository,never()).changeAmount(anyLong(),any());
    }
}
