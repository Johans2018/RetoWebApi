package cucumber.stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.interactions.WaitAndClick;
import starter.questions.MessageVisible;
import starter.ui.LogoutUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class LogoutStep {

    @When("he logs out")
    public void heLogsOut() {
        theActorInTheSpotlight().attemptsTo(
                WaitAndClick.on(LogoutUI.BURGER_MENU),
                WaitAndClick.on(LogoutUI.LOGOUT_BUTTON)
        );
    }

    @Then("he should return to the login page")
    public void heShouldReturnToTheLoginPage() {
        theActorInTheSpotlight().should(seeThat(MessageVisible.of(LogoutUI.SAWG_LABS_LOGO), equalTo("Swag Labs")));
    }
}
