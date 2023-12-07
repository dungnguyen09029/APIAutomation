package stepDefinitions;

import apiEngine.model.requests.BookInformation;
import apiEngine.model.requests.Bookingdates;
import apiEngine.model.responses.Book;
import apiEngine.model.responses.ListBookId;
import context.TestContext;
import apiEngine.endpoint.Booking;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class BookingSteps {
    private TestContext testContext;
    private Booking booking;

    public BookingSteps(TestContext testContext) {
        this.testContext = testContext;
        booking = new Booking();
    }

    @Given("User get an list of booking")
    public void getListBooking() {
        Response response = booking.bookingRequest();
        testContext.setResponseHandler(response);
    }

    @Then("The booking id should be a number")
    public void checkBookingId() {
        ListBookId bookingId = testContext.getResponseHandler().getResponse().getBody().as(ListBookId.class);
        System.out.println(bookingId.bookingId);
    }

    @Then("It only return booking id information")
    public void checkBookingIdNo() {

    }

    @When("User create a new booking")
    public void createNewDefaultBooking() {
        Bookingdates bookingdates = new Bookingdates("2018-01-01", "2019-01-01");
        BookInformation bookInformation = new BookInformation("Jim", "Brown", 111, true,
                bookingdates, "Breakfast");
        Response response = booking.createBookingRequest(bookInformation);
        testContext.setResponseHandler(response);
    }

    @Then("Checking the response create booking is correct")
    public void checkCreateBooking() {
        Book book = testContext.getResponseHandler().getResponse().getBody().as(Book.class);
        System.out.println(book.bookingid);
    }
}