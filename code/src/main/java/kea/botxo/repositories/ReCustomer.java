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
 * The repository (database connection) for Customers
 */
@Repository
public class ReCustomer {

    @Autowired
    JdbcTemplate template;

    /**
     * Fetches a specific Customer given by its ID (name) from the database
     * @author Andreas, Marcus, Tariq
     * @param name The name of the Customer to retrieve
     * @return The requested Customer
     */
    public Customer fetch(String name){

        String sql = "SELECT * FROM customers WHERE name=?";

        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.queryForObject(sql, rowMapper, name);
    }

    /**
     * Fetches a list of all Customers from the database
     * @author Andreas, Marcus, Tariq
     * @return The list of all Customers
     */
    public List<Customer> fetchAll(){


        String sql = "SELECT * FROM customers";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);

        ////dummy data
        //List<Customer> customerList = new ArrayList<>();

        //Customer customer1 = new Customer();
        //customer1.setEmail(   "hans@gmail.dk");
        //customer1.setName("Hans jensen");
        //customer1.setTel("23232323");

        //Customer customer2 = new Customer();
        //customer2.setTel("32323232");
        //customer2.setName("BenteOlsen");
        //customer2.setEmail("Bente@hotmail.com");

        //customerList.add(customer1);
        //customerList.add(customer2);
        //return customerList;

    }

    /**
     * Updates a specific Customer in the database
     * @author Andreas, Marcus, Tariq
     * @param customer The Customer to update
     * @return True if at least one row was added, otherwise false
     */
    public boolean update(Customer customer){
        return true;
    }

    /**
     * Deletes a specific Customer from the database
     * @author Tariq
     * @param name The Customer to delete
     * @return True if at least one row was added, otherwise false
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
     * Adds a new Customer to the database
     * @author Andreas, Marcus
     * @param c The Customer to add
     * @return True if at least one row was added, otherwise false
     */
    public boolean add(Customer c){
        String sql = "INSERT INTO customers (name, email, tel) VALUES (?, ?, ?)";
        return ( template.update(sql, c.getName(), c.getEmail(), c.getTel()  ) != 0 );
    }
}
