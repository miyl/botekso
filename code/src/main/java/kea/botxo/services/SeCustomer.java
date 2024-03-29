package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import kea.botxo.models.Customer;
import kea.botxo.repositories.ReCustomer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The service layer for Customers
 */
@Service
public class SeCustomer {

    @Autowired
    ReCustomer reCustomer;

    /**
     * Fetches a specific Customer given by its ID (name) from the database, via the repository layer
     * @param name The name of the Customer to retrieve
     * @return The requested Customer
     */
    public Customer fetch(String name) {
      return reCustomer.fetch(name);
    }

    /**
     * Fetches a list of all Customers from the database, via the repository layer
     * @return The  list of all Customers
     */
    public List<Customer> fetchAll(){
        return reCustomer.fetchAll();
    }

  /**
   * Fetches a list of all Customer names via repository
   * @author Marcus
   * @return List of all Customer names
   */
  public List<String> fetchAllCustomerNames() {

    return fetchAll().stream().map(c -> c.getName()).collect(Collectors.toList());
  }


    /**
     * Updates a specific Customer in the database, via the repository layer
     * @param customer The Customer to update
     * @return True if at least one row was added, otherwise false
     */
    public boolean update(Customer customer) {
        return reCustomer.update(customer);
    }

    /**
     * Deletes a specific Customer from the database, via the repository layer
     * @param name The Customer to delete
     * @return True if at least one row was added, otherwise false
     */
    public boolean delete(String name) {
        return reCustomer.delete(name);
    }


    /**
     * Adds a new Customer to the database, via the repository layer
     * @param customer The Customer to add
     * @return True if at least one row was added, otherwise false
     */
    public boolean add(Customer customer) {
        return reCustomer.add(customer);
    }

}
