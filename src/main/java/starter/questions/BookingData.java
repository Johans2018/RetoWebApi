package starter.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import starter.models.Booking;

public class BookingData implements Question<Booking> {

    public static BookingData value() {
        return new BookingData();
    }

    @Override
    public Booking answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Booking.class);
    }
}
