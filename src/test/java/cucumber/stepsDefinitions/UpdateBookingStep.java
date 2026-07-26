package cucumber.stepsDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import starter.models.Booking;
import starter.models.BookingDates;
import starter.questions.BookingData;
import starter.questions.CreatedBookingId;
import starter.questions.LastResponseStatus;
import starter.tasks.CreateBooking;
import starter.tasks.GenerateToken;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class UpdateBookingStep {

    private final Actor jonathan = Actor.named("Jonathan");
    private Booking defaultBooking;

    @Before
    public void setup() {
        jonathan.whoCan(CallAnApi.at("https://restful-booker.herokuapp.com/booking/:id"));
        BookingDates dates = new BookingDates("2026-08-01", "2026-08-10");
        defaultBooking = new Booking("Jonathan", "Doe", 200, true, dates, "Breakfast");
    }

    @Given("Jonathan has a valid booking")
    public void jonathanHasAValidBooking() {
        jonathan.attemptsTo(
                GenerateToken.forAdmin(),
                CreateBooking.withData(defaultBooking)
        );
        Integer bookingId = jonathan.asksFor(CreatedBookingId.value());
        jonathan.remember("BOOKING_ID", bookingId);
    }

    @Then("the booking should be updated")
    public void verifyBookingUpdated() {
        jonathan.should(
                seeThat(LastResponseStatus.is(), equalTo(200)),
                seeThat(actor -> actor.asksFor(BookingData.value()).getFirstname(), equalTo("JonathanUpdated"))
        );
    }
}
