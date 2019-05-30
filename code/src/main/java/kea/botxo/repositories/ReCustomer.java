package kea.botxo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import kea.botxo.models.Customer;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReCustomer {

    @Autowired
    JdbcTemplate template;

    public Customer fetch(String name){

        String sql = "SELECT * FROM customers WHERE name=?";

        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.queryForObject(sql, rowMapper, name);
    }

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
