package kea.botxo.testserver.models;

/**
 * The structure of the response object sent back to the HTTP client making the request to this API
 */
public class Response {

    private String value;
    private String message;

    public Response(String value, String message) {
      this.value = value;
      this.message = message;
    }

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
        return "Response{" +
                "value='" + value + '\'' +
                ", message=" + message +
                '}';
    }
}
