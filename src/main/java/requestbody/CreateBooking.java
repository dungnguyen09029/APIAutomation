package requestbody;

public class CreateBooking {

    public String firstname;
    public String lastname;
    public int totalprice;
    public boolean depositpaid;
    public Bookingdates bookingdates;
    public String additionalneeds;



}

class Bookingdates{
    public String checkin;
    public String checkout;
}
