package starter.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import starter.models.Booking;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateBooking implements Task {

    private final Booking bookingInfo;

    public CreateBooking(Booking bookingInfo) {
        this.bookingInfo = bookingInfo;
    }

    public static CreateBooking withData(Booking bookingInfo) {
        return instrumented(CreateBooking.class, bookingInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/booking")
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body(bookingInfo)
                        )
        );
    }
}
