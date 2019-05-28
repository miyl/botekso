package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.AuthType;
import kea.botxo.repositories.ReAuthType;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeAuthType {

    @Autowired
    ReAuthType reAuthType;

    public List<AuthType> fetchAll() {
      return new ArrayList<AuthType>();
    }

    public boolean delete(AuthType a) {
      return true;
    }

    public boolean add(AuthType a) {
      return true;
    }
  
}
