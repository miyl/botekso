package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.AuthType;
import kea.botxo.repositories.ReAuthType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The service layer for Auth Types
 */
@Service
public class SeAuthType {

    @Autowired
    ReAuthType reAuthType;

    /**
     * Fetches a list of all Auth Types from the database, via the repository layer
     * @author Marcus
     * @return The list of all Auth Types
     */
    public List<AuthType> fetchAll() {
      return reAuthType.fetchAll();
    }

  /**
   * Fetches a list of all Auth Type values via repository
   * @author Marcus
   * @return List of all Auth Type values
   */
  public List<String> fetchAllAuthTypeValues() {
    return reAuthType.fetchAll().stream().map(atv -> atv.getAuthType()).collect(Collectors.toList());
  }

    /**
     * Deletes a specific Auth Type from the database, via the repository layer
     * @author Marcus
     * @param a The Auth Type to delete
     * @return True if at least one row was deleted, otherwise false 
     */
    public boolean delete(String a) {
      return reAuthType.delete(a);
    }

    /**
     * Adds a new Auth Type to the database, via the repository layer
     * @author Marcus
     * @param a The AuthType to add
     * @return True if at least one row was added, otherwise false
     */
    public boolean add(AuthType a) {
      return reAuthType.add(a);
    }
  
}
