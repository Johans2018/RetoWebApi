package cucumber.stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import starter.interactions.WaitAndClick;
import starter.questions.MessageVisible;
import starter.tasks.LogIn;
import starter.tasks.OpenSauceDemo;
import starter.ui.ShoppingCartUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class ShoppingCartStep {

    @Given("^(.*) is logged in$")
    public void isLoggedIn(String actor) {
        OnStage.theActorCalled(actor).wasAbleTo(OpenSauceDemo.application());
        theActorInTheSpotlight().attemptsTo(
                LogIn.onCredentials("standard_user", "secret_sauce")
        );
    }

    @When("he adds the Backpack product")
    public void heAddsTheBackpackProduct() {
        theActorInTheSpotlight().attemptsTo(
                WaitAndClick.on(ShoppingCartUI.SLB_BUTTON)
        );
    }

    @Then("the cart should contain {string} product")
    public void theCartShouldContainProduct(String oneProduct) {
        theActorInTheSpotlight().should(seeThat(MessageVisible.of(ShoppingCartUI.CART), equalTo(oneProduct)));
    }

    @When("he adds two products")
    public void heAddsTwoProducts() {
        theActorInTheSpotlight().attemptsTo(
                WaitAndClick.on(ShoppingCartUI.SLB_BUTTON),
                WaitAndClick.on(ShoppingCartUI.SLBL_BUTTON)
        );
    }

    @Then("the cart badge should display {string}")
    public void theCartBadgeShouldDisplay(String twoProducts) {
        theActorInTheSpotlight().should(seeThat(MessageVisible.of(ShoppingCartUI.CART), equalTo(twoProducts)));
    }
}
