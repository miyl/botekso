package kea.botxo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// If the server sends any JSON values not represented in this model, ignore them
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerResponse {

    private String value;
    private String message;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "value='" + value + '\'' +
                ", message=" + message +
                '}';
    }
}
