package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.HttpRequestType;
import kea.botxo.repositories.ReHttpRequestType;

import java.util.ArrayList;
import java.util.List;

/**
 * The service layer for Webhooks
 */
@Service
public class SeHttpRequestType {

    @Autowired
    ReHttpRequestType reHttpRequestType;

    /**
     * Fetches a list of all HTTP Request Types from the database, via the repository layer
     * @return The list of all HTTP Request Types
     */
    public List<HttpRequestType> fetchAll() {
      return reHttpRequestType.fetchAll();
    }

    /**
     * Deletes a specific HTTP Request Type from the database, via the repository layer
     * @param h The HTTP Request Type to Delete
     * @return True if at least one row was deleted, otherwise false 
     */
    public boolean delete(String h) {
      return reHttpRequestType.delete(h);
    }

    /**
     * Adds a new HTTP Request Type to the database, via the repository layer
     * @param h The HTTP Request Type to add
     * @return True if at least one row was added, otherwise false 
     */
    public boolean add(String h) {
      return reHttpRequestType.add(h);
    }
  
}
