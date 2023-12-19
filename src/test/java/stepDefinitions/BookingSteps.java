package stepDefinitions;

import apiEngine.endPoints.request.Booking;
import apiEngine.endPoints.IRestResponse;
import apiEngine.model.requests.BookInformation;
import apiEngine.model.responses.Book;
import apiEngine.model.responses.BookingId;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.And;
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

    @Given("User get a list of booking")
    public void getListBooking() {
        IRestResponse<BookingId[]> listBookIdIRestResponse = booking.bookingRequest();
        testContext.setRestResponse(listBookIdIRestResponse);
    }

    @Then("The booking id should be a number")
    public void checkBookingId() {
        BookingId[] bookingId = (BookingId[])testContext.getRestResponse().getBody();
        getAssertUtils().assertTrue(bookingId[0] != null);
    }

    @When("User create a new booking")
    public void createNewDefaultBooking() {
        BookInformation bookInformation = getScenarioContext().getDataManager().getBookingTestData().getBookInformation();
        IRestResponse<Book> restResponse = booking.createBookingRequest(bookInformation);
        testContext.setRestResponse(restResponse);
        getScenarioContext().setContext(Context.BOOK_INFORMATION, bookInformation);
    }

    @When("User create a new booking with {string} is {string}")
    @When("User create a new booking with {string} is {int}")
    public <T> void createBookingWithFieldValue(String field, T value) {
        String bookInformation = testContext.getLibraryManager().getApiJsonUtils().changeJsonFields(
                getScenarioContext().getDataManager().getBookingTestData().getBookInformation(), field, value);
        IRestResponse<Book> restResponse = booking.createBookingRequest(bookInformation);
        testContext.setRestResponse(restResponse);
        getScenarioContext().setContext(Context.BOOK_INFORMATION, bookInformation);
    }

    @Then("Verify booking created with correct information")
    public void verifyCreateBooking() {
        Book book = (Book) testContext.getRestResponse().getBody();
        getAssertUtils().assertTrue(book.booking.equals(getScenarioContext().getContext(Context.BOOK_INFORMATION)));
    }

    @Then("Verify specific book information is returned correctly")
    public void verifySpecificBooking() {
        BookInformation bookInformation = (BookInformation) testContext.getRestResponse().getBody();
        getAssertUtils().assertTrue(bookInformation.firstName != null);
        getAssertUtils().assertTrue(bookInformation.lastname != null);
        getAssertUtils().assertTrue(bookInformation.depositpaid != null);
        getAssertUtils().assertTrue(bookInformation.totalprice != -1);
        getAssertUtils().assertTrue(bookInformation.additionalneeds != null);
        getAssertUtils().assertTrue(bookInformation.bookingdates.checkin != null);
        getAssertUtils().assertTrue(bookInformation.bookingdates.checkout != null);
    }

    @Then("Verify returned booking id is a number")
    public void  verifyBookIdIsNumber() {
        Book book = (Book) testContext.getRestResponse().getBody();
        getAssertUtils().assertTrue(book.bookingid != null);
    }

    @When("The message is {string}")
    public void testMessage(String mess) {
        Log.logInfo("The test message is: " + mess);
    }

    @When("The parameter is {process}")
    public void testProcess(String process) {
        Log.logInfo("The process is: " + process);
    }

    @And("User save the booking Id at {int}")
    public void saveFirstBookingId(int number) {
        BookingId[] bookingId = (BookingId[]) testContext.getRestResponse().getBody();
        getScenarioContext().setContext(Context.BOOK_ID, bookingId[number].bookingid);
    }

    @And("User sent data to get specific booking information")
    public void getSpecificBookingInformationFromScenarioContext() {
        int id = (int) getScenarioContext().getContext(Context.BOOK_ID);
        IRestResponse<BookInformation> restResponse = booking.SpecificBookingRequest(Integer.toString(id));
        testContext.setRestResponse(restResponse);
    }

    @And("User get specific booking information with id {string}")
    public void getSpecificBookingInformationWithId(String Id) {
        IRestResponse<BookInformation> restResponse = booking.SpecificBookingRequest(Id);
        testContext.setRestResponse(restResponse);
    }

    @And("User save created booking Id")
    public void saveCreatedBookingId() {
        Book book = (Book) testContext.getRestResponse().getBody();
        getScenarioContext().setContext(Context.CREATE_BOOK_ID, book.bookingid);
    }
}