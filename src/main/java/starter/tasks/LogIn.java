package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import starter.interactions.WaitAndClick;
import starter.ui.LoginUI;

public class LogIn implements Task {

    private final String user;
    private final String password;

    public LogIn(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static LogIn onCredentials(String user, String password) {
        return Tasks.instrumented(LogIn.class, user, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(user).into(LoginUI.TXT_USERNAME));
        actor.attemptsTo(Enter.theValue(password).into(LoginUI.TXT_PASSWORD));
        actor.attemptsTo(WaitAndClick.on(LoginUI.BTN_LOGIN));
    }
}
