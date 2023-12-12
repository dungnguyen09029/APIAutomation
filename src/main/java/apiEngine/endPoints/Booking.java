package apiEngine.endPoints;

import apiEngine.model.requests.BookInformation;
import apiEngine.model.responses.Book;
import apiEngine.model.responses.ListBookId;
import io.restassured.http.Method;

public class Booking extends RestRequest {

    public IRestResponse<ListBookId> bookingRequest() {
        String endPoint = Routes.booking();
        initializeRequest(endPoint, Method.GET);
        return new RestResponse(ListBookId.class, buildMethod());
    }

    public IRestResponse<Book> createBookingRequest(BookInformation bookInformation) {
        String endPoint = Routes.createBooking();
        initializeRequest(endPoint, Method.POST);
        buildBody(bookInformation);
        return new RestResponse(Book.class, buildMethod());
    }
}
