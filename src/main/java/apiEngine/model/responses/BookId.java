package apiEngine.model.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookId {

    @JsonProperty("bookingid")
    public Integer bookingId;

    /**
     * No args constructor for use in serialization
     *
     */
    public BookId() {
    }

    /**
     *
     * @param bookingId
     */
    public BookId(Integer bookingId) {
        super();
        this.bookingId = bookingId;
    }

}
