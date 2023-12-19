package apiEngine.manager;

import apiEngine.endPoints.request.Authentication;
import apiEngine.endPoints.request.Booking;
import apiEngine.endPoints.request.UpdateBooking;

public class RequestManager {

    private Booking booking;
    private UpdateBooking updateBooking;
    private Authentication authentication;

    public Booking getBooking() {
        return (booking == null) ? booking = new Booking() : booking;
    }

    public UpdateBooking getUpdateBooking(String token) {
        return (updateBooking == null) ? updateBooking = new UpdateBooking(token) : updateBooking;
    }

    public Authentication getAuthentication() {
        return (authentication == null) ? authentication = new Authentication() : authentication;
    }
}
