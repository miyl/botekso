package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.ApiKey;
import kea.botxo.repositories.ReApiKey;

import kea.botxo.models.Customer; // Delete this if we decide on just storing the Customer PK here instead.

import java.util.List;
import java.util.ArrayList;

@Service
public class SeApiKey {

  public List<ApiKey> getKeysForCustomer(Customer c) {
    // TODO: Call the repo, and fetch all the customers for that key from the repo
    // Not sure if it's best it takes a Customer or the Customer's primary key: The Customer name?
    return new ArrayList<ApiKey>();
  }
  
}
