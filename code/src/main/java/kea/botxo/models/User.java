package kea.botxo.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Class that handles Users
 * @author Tariq, Andreas
 */
public class User {

    @NotNull
    @Size(min=1, max=60)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String name;

    @NotNull
    @Size(min=8, max=255)
    private String password;

    //Hvordan håndterer vi Access Level?
    private int accessLevel;

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

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

}
