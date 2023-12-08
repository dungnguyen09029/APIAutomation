package stepDefinitions;

import apiEngine.endPoints.Booking;
import apiEngine.endPoints.IRestResponse;
import apiEngine.model.requests.BookInformation;
import apiEngine.model.requests.Bookingdates;
import apiEngine.model.responses.Book;
import apiEngine.model.responses.ListBookId;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingSteps extends BaseSteps {

    private final Booking booking;

    public BookingSteps(TestContext testContext) {
        super(testContext);
        booking = testContext.getRequestManager().getBooking();
    }

    @Given("User get an list of booking")
    public void getListBooking() {
        IRestResponse<ListBookId> listBookIdIRestResponse = booking.bookingRequest();
        testContext.setRestResponse(listBookIdIRestResponse);
    }

    @Then("The booking id should be a number")
    public void checkBookingId() {
        ListBookId bookingId = (ListBookId)testContext.getRestResponse().getBody();
        getAssertUtils().assertTrue(bookingId.listBookId.get(0) != null);
    }

    @Then("It only return booking id information")
    public void checkBookingIdNo() {

    }

    @When("User create a new booking")
    public void createNewDefaultBooking() {
        Bookingdates bookingdates = new Bookingdates("2018-01-01", "2019-01-01");
        BookInformation bookInformation = new BookInformation("Jim", "Brown", 111, true,
                bookingdates, "Breakfast");
        IRestResponse<Book> restResponse = booking.createBookingRequest(bookInformation);
        testContext.setRestResponse(restResponse);
        getScenarioContext().setContext(Context.BOOK_INFORMATION, bookInformation);
    }

    @Then("Verify book information is returned in response")
    public void verifyCreateBooking() {
        Book book = (Book) testContext.getRestResponse().getBody();
        getAssertUtils().assertTrue(book.booking.equals(getScenarioContext().getContext(Context.BOOK_INFORMATION)));
    }

    @Then("Verify returned booking id is a number")
    public void verifyBookIdIsNumber() {
        Book book = (Book) testContext.getRestResponse().getBody();
        getAssertUtils().assertTrue(book.bookingid != null);
    }
}