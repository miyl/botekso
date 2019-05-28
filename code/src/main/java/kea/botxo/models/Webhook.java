package kea.botxo.models;

import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.*;

public class Webhook {

    /**
     * Noter.
     * Husk Getters / setters ellers vil det ikke virke.
     *
     * Overvej om vi skal fjerne "Not Null" når der er en size på?
     * dokumentet skal opdateres
     * Hvis der KUN er Not Null på så kan man af en eller anden årsag godt add form
     *
     *
     * */

    @NotNull
    @Size(min=1, max=100)
    @Pattern(regexp="^[A-Za-z 0-9]*$")
    private String name;

    //@Pattern(regexp = "^https?:\\/\\/.{3,}") fixet med @URL fra nyt constraintbibliotek?

    @URL
    @NotNull
    @Size(min=3)
    private String url;

    //måske skal der enables multiline mode på body??
    //https://docs.oracle.com/javaee/6/api/javax/validation/constraints/Pattern.Flag.html
    @NotNull
    @Size(min=3)
    private String body;

    @NotNull
    @Min(1)
    @Max(9999)
    private int responseOnSuccess;

    @NotNull
    @Min(1)
    @Max(9999)
    private int responseOnError;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getResponseOnSuccess() {
        return responseOnSuccess;
    }

    public void setResponseOnSuccess(int responseOnSuccess) {
        this.responseOnSuccess = responseOnSuccess;
    }

    public int getResponseOnError() {
        return responseOnError;
    }

    public void setResponseOnError(int responseOnError) {
        this.responseOnError = responseOnError;
    }
}
