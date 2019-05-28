package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.HttpRequestType;
import kea.botxo.repositories.ReHttpRequestType;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeHttpRequestType {

    @Autowired
    ReHttpRequestType reHttpRequestType;

    public List<HttpRequestType> fetchAll() {
      return reHttpRequestType.fetchAll();
    }

    public boolean delete(HttpRequestType h) {
      return true;
    }

    public boolean add(HttpRequestType h) {
      return true;
    }
  
}
