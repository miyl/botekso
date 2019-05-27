package kea.botxo.Model;

import javax.validation.constraints.*;

public class ApiKey {

    @NotNull
    @Size(min=100, max=100)
    private String key;
  
}
