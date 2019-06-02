package kea.botxo.models;

import javax.validation.constraints.*;

/**
 * API-Key klasse
 * @Author Esben
 */
public class ApiKey {

    @NotNull
    @Size(min=100, max=100)
    private String key;

    private String customerName;


    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    public String getCustomerName() {
      return customerName;
    }

    public void setCustomerName(String customerName) {
      this.customerName = customerName;
    }

}