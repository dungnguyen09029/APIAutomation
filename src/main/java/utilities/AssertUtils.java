package utilities;

import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//@Log4j
public class AssertUtils {

    private SoftAssert softAssertion;

    public AssertUtils() {
        softAssertion = new SoftAssert();
    }

    public SoftAssert getSoftAssertion() {
        return softAssertion;
    }

    public void assertEquals(String description, String actualValue, String expectedValue) {
//        log.info("Assert equals: " + description + " - actual Value: " + actualValue + " & expected Value: " + expectedValue);
        Assert.assertEquals(actualValue, expectedValue, description);
    }

    public void assertNotEquals(String description, String actualValue, String expectedValue) {
//        log.info("Assert equals: " + description + " - " + actualValue + " & expected Value: " + expectedValue);
        Assert.assertNotEquals(actualValue, expectedValue, description);
    }

    public void assertTrue(String description, boolean actualValue) {
//        log.info("Assert true: " + description + " - " + actualValue );
        Assert.assertTrue(actualValue, description);
    }

    public void assertContains(String description, String actualValue, String expectedValue) {
//        log.info(String.format("Assert contains [%s], Expected [%s], Actual [%s]", description, expectedValue, actualValue));
        Assert.assertTrue(actualValue.contains(expectedValue), description);
    }
}
