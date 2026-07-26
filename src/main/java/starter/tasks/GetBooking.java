package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetBooking implements Task {

    private final Object bookingId;

    public GetBooking(Object bookingId) {
        this.bookingId = bookingId;
    }

    public static GetBooking byId(Object bookingId) {
        return instrumented(GetBooking.class, bookingId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/booking/" + bookingId)
        );
    }
}
