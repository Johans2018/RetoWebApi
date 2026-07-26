package starter.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteBooking implements Task {

    private final Object bookingId;
    private final boolean withAuth;

    public DeleteBooking(Object bookingId, boolean withAuth) {
        this.bookingId = bookingId;
        this.withAuth = withAuth;
    }

    public static DeleteBooking withAuth(Object bookingId) {
        return instrumented(DeleteBooking.class, bookingId, true);
    }

    public static DeleteBooking withoutAuth(Object bookingId) {
        return instrumented(DeleteBooking.class, bookingId, false);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String token = withAuth ? actor.recall("AUTH_TOKEN") : "";

        actor.attemptsTo(
                Delete.from("/booking/" + bookingId)
                        .with(request -> {
                            request.contentType(ContentType.JSON);
                            if (withAuth && token != null) {
                                request.cookie("token", token);
                            }
                            return request;
                        })
        );
    }

}
