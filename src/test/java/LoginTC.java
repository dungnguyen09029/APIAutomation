import data.GlobalVariables;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import requestBody.Login;
import responseBody.User;

public class LoginTC {

    @Test
    public void loginSuccessful()
    {
        RestAssured.baseURI = GlobalVariables.BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        Login login = new Login("eve.holt@reqres.in", "cityslicka");
        request.body(login);
        Response response = request.post("/api/login");
        User user = response.getBody().as(User.class);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        String token = (String) user.getToken();
        System.out.println(token);
    }
}
