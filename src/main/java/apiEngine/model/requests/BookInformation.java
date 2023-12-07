package apiEngine.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("booking")
public class BookInformation {

    @JsonProperty("firstname")
    public String firstName;

    public String lastname;
    public Integer totalprice;
    public Boolean depositpaid;
    public Bookingdates bookingdates;
    public String additionalneeds;

    /**
     * No args constructor for use in serialization
     *
     */
    public BookInformation() {
    }

    /**
     *
     * @param firstname
     * @param additionalneeds
     * @param bookingdates
     * @param totalprice
     * @param depositpaid
     * @param lastname
     */
    public BookInformation(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Bookingdates bookingdates, String additionalneeds) {
        super();
        this.firstName = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }
}
