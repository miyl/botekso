package kea.botxo.models;

import javax.validation.constraints.*;

/**
 *
 */
public class ApiKey {

    @NotNull
    @Size(min=100, max=100)
    private String key;

    // Thoughts: Should it store a Customer, or the Customer's primary key: its name?
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