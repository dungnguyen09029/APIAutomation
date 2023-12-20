package stepDefinitions;

import apiEngine.endPoints.RestResponse;
import apiEngine.endPoints.request.DeleteBooking;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.When;

public class DeleteBookingSteps extends BaseSteps {

    private final DeleteBooking deleteBooking;

    public DeleteBookingSteps(TestContext testContext) {
        super(testContext);
        deleteBooking = testContext.getRequestManager().getDeleteBooking((String) getScenarioContext().getContext(Context.TOKEN));
    }

    @When("User sent delete booking request for previous created booking")
    public void deletePreviousCreatedBooking() {
        RestResponse restResponse = deleteBooking.deleteBooking(getLibraryManager().getStringUtils().getStringFromObject(
                getScenarioContext().getContext(Context.BOOK_ID)));
        testContext.setRestResponse(restResponse);
    }
}
