package kea.botxo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kea.botxo.models.AuthType;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReAuthType {

    JdbcTemplate template;

    public List<AuthType> fetchAll() {
        String sql = "SELECT * FROM auth_types";
        RowMapper<AuthType> rowMapper = new BeanPropertyRowMapper<>(AuthType.class);
        return template.query(sql, rowMapper);
    }

    public boolean delete(AuthType a) {
      return true;
    }

    public boolean add(AuthType a) {
      return true;
    }

}
