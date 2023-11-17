package requestBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login {

    private Object email;
    private Object password;

    public Login(Object email, Object password) {
        this.email = email;
        this.password = password;
    }
}
