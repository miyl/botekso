package kea.botxo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import kea.botxo.models.ApiKey;

import java.util.List;
import java.util.Random;

/**
 * Repository for API-Keys
 * @author Esben
 */
@Repository
public class ReApiKey {

    @Autowired
    JdbcTemplate template;

    /**
     * Lists all API-Keys for a specific customer
     * @author Esben
     * @param customerName The customer whose API-Keys are to be fetched
     * @return A list of API-Keys for a specific customer
     */
    public List<ApiKey> fetchAllForCustomer(String customerName) {
        String sql = "SELECT * FROM api_keys WHERE customer_name = ?";
        RowMapper<ApiKey> rowMapper = new BeanPropertyRowMapper<>(ApiKey.class);
        return template.query(sql, rowMapper, customerName);
    }

    /**
     * Lists all API-Keys
     * @author Esben
     * @return A list of all API-Keys
     */
    public List<ApiKey> fetchAll() {
        String sql = "SELECT * FROM api_keys";
        RowMapper<ApiKey> rowMapper = new BeanPropertyRowMapper<>(ApiKey.class);
        return template.query(sql, rowMapper);
    }

    /**
     * Generates a new API-Key for a specific customer. The API-Key contains 100 random characters (upper/lowercase alphabet and 0-9)
     * @author Esben
     * @param customerName The customer who will be the owner of the API-Key
     * @return Number of rows changed in database: 0 or 1
     */
    public boolean generate(String customerName) {
        char[] possibleCharacters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','z',
                                        'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z',
                                        '0','1','2','3','4','5','6','7','8','9'};
        StringBuilder newApiKey = new StringBuilder();
        Random ran = new Random();
        for (int i = 0; i < 100; i++) {
            newApiKey.append(possibleCharacters[ran.nextInt(possibleCharacters.length)]);
        }
        String sql = "INSERT INTO api_keys (`key`, customer_name) VALUES (?, ?)";
        return (template.update(sql, newApiKey, customerName) != 0);
    }

    /**
     * Deletes a specific API-Key
     * @author Esben
     * @param key The desired API-Key to be deleted
     * @return Number of rows changed in database: 0 or 1
     */
    public boolean delete(String key) {
        String sql = "DELETE FROM api_keys WHERE `key` = ?";
        return (template.update(sql, key) != 0);
    }

    /**
     * Fetches a specific API-Key
     * @author Esben
     * @param key The desired API-Key
     * @return API-Key object
     */
    public ApiKey fetch(String key) {
        String sql = "SELECT * FROM api_keys WHERE `key` = ?";
        RowMapper<ApiKey> rowMapper = new BeanPropertyRowMapper<>(ApiKey.class);
        return template.queryForObject(sql, rowMapper, key);
    }

}
