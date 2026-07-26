package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import starter.models.Booking;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateBooking implements Task {

    private final Integer bookingId;
    private final Booking bookingData;

    public UpdateBooking(Integer bookingId, Booking bookingData) {
        this.bookingId = bookingId;
        this.bookingData = bookingData;
    }

    public static UpdateBooking withAuth(Integer bookingId, Booking bookingData) {
        return instrumented(UpdateBooking.class, bookingId, bookingData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Recuperamos el token generado previamente
        String token = actor.recall("AUTH_TOKEN"); // Asegúrate de guardar el token con esta clave en GenerateToken

        actor.attemptsTo(
                Put.to("/booking/" + bookingId)
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .header("Accept", "application/json")
                                .header("Cookie", "token=" + token) // O usando la cookie que la API requiere
                                .body(bookingData)
                        )
        );
    }
}
