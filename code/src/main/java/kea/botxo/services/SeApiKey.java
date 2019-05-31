package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.ApiKey;
import kea.botxo.repositories.ReApiKey;

import java.util.List;

@Service
public class SeApiKey {

  @Autowired
  ReApiKey reapikey;

  public List<ApiKey> fetchAllForCustomer(String customerName) {
    return reapikey.fetchAllForCustomer(customerName);
  }

  public List<ApiKey> fetchAll() {
    return reapikey.fetchAll();
  }

  public boolean generate(String customerName) {
    return reapikey.generate(customerName);
  }

  public boolean delete(String key) {
    return reapikey.delete(key);
  }

  public ApiKey fetch(String key) {
    return reapikey.fetch(key);
  }

}