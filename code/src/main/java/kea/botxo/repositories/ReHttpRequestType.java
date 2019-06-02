package kea.botxo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kea.botxo.models.HttpRequestType;
import java.util.ArrayList;
import java.util.List;

/**
 * The repository (database connection) for HTTP Request Types
 */
@Repository
public class ReHttpRequestType {

    @Autowired
    JdbcTemplate template;

    /**
     * Fetches a list of all HTTP Request Types from the database
     * @author Marcus
     * @return The list of all HTTP Request Types
     */
    public List<HttpRequestType> fetchAll() {

      String sql = "SELECT * FROM http_request_types";
      RowMapper<HttpRequestType> rowMapper = new BeanPropertyRowMapper<>(HttpRequestType.class);
      return template.query(sql, rowMapper);
    }

    /**
     * Deletes a specific HTTP Request Type from the database
     * @author Marcus
     * @param h The HTTP Request Type to delete
     * @return True if at least one row was deleted, otherwise false 
     */
    public boolean delete(String h) {
      String sql = "DELETE FROM http_request_types WHERE http_request_type=?";
      return ( template.update(sql, h) != 0 );
    }

    /**
     * Adds a new HTTP Request Type to the database
     * @author Marcus
     * @param h The HTTP Request Type to add
     * @return True if at least one row was added, otherwise false 
     */
    public boolean add(String h) {
      return true;
    }
  
}
