package starter.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GenerateToken implements Task {

    public static GenerateToken forAdmin() {
        return instrumented(GenerateToken.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = "{\"username\" : \"admin\", \"password\" : \"password123\"}";

        actor.attemptsTo(
                Post.to("/auth")
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body(body)
                        )
        );

        String token = SerenityRest.lastResponse().path("token");
        actor.remember("AUTH_TOKEN", token);
    }

}
