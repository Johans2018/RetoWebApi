package starter.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CreatedBookingId implements Question<Integer> {

    public static CreatedBookingId value() {
        return new CreatedBookingId();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().path("bookingid");
    }
}
