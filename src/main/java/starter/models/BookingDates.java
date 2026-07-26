package starter.models;

import lombok.Getter;

@Getter
public class BookingDates {
    private String checkin;
    private String checkout;

    public BookingDates() {}

    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public void setCheckin(String checkin) { this.checkin = checkin; }

    public void setCheckout(String checkout) { this.checkout = checkout; }
}
