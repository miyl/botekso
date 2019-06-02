package kea.botxo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import kea.botxo.models.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 * Customer Repository
 * @Author Andreas, Marcus & Tariq
 */
@Repository
public class ReCustomer {

    @Autowired
    JdbcTemplate template;

    /**
     * @Author Andreas
     * @param name The desired Customer to be fetched from the Database
     * @return The desired Customer
     */
    public Customer fetch(String name){

        String sql = "SELECT * FROM customers WHERE name=?";

        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.queryForObject(sql, rowMapper, name);
    }

    /**
     * @Andreas
     * @return An arraylist of all Customers fetched from the Database
     */
    public List<Customer> fetchAll(){


        String sql = "SELECT * FROM customers";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }

    /**
     * @Authr Andreas
     * @param customer The desired customer to be updated
     * @return The updated customer in a list of Customers
     */
    public boolean update(Customer customer){
        return true;
    }

    /**
     * @Author Tariq & Marcus
     * @param name The Customer to be deleted from the database
     * @return A list of Customers with the specific Customer deleted
     */
    public boolean delete(String name) {
        String sql = "DELETE FROM customers WHERE name=?";
        int result = template.update(sql, name);

        if(result == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * @Author Andreas
     * @param customer ID of customer to be added
     * @return A list with the newly added Customer
     */
    public boolean add(Customer customer){
        return true;
    }
}
