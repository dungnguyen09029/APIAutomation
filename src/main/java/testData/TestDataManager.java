package testData;

import apiEngine.endPoints.Booking;

public class TestDataManager {

    private BookingTestData bookInformationData;

    public BookingTestData getBookInformationDataTestData() {
        return (bookInformationData == null) ? bookInformationData = new BookingTestData() : bookInformationData;
    }
}
