package cucumber.stepsDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import starter.models.Booking;
import starter.models.BookingDates;
import starter.questions.LastResponseStatus;
import starter.tasks.DeleteBooking;
import starter.tasks.GetBooking;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DeleteBookingStep {

    private final Actor jonathan = Actor.named("Jonathan");
    private Booking defaultBooking;

    @Before
    public void setup() {
        jonathan.whoCan(CallAnApi.at("https://restful-booker.herokuapp.com/booking/:id"));
        BookingDates dates = new BookingDates("2026-08-01", "2026-08-10");
        defaultBooking = new Booking("Jonathan", "Doe", 200, true, dates, "Breakfast");
    }

    @When("he deletes the booking")
    public void heDeletesTheBooking() {
        Integer bookingId = jonathan.recall("BOOKING_ID");
        jonathan.attemptsTo(
                DeleteBooking.withAuth(bookingId)
        );
    }

    @Then("the booking should no longer exist")
    public void verifyBookingDeleted() {
        jonathan.should(
                seeThat(LastResponseStatus.is(), equalTo(201))
        );

        Integer bookingId = jonathan.recall("BOOKING_ID");
        jonathan.attemptsTo(GetBooking.byId(bookingId));
        jonathan.should(
                seeThat(LastResponseStatus.is(), equalTo(404))
        );
    }
}
