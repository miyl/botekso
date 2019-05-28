package kea.botxo.models;

import javax.validation.constraints.*;

public class HttpRequestType {

    @NotNull
    @Size(min=1, max=30)
    private String httpRequestType;

    public String getHttpRequestType() {
      return httpRequestType;
    }

    public void setHttpRequestType(String httpRequestType) {
      this.httpRequestType = httpRequestType;
    }
  
}
