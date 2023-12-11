package stepDefinitions;

import apiEngine.endPoints.Booking;
import apiEngine.endPoints.IRestResponse;
import apiEngine.model.requests.BookInformation;
import apiEngine.model.responses.Book;
import apiEngine.model.responses.ListBookId;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Log;

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

    @When("User create a new booking")
    public void createNewDefaultBooking() {
        BookInformation bookInformation = getScenarioContext().getTestDataManager().getBookInformationDataTestData().getBookInformation();
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

    @When("The message is {string}")
    public void testMessage(String mess) {
        Log.logInfo("The test message is: " + mess);
    }
}