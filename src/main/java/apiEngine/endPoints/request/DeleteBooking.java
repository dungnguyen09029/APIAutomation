package apiEngine.endPoints.request;

import apiEngine.endPoints.RestRequest;
import apiEngine.endPoints.RestResponse;
import apiEngine.endPoints.Routes;
import enums.Header;
import io.restassured.http.Method;

public class DeleteBooking extends RestRequest {

    private String token;

    public DeleteBooking(String token) {
        this.token = "token=" + token;
        buildHeader(Header.COOKIE.getHeaderName(), this.token);
    }

    public RestResponse deleteBooking(String id) {
        String endPoint = Routes.deleteBooking(id);
        initializeRequest(endPoint, Method.DELETE);
        return new RestResponse(null, buildMethod());
    }
}
