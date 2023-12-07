package apiEngine.model.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListBookId {

    @JsonProperty("bookingid")
    public Integer bookingId;

    /**
     * No args constructor for use in serialization
     *
     */
    public ListBookId() {
    }

    /**
     *
     * @param bookingId
     */
    public ListBookId(Integer bookingId) {
        super();
        this.bookingId = bookingId;
    }
}
