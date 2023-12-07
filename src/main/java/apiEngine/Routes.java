package apiEngine;

import data.GlobalVariables;

public class Routes {

    private static final String BOOKING = GlobalVariables.SEPARATOR + "booking";

    public static String booking() {
        return BOOKING;
    }

    public static String createBooking() {
        return BOOKING;
    }

    public static String getSpecificBooking(String id) {
        return BOOKING + GlobalVariables.SEPARATOR + id;
    }
}
