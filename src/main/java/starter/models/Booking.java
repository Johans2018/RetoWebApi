package starter.models;

import lombok.Getter;

@Getter
public class Booking {
    // Getters y Setters
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public Booking() {}

    public Booking(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDates bookingdates
            , String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public void setTotalprice(int totalprice) { this.totalprice = totalprice; }

    public void setDepositpaid(boolean depositpaid) { this.depositpaid = depositpaid; }

    public void setBookingdates(BookingDates bookingdates) { this.bookingdates = bookingdates; }

    public void setAdditionalneeds(String additionalneeds) { this.additionalneeds = additionalneeds; }
}
