package testData;

import apiEngine.model.requests.Auth;

public class Authentication {

    public Auth getAdminAuthentication() {
        return new Auth("admin", "password123");
    }
}
