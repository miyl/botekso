package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import kea.botxo.models.Customer;
import kea.botxo.repositories.ReCustomer;

import java.util.List;

/**
 * Customer Service
 * @Author Andreas
 */
@Service
public class SeCustomer {

    @Autowired
    ReCustomer reCustomer;

    /**
     * @Author Andreas
     * @return Returns an Arraylist of the Customers
     */
    public List<Customer> fetchAll(){
        return reCustomer.fetchAll();
    }

    /**
     * @Author Andreas
     * @param name ID of the customer to be fetched from the database
     * @return The desired customer
     */
    public Customer fetch(String name) {
      return reCustomer.fetch(name);
    }

    /**
     * @Author Andreas
     * @param customer The Customer to be added
     * @Return Returns a list of Customers with the newly added Customer
     */
    public void addCustomer(Customer customer) {
        reCustomer.add(customer);
    }

    /**
     * @Author Andreas
     * @param customer The desired Customer to be updated
     * @Return The updated Customer on a list of Customers
     */
    public void update(Customer customer) {
        reCustomer.update(customer);
    }

    /**
     * @Author Andreas
     * @param name The desired Customer to be deleted
     * @Return A list of Customers in which the desired Customer is removed
     */
    public void delete(String name) {
        reCustomer.delete(name);
    }



}
