package kea.botxo.models;

import javax.validation.constraints.*;

public class Customer {

    @NotNull
    @Size(min=1, max=60)
    @Pattern(regexp="^[A-Za-z 0-9]*$")
    private String name;

    @NotNull
    @Email
    @Size(min=3, max=60)
    private String email;

    @NotNull
    @Size(min=1, max=15)
    @Pattern(regexp="^[0-9]*$")
    private String tel;

    public Customer(String name, String email, String tel) {
      this.name = name;
      this.email = email;
      this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
