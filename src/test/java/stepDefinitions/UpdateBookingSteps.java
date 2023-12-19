package stepDefinitions;

import apiEngine.endPoints.IRestResponse;
import apiEngine.endPoints.request.UpdateBooking;
import apiEngine.model.requests.BookInformation;
import apiEngine.model.responses.Book;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateBookingSteps extends BaseSteps {

    private final UpdateBooking updateBooking;

    public UpdateBookingSteps(TestContext testContext) {
        super(testContext);
        updateBooking = testContext.getRequestManager().getUpdateBooking((String) getScenarioContext().getContext(Context.TOKEN));
    }

    @When("User update booking id that just created")
    public void updateBooking() {
        BookInformation bookInformation = getScenarioContext().getDataManager().getBookingTestData().getUpdateBookInformation();
        IRestResponse<BookInformation> restResponse = updateBooking.updateBooking(
                "" + getScenarioContext().getContext(Context.CREATE_BOOK_ID), bookInformation);
        testContext.setRestResponse(restResponse);
        getScenarioContext().setContext(Context.BOOK_INFORMATION, bookInformation);
    }

    @Then("Verify booking updated with correct information")
    public void verifyUpdateBooking() {
        BookInformation bookInformation = (BookInformation) testContext.getRestResponse().getBody();
        getAssertUtils().assertTrue(bookInformation.equals(getScenarioContext().getContext(Context.BOOK_INFORMATION)));
    }
}
