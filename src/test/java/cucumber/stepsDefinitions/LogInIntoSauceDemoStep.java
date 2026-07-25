package cucumber.stepsDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.questions.MessageVisible;
import starter.tasks.LogIn;
import starter.tasks.OpenSauceDemo;
import starter.ui.LoginUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class LogInIntoSauceDemoStep {

    @Before
    public void setTheStage() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) opens SauceDemo$")
    public void intoSauceDemo(String actor) {
        OnStage.theActorCalled(actor).wasAbleTo(OpenSauceDemo.application());
    }

    @When("he logs in using {string} and {string}")
    public void heLogsInUsingAnd(String user, String password) {
        theActorInTheSpotlight().attemptsTo(
                LogIn.onCredentials(user, password)
        );
    }

    @Then("he should see the products page {string}")
    public void heShouldSeeTheProductsPage(String message) {
        theActorInTheSpotlight().should(seeThat(MessageVisible.of(LoginUI.LBL_MESSAGE), equalTo(message)));
    }

    @Then("he should see the locked user {string}")
    public void heShouldSeeTheLockedUser(String message) {
        theActorInTheSpotlight().should(seeThat(MessageVisible.of(LoginUI.ULO_MESSAGE), equalTo(message)));
    }

    @Then("he should see the invalid credentials {string}")
    public void heShouldSeeTheInvalidCredentials(String message) {
        theActorInTheSpotlight().should(seeThat(MessageVisible.of(LoginUI.ULO_MESSAGE), equalTo(message)));
    }
}
