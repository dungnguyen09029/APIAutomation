package testData;

public class DataManager {

    private BookingData bookingData;
    private Authentication authentication;

    public BookingData getBookingTestData() {
        return (bookingData == null) ? bookingData = new BookingData() : bookingData;
    }

    public Authentication getAuthentication() {
        return (authentication == null) ? authentication = new Authentication() : authentication;
    }
}
