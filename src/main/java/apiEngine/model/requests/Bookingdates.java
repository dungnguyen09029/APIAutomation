package apiEngine.model.requests;


public class Bookingdates {

    public String checkin;
    public String checkout;

    /**
     * No args constructor for use in serialization
     *
     */
    public Bookingdates() {
    }

    /**
     *
     * @param checkin
     * @param checkout
     */
    public Bookingdates(String checkin, String checkout) {
        super();
        this.checkin = checkin;
        this.checkout = checkout;
    }
}