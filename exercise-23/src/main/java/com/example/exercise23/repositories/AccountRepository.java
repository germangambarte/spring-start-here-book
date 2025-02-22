package com.example.exercise23.repositories;

import com.example.exercise23.models.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query("SELECT * FROM accounts WHERE name = :name")
    List<Account> findAccountsByName(String name);

    @Modifying
    @Query("UPDATE accounts SET amount = :amount WHERE id = :id")
    void changeAmount(Long id, BigDecimal amount);
}
