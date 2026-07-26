package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import starter.ui.CheckoutUI;

public class CheckoutInformation implements Task {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public CheckoutInformation(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public static CheckoutInformation on(String firstName, String lastName, String postalCode) {
        return Tasks.instrumented(CheckoutInformation.class, firstName, lastName, postalCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(firstName).into(CheckoutUI.FIRSTNAME_FIELD));
        actor.attemptsTo(Enter.theValue(lastName).into(CheckoutUI.LASTNAME_FIELD));
        actor.attemptsTo(Enter.theValue(postalCode).into(CheckoutUI.POSTAL_FIELD));
    }
}
