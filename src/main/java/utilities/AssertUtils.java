package utilities;

import data.GlobalVariables;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertUtils {

    private final SoftAssert softAssert;

    public AssertUtils() {
        softAssert = new SoftAssert();
    }

    public SoftAssert getSoftAssert() {
        return softAssert;
    }

    public void assertEquals(String actualValue, String expectedValue) {
        String description = "Assert equals: actual Value: " + actualValue + " & expected Value: " + expectedValue;
        Log.logInfo(description);
        Assert.assertEquals(actualValue, expectedValue);
    }

    public void assertEquals(int actualValue, int expectedValue) {
        String description = "Assert equals: actual Value: " + actualValue + " & expected Value: " + expectedValue;
        Log.logInfo(description);
        if (GlobalVariables.isSoftAssert)
            softAssert.assertEquals(actualValue, expectedValue);
        else
            Assert.assertEquals(actualValue, expectedValue);
    }

    public void assertEquals(Object actualValue, Object expectedValue) {
        String description = "Assert equals: actual Value: " + actualValue + " & expected Value: " + expectedValue;
        Log.logInfo(description);
        Assert.assertEquals(actualValue, expectedValue);
    }

    public void assertTheSame(Object actualValue, Object expectedValue) {
        String description = "Assert equals: actual Value: " + actualValue + " & expected Value: " + expectedValue;
        Log.logInfo(description);
        Assert.assertSame(actualValue, expectedValue);
    }

    public void assertTrue(boolean condition) {
        String description = "Assert true: condition is: " + condition;
        Log.logInfo(description);
        if (GlobalVariables.isSoftAssert)
            softAssert.assertEquals(condition, description);
        else
            Assert.assertTrue(condition, description);
    }

}
