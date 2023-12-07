package apiEngine.manager;

import apiEngine.Booking;

public class RequestManager {

    private Booking booking;

    public Booking getBooking() {
        return (booking == null) ? booking = new Booking() : booking;
    }
}
