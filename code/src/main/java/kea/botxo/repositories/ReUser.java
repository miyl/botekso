package kea.botxo.repositories;

import org.springframework.stereotype.Repository;
import kea.botxo.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * The User Repository
 */
@Repository
public class ReUser {

    @Autowired
    JdbcTemplate template;

    /**
     * Used to fetch a single User from database
     * @author Tariq
     * @param name Works as an ID in order to fetch a specific User
     * @return A specific User
     */
    public User fetch(String name) {

        String sql = "SELECT * FROM frontend_users WHERE name=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return template.queryForObject(sql, rowMapper, name);
    }

    /**
     * Used to fetch all users from database
     * @author Tariq
     * @return A list of all Users
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
     * Used to update User information in the database
     * @author Tariq
     * @param user The desired User to be updated
     * @return Returns a list with the updated User on
     */
    public boolean update(User user) {
        //String sql = "INSERT INTO users WHERE name=?";
        //int updateResult = template.update(sql, name,)
        return true;
    }

    /**
     * Used to delete User from Database
     * @author Tariq
     * @param name Name of the User in the Database to be deleted.
     * @return Return the list of Users when completed
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
     * Used to add new users to the database
     * @author Tariq
     * @param user User to be added to the database.
     * @return Returns a list with the added User
     */
    public boolean add(User user) {
        String sql = "INSERT INTO frontend_users (name, password, access_level) VALUES (?, ?, ?)";
        return ( template.update(sql, user.getName(), user.getPassword(), user.getAccessLevel() ) != 0 );
    }

}
