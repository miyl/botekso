package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.ApiKey;
import kea.botxo.repositories.ReApiKey;

import java.util.List;

/**
 * Service for API-keys
 * @author Esben
 */
@Service
public class SeApiKey {

  @Autowired
  ReApiKey reapikey;

  /**
   * Lists all API-Keys for a specific customer via. repository
   * @author Esben
   * @param customerName The customer whose API-Keys are to be fetched
   * @return ArrayList of API-Keys for a specific customer
   */
  public List<ApiKey> fetchAllForCustomer(String customerName) {
    return reapikey.fetchAllForCustomer(customerName);
  }

  /**
   * Lists all API-Keys via repository
   * @author Esben
   * @return ArrayList of all API-Keys
   */
  public List<ApiKey> fetchAll() {
    return reapikey.fetchAll();
  }

  /**
   * Creates an API-Key for a specific customer via repository
   * @author Esben
   * @param customerName The name of the customer for whom the key belongs
   * @return Number of rows changed in database: 0 or 1
   */
  public boolean generate(String customerName) {
    return reapikey.generate(customerName);
  }

  /**
   * Deletes API-Key via repository
   * @author Esben
   * @param key The key to be deleted
   * @return Number of rows changed in database: 0 or 1
   */
  public boolean delete(String key) {
    return reapikey.delete(key);
  }

  /**
   * Lists a specific API-Key via repository
   * @author Esben
   * @param key The key to be retrieved
   * @return The desired API-Key object
   */
  public ApiKey fetch(String key) {
    return reapikey.fetch(key);
  }

}
