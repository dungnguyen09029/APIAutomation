import data.GlobalVariables;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import responseBody.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import requestBody.Register;

public class SamplePOSTRequest {

    @Test
    public void RegistrationSuccessful()
    {
        RestAssured.baseURI = GlobalVariables.BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        Register register = new Register("eve.holt@reqres.in", "pistol");
        request.body(register);
        Response response = request.post("/api/users");
        User user = response.getBody().as(User.class);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
        String successCode = response.jsonPath().get("id");
        Assert.assertTrue(Integer.parseInt(successCode) > 0);
    }
}
