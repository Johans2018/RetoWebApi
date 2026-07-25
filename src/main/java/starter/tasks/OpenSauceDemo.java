package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.pages.SauceDemoPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenSauceDemo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.browserOn().the(SauceDemoPage.class)
        );

    }

    public static OpenSauceDemo application() {
        return instrumented(OpenSauceDemo.class);
    }
}
