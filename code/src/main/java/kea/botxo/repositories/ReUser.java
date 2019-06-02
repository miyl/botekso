package kea.botxo.repositories;

import org.springframework.stereotype.Repository;
import kea.botxo.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 */
@Repository
public class ReUser {

    @Autowired
    JdbcTemplate template;

    /**
     *
     * @param name
     * @return
     */
    public User fetch(String name) {

        String sql = "SELECT * FROM frontend_users WHERE name=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return template.queryForObject(sql, rowMapper, name);
    }

    /**
     *
     * @return
     */
    public List<User> fetchAll() {

        //Query som vælger alt fra tabellen 'frontend_users'
        String sql = "SELECT * FROM frontend_users";
        //Rækker i SQL-queryen til liste af User
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        //Kører SQL-query
        return template.query(sql, rowMapper);
    }

    /**
     *
     * @param user
     * @return
     */
    public boolean update(User user) {
        //String sql = "INSERT INTO users WHERE name=?";
        //int updateResult = template.update(sql, name,)
        return true;
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean delete(String name) {
        String sql = "DELETE FROM frontend_users WHERE name=?";
        int result = template.update(sql, name);

        if(result == 0) {
            return false;
        }
        else {
            return true;
        }

    }

    /**
     *
     * @param user
     * @return
     */
    public boolean add(User user) {
        return true;
    }

}
