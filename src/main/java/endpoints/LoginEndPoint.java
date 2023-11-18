package endpoints;

import data.GlobalHeader;
import data.GlobalVariables;
import io.restassured.http.Method;
import io.restassured.response.Response;
import request.RequestHandler;
import requestbody.CreateBooking;

public class LoginEndPoint {

    public Response loginRequest(String email, String password) {
        String endPoint = "/api/login";
        Method method = Method.POST;
        RequestHandler requestHandler = new RequestHandler(GlobalVariables.BASE_URL, endPoint, GlobalVariables.PROTOCOL, method);
//        Map<String, String> body  = new HashMap<String, String>() {{
//            put("email", "eve.holt@reqres.in");
//            put("password", "cityslicka");
//        }};
        requestHandler.buildHeader("Content-Type", GlobalHeader.CONTENT_TYPE);
//        requestHandler.buildBody(LibraryManager.getInstance().getApiJsonUtils().buildJSONParam(body));
        requestHandler.buildBody(new CreateBooking());
        return requestHandler.buildMethod();
    }
}
