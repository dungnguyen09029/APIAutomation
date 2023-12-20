package apiEngine.manager;

import apiEngine.endPoints.request.Authentication;
import apiEngine.endPoints.request.Booking;
import apiEngine.endPoints.request.DeleteBooking;
import apiEngine.endPoints.request.UpdateBooking;

public class RequestManager {

    private Booking booking;
    private UpdateBooking updateBooking;
    private Authentication authentication;
    private DeleteBooking deleteBooking;

    public Booking getBooking() {
        return (booking == null) ? booking = new Booking() : booking;
    }

    public UpdateBooking getUpdateBooking(String token) {
        return (updateBooking == null) ? updateBooking = new UpdateBooking(token) : updateBooking;
    }

    public DeleteBooking getDeleteBooking(String token) {
        return (deleteBooking == null) ? deleteBooking = new DeleteBooking(token) : deleteBooking;
    }

    public Authentication getAuthentication() {
        return (authentication == null) ? authentication = new Authentication() : authentication;
    }
}
