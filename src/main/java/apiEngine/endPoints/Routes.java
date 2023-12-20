package apiEngine.endPoints;

import data.GlobalVariables;

public class Routes {

    private static final String BOOKING = GlobalVariables.SEPARATOR + "booking";
    private static final String AUTHENTICATION = GlobalVariables.SEPARATOR + "auth";

    public static String booking() {
        return BOOKING;
    }

    public static String createBooking() {
        return BOOKING;
    }

    public static String getSpecificBooking(String id) {
        return BOOKING + GlobalVariables.SEPARATOR + id;
    }

    public static String updateBooking(String id) {
        return BOOKING + GlobalVariables.SEPARATOR + id;
    }

    public static String deleteBooking(String id) {
        return BOOKING + GlobalVariables.SEPARATOR + id;
    }

    public static String auth() {
        return AUTHENTICATION;
    }
}
