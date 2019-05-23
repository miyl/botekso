package kea.botxo.Repository;

import org.springframework.stereotype.Repository;
import kea.botxo.Model.Customer;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReCustomer {

    public ReCustomer(){}

    public Customer fetch(String name){
        //dummy data
        Customer customer = new Customer();
        customer.setName("Hans Grethe");
        customer.setEmail("Jajaj@kds.dk");
        customer.setTel("23232323");
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

    public boolean update(Customer customer){
        return true;
    }

    public boolean delete(String name) {
        return true;
    }

    public boolean add(Customer customer){
        return true;
    }
}
