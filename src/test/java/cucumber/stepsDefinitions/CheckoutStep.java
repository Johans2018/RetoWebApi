package cucumber.stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import starter.interactions.WaitAndClick;
import starter.questions.MessageVisible;
import starter.tasks.CheckoutInformation;
import starter.tasks.LogIn;
import starter.tasks.OpenSauceDemo;
import starter.ui.CheckoutUI;
import starter.ui.ShoppingCartUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class CheckoutStep {

    @Given("^(.*) has products in the cart$")
    public void hasProductsCart(String actor) {
        OnStage.theActorCalled(actor).wasAbleTo(OpenSauceDemo.application());
        theActorInTheSpotlight().attemptsTo(
                LogIn.onCredentials("standard_user", "secret_sauce"),
                WaitAndClick.on(ShoppingCartUI.SLB_BUTTON),
                WaitAndClick.on(ShoppingCartUI.SLBL_BUTTON),
                WaitAndClick.on(ShoppingCartUI.CART_LINK)
        );
    }

    @When("he completes {string} {string} {string} the checkout process")
    public void heCompletesTheCheckoutProcess(String firstname, String lastname, String postal) {
        theActorInTheSpotlight().attemptsTo(
                WaitAndClick.on(CheckoutUI.CHECKOUT_BUTTON),
                CheckoutInformation.on(firstname, lastname, postal),
                WaitAndClick.on(CheckoutUI.CONTINUE_BUTTON),
                WaitAndClick.on(CheckoutUI.FINISH_BUTTON)
        );
    }

    @Then("he should see the confirmation {string}")
    public void heShouldSeeTheConfirmation(String message) {
        theActorInTheSpotlight().should(seeThat(MessageVisible.of(CheckoutUI.MESSAGE), equalTo(message)));
        theActorInTheSpotlight().attemptsTo(WaitAndClick.on(CheckoutUI.BACK_HOME_BUTTON));
    }

    @When("he leaves the first name empty {string} {string} {string}")
    public void heLeavesTheFirstNameEmpty(String firstname, String lastname, String postal) {
        theActorInTheSpotlight().attemptsTo(
                WaitAndClick.on(CheckoutUI.CHECKOUT_BUTTON),
                CheckoutInformation.on(firstname, lastname, postal),
                WaitAndClick.on(CheckoutUI.CONTINUE_BUTTON)
        );
    }

    @Then("he should see the required field {string}")
    public void heShouldSeeTheRequiredField(String errorMessage) {
        theActorInTheSpotlight().should(seeThat(MessageVisible.of(CheckoutUI.ERROR_MESSAGE), equalTo(errorMessage)));
    }
}
