package kea.botxo.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kea.botxo.Model.AuthType;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReAuthType {

    JdbcTemplate template;

    public List<AuthType> fetchAll() {
      return new ArrayList<AuthType>();
    }

    public boolean delete(AuthType a) {
      return true;
    }

    public boolean add(AuthType a) {
      return true;
    }

}
