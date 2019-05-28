package kea.botxo.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    @NotNull
    @Size(min=1, max=60)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String name;

    @NotNull
    @Size(min=8, max=255)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
