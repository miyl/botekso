package kea.botxo.Repository;

import org.springframework.stereotype.Repository;
import kea.botxo.Model.Customer;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReCustomer {

    public ReCustomer(){}

    public Customer fetch(){
        //dummy data
        Customer customer = new Customer();
        return customer;
    }

    public List<Customer> fetchAll(){

        //dummy data
        List<Customer> customerList = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setEmail("hans@gmail.dk");
        customer1.setName("Hans jensen");
        customer1.setTel("23232323");

        Customer customer2 = new Customer();
        customer2.setTel("32323232");
        customer2.setName("Bente Olsen");
        customer2.setEmail("Bente@hotmail.com");

        customerList.add(customer1);
        customerList.add(customer2);
        return customerList;

    }
}
