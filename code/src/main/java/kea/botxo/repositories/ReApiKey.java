package kea.botxo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import kea.botxo.models.ApiKey;

import java.util.List;

@Repository
public class ReApiKey {

    @Autowired
    JdbcTemplate template;

    public List<ApiKey> fetchAllApiKeys() {
        String sql = "SELECT * FROM api_keys";
        RowMapper<ApiKey> rowMapper = new BeanPropertyRowMapper<>(ApiKey.class);
        return template.query(sql, rowMapper);
    }

    public void addApiKey(ApiKey apikey) {
        String sql = "INSERT INTO api_keys (key customer) VALUES (?, ?)";
        template.update(sql, apikey.getKey(), apikey.getCustomer());
    }

    public void deleteApiKey(ApiKey apikey) {
        String sql = "DELETE FROM api_key WHERE key = ?";
        template.update(sql, apikey.getKey());
    }

    public ApiKey findApiKey(ApiKey apikey) {
        String sql = "SELECT * FROM api_key WHERE key = ?";
        RowMapper<ApiKey> rowMapper = new BeanPropertyRowMapper<>(ApiKey.class);
        return template.queryForObject(sql, rowMapper, apikey.getKey());
    }

}