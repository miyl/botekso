package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import kea.botxo.models.Customer;
import kea.botxo.repositories.ReCustomer;

import java.util.List;

@Service
public class SeCustomer {

    @Autowired
    ReCustomer reCustomer;

    public List<Customer> fetchAll(){
        return reCustomer.fetchAll();
    }
}
