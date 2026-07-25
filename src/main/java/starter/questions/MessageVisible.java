package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class MessageVisible implements Question<String> {

    private final Target target;

    public MessageVisible(Target target) {
        this.target = target;
    }

    public static MessageVisible of(Target target) {
        return new MessageVisible(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).getText();
    }
}
