package stepDefinitions;

import apiEngine.Booking;
import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.model.requests.BookInformation;
import apiEngine.model.requests.Bookingdates;
import apiEngine.model.responses.Book;
import apiEngine.model.responses.ListBookId;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingSteps {
    private TestContext testContext;
    private Booking booking;

    public BookingSteps(TestContext testContext) {
        this.testContext = testContext;
        booking = new Booking();
    }

    @Given("User get an list of booking")
    public void getListBooking() {
        IRestResponse<ListBookId> restResponse = booking.bookingRequest();
        testContext.setRestResponse((RestResponse) restResponse);
    }

    @Then("The booking id should be a number")
    public void checkBookingId() {
        ListBookId bookingId = (ListBookId)testContext.getRestResponse().getBody();
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
        RestResponse restResponse = (RestResponse) booking.createBookingRequest(bookInformation);
        testContext.setRestResponse(restResponse);
    }

    @Then("Checking the response create booking is correct")
    public void checkCreateBooking() {
        Book book = testContext.getRestResponse().getResponse().getBody().as(Book.class);
        System.out.println(book.bookingid);
    }
}