package endpoints.get;

import data.GlobalHeader;
import data.GlobalVariables;
import io.restassured.http.Method;
import io.restassured.response.Response;
import request.RequestHandler;

public class Booking {

    public Response bookingRequest() {
        String endPoint = GlobalVariables.SEPARATOR + "booking";
        Method method = Method.GET;
        RequestHandler requestHandler = new RequestHandler(GlobalVariables.BASE_URL, endPoint, GlobalVariables.PROTOCOL, method);
//        Map<String, String> body  = new HashMap<String, String>() {{
//            put("email", "eve.holt@reqres.in");
//            put("password", "cityslicka");
//        }};
        requestHandler.buildHeader("Content-Type", GlobalHeader.CONTENT_TYPE);
//        requestHandler.buildBody(LibraryManager.getInstance().getApiJsonUtils().buildJSONParam(body));
//        requestHandler.buildBody(new CreateBooking());
        return requestHandler.buildMethod();
    }
}
