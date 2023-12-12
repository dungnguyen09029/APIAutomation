package suite;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import stepDefinitions.BookingSteps;
import stepDefinitions.GeneralSteps;

public class CreateBooking extends BaseTest {

    private BookingSteps bookingSteps;
    private GeneralSteps generalSteps;

    @BeforeTest
    public void setUpCreateBookingSuite() {
        bookingSteps = new BookingSteps(testContext);
        generalSteps = new GeneralSteps(testContext);
        bookingSteps.createNewDefaultBooking();
    }

    @Test(priority = 1)
    public void testcase001() {
        generalSteps.verifyResponseCode(200);
    }

    @Test(priority = 2)
    public void testcase002() {
        bookingSteps.verifyCreateBooking();
    }

    @Test(priority = 3)
    public void testcase003() {
        bookingSteps.verifyBookIdIsNumber();
    }
}
