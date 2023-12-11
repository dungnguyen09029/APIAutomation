# APIAutomation


------------------------------------------------------------------------------------------------------------------------

Additionally, the test layer needs to focus only on the test data (parameters) sent in the request and receive responses 
from the APIs. It should not be focused on the heavy logic of the internals of API implemented. So, as software testers, 
we are only interested in the request and response obtained for these requests. Moreover, the test data sent in the 
request generally pass from the feature file in the Cucumber framework. This test data can be parameters to form 
a request body, request header or request resources.

--> Handle, transform, convert data and verify actions (assert for example) is done in Steps class or step cucumber
--> The end point only process api logic

------------------------------------------------------------------------------------------------------------------------

scenario context --> save data for testing, get default data, set default data

------------------------------------------------------------------------------------------------------------------------

Thus we need a class, which will return the Response Body as well as status and in case of failure return exception or 
error message.
--> It needs a class that can return a generic class object represent for response. Because response is de-serialize into 
multiple class based on the response body.

Now, the response received from the server can be of several data types. Hence, we need an interface capable of handling 
different response objects. To provide this parameterized value to a parameterized type, we implement this as a Generic 
Interface. This interface will contain all the methods we need when we operate on a REST Response.

------------------------------------------------------------------------------------------------------------------------

EndPoint class extends from BaseEndPoints always has format like this
public IRestResponse<ResponseBodyClass> createBookingRequest(RequestBodyClass)
--> RequestBodyClass is the class that is using for serialize the request body of api (if it has)
--> ResponseBodyClass is the class that is using for de-serialize the response body of api

------------------------------------------------------------------------------------------------------------------------

The report in runner is using testNG, any code sample from internet can use the junit which is different library. 
Especially the code with RunWith keyword
Generate build-in report for cucumber. Put this line of code into plugin --> html:target/cucumber-reports/BookingRunner.html

------------------------------------------------------------------------------------------------------------------------

The framework use log4j2 (not log4j) as a log library. The config will be inside the file log4j2.xml (the location should be 
under 'resources' folder of src/main/java, put it in other folder makes it cannot work)
Below appender tag is the file name that is created for log. One is .log and one is .html. append="true" will indicate
that the log will be appended to old file instead of create a new one
In the Loggers tag, every AppenderRef should point to every tag under Appenders which has named --> it will make sure it 
does not throw any log error

------------------------------------------------------------------------------------------------------------------------

The SoftAssert in AssertUtils is for assert without throwing error that stop cucumber from running remaining steps.
+ It will assert the step, save the error, but it is not mark the step as failed in cucumber report --> Need to find a
  way to deal with it. Make the step warning for example
+ It needs to call the method assertAll() at the end of test suite. The method will return all error but no step related to 
  that error. Need to improve it to make it call in @AfterSuite method. 