package kea.botxo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kea.botxo.models.AuthType;
import java.util.ArrayList;
import java.util.List;

/**
 * The repository (database connection) for Auth Types
 */
@Repository
public class ReAuthType {

    @Autowired
    JdbcTemplate template;

    /**
     * Fetches a list of all Auth Types from the database
     * @author Marcus
     * @return The list of all Auth Types
     */
    public List<AuthType> fetchAll() {

        String sql = "SELECT * FROM auth_types";
        RowMapper<AuthType> rowMapper = new BeanPropertyRowMapper<>(AuthType.class);
        return template.query(sql, rowMapper);
    }

    /**
     * Deletes a specific Auth Type from the database
     * @author Marcus
     * @param a The Auth Type to delete
     * @return True if at least one row was deleted, otherwise false
     */
    public boolean delete(String a) {
      String sql = "DELETE FROM auth_types WHERE auth_type=?";
      return ( template.update(sql, a) != 0 );
    }

    /**
     * Adds a new Auth Type to the database
     * @author Marcus
     * @param a The Auth Type to add
     * @return True if at least one row was added, otherwise false
     */
    public boolean add(AuthType a) {
      String sql = "INSERT INTO auth_types (auth_type) VALUES (?)";
      return ( template.update(sql, a.getAuthType() ) != 0 );
    }

}
