package kea.botxo.models;

import javax.validation.constraints.*;

public class AuthType {

    @NotNull
    @Size(min=1, max=30)
    private String authType;

    public String getAuthType() {
      return authType;
    }

    public void setAuthType(String authType) {
      this.authType = authType;
    }
  
}
