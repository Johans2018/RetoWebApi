package cucumber.stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.models.Booking;
import starter.questions.LastResponseStatus;
import starter.tasks.DeleteBooking;
import starter.tasks.UpdateBooking;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class NegativeBookingStep {

    private final Actor jonathan = Actor.named("Jonathan");
    private Booking defaultBooking;

    @Given("booking id {int}")
    public void bookingId(Integer id) {
        jonathan.remember("BOOKING_ID", id);
    }

    @When("he updates the booking without authentication")
    public void heUpdatesTheBookingWithoutAuthentication() {
        Integer bookingId = jonathan.recall("BOOKING_ID");
        jonathan.attemptsTo(
                UpdateBooking.withAuth(bookingId, defaultBooking)
        );
    }

    @When("he deletes the booking without authentication")
    public void heDeletesTheBookingWithoutAuthentication() {
        Integer bookingId = jonathan.recall("BOOKING_ID");
        jonathan.attemptsTo(
                DeleteBooking.withoutAuth(bookingId)
        );
    }

    @Then("the response code should be {int}")
    public void verifyResponseCode(int expectedStatus) {
        jonathan.should(
                seeThat(LastResponseStatus.is(), equalTo(expectedStatus))
        );
    }
}
