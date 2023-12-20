package apiEngine.endPoints.request;

import apiEngine.endPoints.IRestResponse;
import apiEngine.endPoints.RestRequest;
import apiEngine.endPoints.RestResponse;
import apiEngine.endPoints.Routes;
import apiEngine.model.requests.BookInformation;
import enums.Header;
import io.restassured.http.Method;

import java.util.Map;

public class UpdateBooking extends RestRequest {

    private String token;

    public UpdateBooking(String token) {
        this.token = "token=" + token;
        buildHeader(Header.COOKIE.getHeaderName(), this.token);
    }

    public <T> IRestResponse<BookInformation> updateBooking(String id, T body) {
        String endPoint = Routes.updateBooking(id);
        initializeRequest(endPoint, Method.PUT);
        buildBody(body);
        return new RestResponse(BookInformation.class, buildMethod());
    }

    public <T> IRestResponse<BookInformation> partialUpdateBooking(String id, Map<String, T> data) {
        String endPoint = Routes.updateBooking(id);
        initializeRequest(endPoint, Method.PATCH);
        buildBody(data);
        return new RestResponse(BookInformation.class, buildMethod());
    }
}
