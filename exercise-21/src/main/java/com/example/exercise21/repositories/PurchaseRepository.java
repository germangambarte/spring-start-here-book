package com.example.exercise21.repositories;

import com.example.exercise21.models.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbc;

    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Purchase purchase) {
        String sql = "INSERT INTO purchases VALUES (NULL, ?, ?)";
        jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAll() {
        String sql = "SELECT * FROM purchases";
        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };
        return jdbc.query(sql, purchaseRowMapper);
    }
}
