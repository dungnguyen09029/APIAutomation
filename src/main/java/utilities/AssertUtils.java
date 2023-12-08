package utilities;

import org.testng.Assert;

//@Log4j
public class AssertUtils {

//    private final SoftAssert softAssertion;
//
//    public AssertUtils() {
//        softAssertion = new SoftAssert();
//    }
//
//    public SoftAssert getSoftAssertion() {
//        return softAssertion;
//    }
//
//    public void assertEquals(String description, String actualValue, String expectedValue) {
////        log.info("Assert equals: " + description + " - actual Value: " + actualValue + " & expected Value: " + expectedValue);
//        Assert.assertEquals(actualValue, expectedValue, description);
//    }
//
//    public void assertTrue(String description, boolean actualValue) {
////        log.info("Assert true: " + description + " - " + actualValue );
//        Assert.assertTrue(actualValue, description);
//    }
//
//    public void assertNotEquals(String description, String actualValue, String expectedValue) {
////        log.info("Assert equals: " + description + " - " + actualValue + " & expected Value: " + expectedValue);
//        Assert.assertNotEquals(actualValue, expectedValue, description);
//    }
//
//
//    public void assertContains(String description, String actualValue, String expectedValue) {
////        log.info(String.format("Assert contains [%s], Expected [%s], Actual [%s]", description, expectedValue, actualValue));
//        Assert.assertTrue(actualValue.contains(expectedValue), description);
//    }

    public void assertEquals(String actualValue, String expectedValue) {
        String description = "Assert equals: actual Value: " + actualValue + " & expected Value: " + expectedValue;
        Assert.assertEquals(actualValue, expectedValue);
    }

    public void assertEquals(int actualValue, int expectedValue) {
        String description = "Assert equals: actual Value: " + actualValue + " & expected Value: " + expectedValue;
        Assert.assertEquals(actualValue, expectedValue);
    }

    public void assertEquals(Object actualValue, Object expectedValue) {
        String description = "Assert equals: actual Value: " + actualValue + " & expected Value: " + expectedValue;
        Assert.assertEquals(actualValue, expectedValue);
    }

    public void assertTheSame(Object actualValue, Object expectedValue) {
        String description = "Assert equals: actual Value: " + actualValue + " & expected Value: " + expectedValue;
        Assert.assertSame(actualValue, expectedValue);
    }

    public void assertTrue(boolean condition) {
        String description = "Assert true: condition is: " + condition;
        Assert.assertTrue(condition, description);
    }

}
