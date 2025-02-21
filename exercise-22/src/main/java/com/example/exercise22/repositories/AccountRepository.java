package com.example.exercise22.repositories;

import com.example.exercise22.models.Account;
import com.example.exercise22.models.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {
    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Account> findAll() {
        String sql = "select * from accounts";
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }

    public Account findById(int id) {
        String sql = "select * from accounts where id = ?";
        return jdbcTemplate.queryForObject(sql,new AccountRowMapper(), id);
    }

    public void updateAmount(int id, BigDecimal amount) {
        String sql = "update accounts set amount = ? where id = ?";
        jdbcTemplate.update(sql,amount,id);
    }
}
