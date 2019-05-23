package kea.botxo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.Model.Customer;
import kea.botxo.Repository.ReCustomer;

import java.util.List;

@Service
public class SeCustomer {

    @Autowired
    ReCustomer reCustomer;

    public List<Customer> fetchAll(){
        return reCustomer.fetchAll();
    }
}
