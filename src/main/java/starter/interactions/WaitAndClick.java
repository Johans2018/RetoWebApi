package starter.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class WaitAndClick implements Interaction {

    private final Target target;

    public WaitAndClick(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isVisible())
                        .forNoMoreThan(30)
                        .seconds(),
                net.serenitybdd.screenplay.actions.Click.on(target)
        );
    }

    public static WaitAndClick on(Target target) {
        return instrumented(WaitAndClick.class, target);
    }
}
