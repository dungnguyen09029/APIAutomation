package testData;

import apiEngine.model.requests.BookInformation;
import apiEngine.model.requests.Bookingdates;

public class BookingTestData {

    public BookInformation getBookInformation() {
        Bookingdates bookingdates = new Bookingdates("2018-01-01", "2019-01-01");
        return new BookInformation("Jim", "Brown", 111, true, bookingdates, "Breakfast");
    }
}
