package steps.bookingSteps;

import endpoints.get.Booking;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;
import context.TestContext;

public class BookingSteps {
    private TestContext testContext;
    private Booking booking;

    public BookingSteps(TestContext testContext) {
        this.testContext = testContext;
        booking = new Booking();
    }

    @Given("User get an list of booking")
    public void sentLoginRequest() {
        Response response = booking.bookingRequest();
        testContext.setResponseHandler(response);
    }

    @Then("The login response should be 200")
    public void userGetToken() {
        int statusCode = testContext.getResponseHandler().getResponse().getStatusCode();
        Assert.assertEquals(statusCode, 200);
//        String result = testContext.getResponseHandler().getBodyNodeValue("token");
//        System.out.println(result);
//        Assert.assertNotNull(result);
//        Token token = LibraryManager.getInstance().getApiJsonUtils().deserializeClass(testContext.getResponseHandler().getResponse(), Token.class);
//        System.out.println("deserialization");
//        System.out.println(token.getToken());
    }

    @Then("The booking id should be a number")
    public void checkBookingId() {

    }

    @Then("It only return booking id information")
    public void checkBookingIdNo() {

    }
}