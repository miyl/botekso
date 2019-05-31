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
      return reAuthType.fetchAll();
    }

    public boolean delete(String a) {
      return reAuthType.delete(a);
    }

    public boolean add(String a) {
      return reAuthType.add(a);
    }
  
}
