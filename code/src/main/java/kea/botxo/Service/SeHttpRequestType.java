package kea.botxo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.Model.HttpRequestType;
import kea.botxo.Repository.ReHttpRequestType;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeHttpRequestType {

    @Autowired
    ReHttpRequestType reHttpRequestType;

    public List<HttpRequestType> fetchAll() {
      return new ArrayList<HttpRequestType>();
    }

    public boolean delete(HttpRequestType h) {
      return true;
    }

    public boolean add(HttpRequestType h) {
      return true;
    }
  
}
