package cucumber.stepsDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import starter.models.Booking;
import starter.models.BookingDates;
import starter.questions.BookingData;
import starter.questions.CreatedBookingId;
import starter.questions.LastResponseStatus;
import starter.tasks.CreateBooking;
import starter.tasks.GenerateToken;
import starter.tasks.GetBooking;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetBookingStep {

    private final Actor jonathan = Actor.named("Jonathan");
    private Booking defaultBooking;

    @Before
    public void setup() {
        jonathan.whoCan(CallAnApi.at("https://restful-booker.herokuapp.com"));
        BookingDates dates = new BookingDates("2026-08-01", "2026-08-10");
        defaultBooking = new Booking("Jonathan", "Doe", 200, true, dates, "Breakfast");
    }

    @Given("a booking already exists")
    public void jonathanCreatesABooking() {
        jonathan.attemptsTo(
                GenerateToken.forAdmin(),
                CreateBooking.withData(defaultBooking)
        );
        Integer bookingId = jonathan.asksFor(CreatedBookingId.value());
        jonathan.remember("BOOKING_ID", bookingId);
    }

    @When("Jonathan retrieves the booking")
    public void heRetrievesTheBooking() {
        Integer bookingId = jonathan.recall("BOOKING_ID");
        jonathan.attemptsTo(GetBooking.byId(bookingId));
    }

    @Then("the booking information should be returned")
    public void verifyBookingReturned() {
        jonathan.should(
                seeThat(LastResponseStatus.is(), equalTo(200)),
                seeThat(actor -> actor.asksFor(BookingData.value()).getFirstname(), equalTo("Jonathan"))
        );
    }
}
