package stepDefinitions;

import apiEngine.endPoints.IRestResponse;
import apiEngine.endPoints.request.UpdateBooking;
import apiEngine.model.requests.BookInformation;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

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
                "" + getScenarioContext().getContext(Context.BOOK_ID), bookInformation);
        testContext.setRestResponse(restResponse);
        getScenarioContext().setContext(Context.BOOK_INFORMATION, bookInformation);
    }

    @Then("Verify booking updated with correct information")
    public void verifyUpdateBooking() {
        BookInformation bookInformation = (BookInformation) testContext.getRestResponse().getBody();
        getAssertUtils().assertTrue(bookInformation.equals(getScenarioContext().getContext(Context.BOOK_INFORMATION)));
    }

    @When("User want to update those information")
    public void updatePartialBooking(Map<String, Object> dataTable) {
        IRestResponse<BookInformation> restResponse = updateBooking.partialUpdateBooking(
                "" + getScenarioContext().getContext(Context.BOOK_ID), dataTable);
        testContext.setRestResponse(restResponse);
        getScenarioContext().setContext(Context.BOOK_INFORMATION_PARTIAL_UPDATE, dataTable);
    }

    @And("Verify partial update successfully")
    public <T> void verifyPartialUpdate() {
        BookInformation bookInformation = (BookInformation) getScenarioContext().getContext(Context.BOOK_INFORMATION);
        Map<String, Object> partial = (Map<String, Object>) getScenarioContext().getContext(Context.BOOK_INFORMATION_PARTIAL_UPDATE);
        for (Map.Entry<String, Object> entry : partial.entrySet()) {
            switch (entry.getKey()) {
                case "firstname":
                    getAssertUtils().assertEquals(bookInformation.firstName, (String) entry.getValue());
                    break;
                case "lastname":
                    getAssertUtils().assertEquals(bookInformation.lastname, (String) entry.getValue());
                    break;
                default:
                    break;
            }
        }
    }
}
