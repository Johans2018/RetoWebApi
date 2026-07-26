package cucumber.stepsDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import starter.models.Booking;
import starter.models.BookingDates;
import starter.questions.LastResponseStatus;
import starter.tasks.CreateBooking;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateBookingStep {

    private Actor jonathan = Actor.named("Jonathan");
    private Booking bookingInfo;

    @Before
    public void setup() {
        // Asignamos la habilidad de llamar a APIs REST usando la URL configurada en serenity.conf
        jonathan.whoCan(CallAnApi.at("https://restful-booker.herokuapp.com"));
    }

    @Given("Jonathan has valid booking information")
    public void jonathanHasValidBookingInformation() {
        BookingDates dates = new BookingDates("2026-08-01", "2026-08-10");
        bookingInfo = new Booking("Jonathan", "Doe", 150, true, dates, "Breakfast");
    }

    @When("he creates the booking")
    public void heCreatesTheBooking() {
        jonathan.attemptsTo(
                CreateBooking.withData(bookingInfo)
        );
    }

    @Then("the booking should be created successfully")
    public void theBookingShouldBeCreatedSuccessfully() {
        jonathan.should(
                seeThat(LastResponseStatus.is(), equalTo(200))
        );
    }
}
