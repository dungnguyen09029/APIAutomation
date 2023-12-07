package apiEngine.model.responses;

import apiEngine.model.requests.BookInformation;

public class Book {
    public Integer bookingid;
    public BookInformation booking;

    /**
     * No args constructor for use in serialization
     *
     */
    public Book() {
    }

    /**
     *
     * @param booking
     * @param bookingid
     */
    public Book(Integer bookingid, BookInformation booking) {
        super();
        this.bookingid = bookingid;
        this.booking = booking;
    }
}
