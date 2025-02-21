package com.example.exercise22.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSer, int i) throws SQLException {
        Account a = new Account();
        a.setId(resultSer.getInt("id"));
        a.setName(resultSer.getString("name"));
        a.setAmount(resultSer.getBigDecimal("amount"));
        return a;
    }
}
