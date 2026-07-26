package cucumber.stepsDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import starter.models.Booking;
import starter.models.BookingDates;
import starter.questions.BookingData;
import starter.questions.CreatedBookingId;
import starter.questions.LastResponseStatus;
import starter.tasks.CreateBooking;
import starter.tasks.GenerateToken;
import starter.tasks.PartialUpdateBooking;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PartialUpdateBookingStep {

    private final Actor jonathan = Actor.named("Jonathan");
    private Booking defaultBooking;

    @Before
    public void setup() {
        jonathan.whoCan(CallAnApi.at("https://restful-booker.herokuapp.com/booking/:id"));
        BookingDates dates = new BookingDates("2026-08-01", "2026-08-10");
        defaultBooking = new Booking("Jonathan", "Doe", 200, true, dates, "Breakfast");
    }

    @Given("Jonathan has a booking")
    public void jonathanHasABooking() {
        jonathan.attemptsTo(
                GenerateToken.forAdmin(),
                CreateBooking.withData(defaultBooking)
        );
        Integer bookingId = jonathan.asksFor(CreatedBookingId.value());
        jonathan.remember("BOOKING_ID", bookingId);
    }

    @When("he updates only the first name")
    public void heUpdatesOnlyTheFirstName() {
        Integer bookingId = jonathan.recall("BOOKING_ID");
        jonathan.attemptsTo(
                PartialUpdateBooking.firstName(bookingId, "JonathanPartial")
        );
    }

    @Then("the booking should contain the new first name")
    public void verifyPartialUpdate() {
        SerenityRest.lastResponse().prettyPrint();
        jonathan.should(
                seeThat(LastResponseStatus.is(), equalTo(200)),
                seeThat(actor -> actor.asksFor(BookingData.value()).getFirstname(), equalTo("JonathanPartial"))
        );
    }
}
