package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import kea.botxo.models.Customer;
import kea.botxo.repositories.ReCustomer;

import java.util.List;

/**
 *
 */
@Service
public class SeCustomer {

    @Autowired
    ReCustomer reCustomer;

    /**
     *
     * @return
     */
    public List<Customer> fetchAll(){
        return reCustomer.fetchAll();
    }

    /**
     *
     * @param name
     * @return
     */
    public Customer fetch(String name) {
      return reCustomer.fetch(name);
    }

    /**
     *
     * @param customer
     */
    public void addCustomer(Customer customer) {
        reCustomer.add(customer);
    }

    /**
     *
     * @param customer
     */
    public void update(Customer customer) {
        reCustomer.update(customer);
    }

    /**
     *
     * @param name
     */
    public void delete(String name) {
        reCustomer.delete(name);
    }



}
