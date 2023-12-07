package apiEngine.endpoint;

import apiEngine.endpoint.RequestHandler;
import apiEngine.model.requests.BookInformation;
import data.EndPointUrl;
import data.GlobalHeader;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class Booking extends RequestHandler {

    public Response bookingRequest() {
        String endPoint = libraryManager.getUrlUtils().buildEndPoint(EndPointUrl.BOOKING);
        initializeRequest(endPoint, Method.GET);
        buildHeader(GlobalHeader.HEADER.CONTENT_TYPE.getHeaderName(), GlobalHeader.HEADER.CONTENT_TYPE.getHeaderValue());
        return buildMethod();
    }

    public Response createBookingRequest(BookInformation bookInformation) {
        String endPoint = libraryManager.getUrlUtils().buildEndPoint(EndPointUrl.BOOKING);
        initializeRequest(endPoint, Method.POST);
        buildHeader(GlobalHeader.HEADER.CONTENT_TYPE.getHeaderName(), GlobalHeader.HEADER.CONTENT_TYPE.getHeaderValue());
        buildBody(bookInformation);
        return buildMethod();
    }
}
