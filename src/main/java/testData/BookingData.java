package testData;

import apiEngine.model.requests.BookInformation;
import apiEngine.model.requests.Bookingdates;

public class BookingData {

    public BookInformation getBookInformation() {
        Bookingdates bookingdates = new Bookingdates("2018-01-01", "2019-01-01");
        return new BookInformation("Jim", "Brown", 111, true, bookingdates, "Breakfast");
    }

    public BookInformation getUpdateBookInformation() {
        Bookingdates bookingdates = new Bookingdates("2020-01-01", "2020-01-02");
        return new BookInformation("Sun", "Wu kong", 2000, false, bookingdates, "Bread");
    }
}
