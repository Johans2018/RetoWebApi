package starter.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PartialUpdateBooking implements Task {

    private final Object bookingId;
    private final String firstname;

    public PartialUpdateBooking(Object bookingId, String firstname) {
        this.bookingId = bookingId;
        this.firstname = firstname;
    }

    public static PartialUpdateBooking firstName(Object bookingId, String firstname) {
        return instrumented(PartialUpdateBooking.class, bookingId, firstname);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String token = actor.recall("AUTH_TOKEN");

        String body = "{\"firstname\":\"" + firstname + "\"}";

        System.out.println("BOOKING ID = " + bookingId);
        System.out.println("TOKEN = " + token);
        System.out.println("BODY = " + body);

        actor.attemptsTo(
                Patch.to("/booking/" + bookingId)
                        .with(request -> request
                                .log().all()
                                .contentType(ContentType.JSON)
                                .accept(ContentType.JSON)
                                .cookie("token", token)
                                .body(body)
                        )
        );
        System.out.println(SerenityRest.lastResponse().statusCode());
        System.out.println(SerenityRest.lastResponse().asString());
    }

}
