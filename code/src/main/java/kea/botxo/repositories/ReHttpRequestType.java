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

    JdbcTemplate template;

    public List<HttpRequestType> fetchAll() {
      return new ArrayList<HttpRequestType>();
    }

    public boolean delete(HttpRequestType h) {
      return true;
    }

    public boolean add(HttpRequestType h) {
      return true;
    }
  
}
