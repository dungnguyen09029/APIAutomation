package apiEngine.endPoints.request;

import apiEngine.endPoints.IRestResponse;
import apiEngine.endPoints.RestRequest;
import apiEngine.endPoints.RestResponse;
import apiEngine.endPoints.Routes;
import apiEngine.model.requests.BookInformation;
import apiEngine.model.responses.Book;
import apiEngine.model.responses.BookingId;
import io.restassured.http.Method;

public class Booking extends RestRequest {

    public IRestResponse<BookingId[]> bookingRequest() {
        String endPoint = Routes.booking();
        initializeRequest(endPoint, Method.GET);
        return new RestResponse(BookingId[].class, buildMethod());
    }

    public IRestResponse<BookInformation> SpecificBookingRequest(String Id) {
        String endPoint = Routes.getSpecificBooking(Id);
        initializeRequest(endPoint, Method.GET);
        return new RestResponse(BookInformation.class, buildMethod());
    }

    public <T> IRestResponse<Book> createBookingRequest(T body) {
        String endPoint = Routes.createBooking();
        initializeRequest(endPoint, Method.POST);
        buildBody(body);
        return new RestResponse(Book.class, buildMethod());
    }
}
