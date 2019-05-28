package kea.botxo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kea.botxo.models.HttpRequestType;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReHttpRequestType {

    @Autowired
    JdbcTemplate template;

    public List<HttpRequestType> fetchAll() {

      String sql = "SELECT * FROM http_request_types";
      RowMapper<HttpRequestType> rowMapper = new BeanPropertyRowMapper<>(HttpRequestType.class);
      return template.query(sql, rowMapper);
    }

    public boolean delete(HttpRequestType h) {
      return true;
    }

    public boolean add(HttpRequestType h) {
      return true;
    }
  
}
