package kea.botxo.models;

import javax.validation.constraints.*;

/**
 * A model that handles the different possible authentication types the third party API could be expecting.
 */
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
