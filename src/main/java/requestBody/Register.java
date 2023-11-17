package requestBody;

import java.util.HashMap;
import java.util.Map;

public class Register {

    private String email;
    private String password;

    /**
     * No args constructor for use in serialization
     *
     */
    public Register() {
    }

    /**
     *
     * @param password
     * @param email
     */
    public Register(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}