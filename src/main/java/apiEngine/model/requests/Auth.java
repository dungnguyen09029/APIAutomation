package apiEngine.model.requests;

public class Auth {

    public String username;
    public String password;

    /**
     * No args constructor for use in serialization
     *
     */
    public Auth() {
    }

    /**
     *
     * @param password
     * @param username
     */
    public Auth(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
}
