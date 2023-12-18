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

    @Override
    public boolean equals(Object obj) {

        boolean status = false;

        if (this == obj) {
            return true;
        }

        BookInformation other = (BookInformation) obj;

        // Kiểm tra từng biến số của object
        // Sử dụng equals() cho các biến kiểu Object
        // Sử dụng == cho các biến kiểu nguyên thủy
        if (other.firstName.equals(this.firstName)
                && other.lastname.equals(this.lastname)
                && other.totalprice.equals(this.totalprice)
                && other.depositpaid == this.depositpaid
                && other.additionalneeds.equals(this.additionalneeds)
                && other.bookingdates.checkin.equals(this.bookingdates.checkin)
                && other.bookingdates.checkout.equals(this.bookingdates.checkout)) {
            status = true;
        }

        return status;
    }
}
