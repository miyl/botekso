package kea.botxo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import kea.botxo.models.ApiKey;

import java.util.List;
import java.util.Random;

@Repository
public class ReApiKey {

    @Autowired
    JdbcTemplate template;

    public List<ApiKey> fetchAllForCustomer(String customerName) {
        String sql = "SELECT * FROM api_keys WHERE customer_name = ?";
        RowMapper<ApiKey> rowMapper = new BeanPropertyRowMapper<>(ApiKey.class);
        return template.query(sql, rowMapper, customerName);
    }

    public List<ApiKey> fetchAll() {
        String sql = "SELECT * FROM api_keys";
        RowMapper<ApiKey> rowMapper = new BeanPropertyRowMapper<>(ApiKey.class);
        return template.query(sql, rowMapper);
    }

    public boolean generate(String customerName) {
        char[] possibleCharacters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','z',
                                        'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z',
                                        '0','1','2','3','4','5','6','7','8','9'};
        StringBuilder newApiKey = new StringBuilder();
        Random ran = new Random();
        for (int i = 0; i < 100; i++) {
            newApiKey.append(possibleCharacters[ran.nextInt(possibleCharacters.length)]);
        }
        String sql = "INSERT INTO api_keys (key, customer_name) VALUES (?, ?)";
        return (template.update(sql, newApiKey, customerName) != 0);
    }

    public boolean delete(String key) {
        String sql = "DELETE FROM api_keys WHERE `key` = ?";
        return (template.update(sql, key) != 0);
    }

    public ApiKey fetch(String key) {
        String sql = "SELECT * FROM api_keys WHERE `key` = ?";
        RowMapper<ApiKey> rowMapper = new BeanPropertyRowMapper<>(ApiKey.class);
        return template.queryForObject(sql, rowMapper, key);
    }

}
