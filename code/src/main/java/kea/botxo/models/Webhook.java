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
    private int respOnSuccess;

    @NotNull
    @Min(1)
    @Max(9999)
    private int respOnError;


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

    public int getRespOnSuccess() {
        return respOnSuccess;
    }

    public void setRespOnSuccess(int respOnSuccess) {
        this.respOnSuccess = respOnSuccess;
    }

    public int getRespOnError() {
        return respOnError;
    }

    public void setRespOnError(int respOnError) {
        this.respOnError = respOnError;
    }
}
