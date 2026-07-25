package starter.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {

    public static final Target TXT_USERNAME = Target.the("campo para ingresar el usuario")
            .located(By.id("user-name"));

    public static final Target TXT_PASSWORD = Target.the("campo para ingresar la contraseña")
            .located(By.id("password"));

    public static final Target BTN_LOGIN = Target.the("botón para iniciar sesión")
            .located(By.id("login-button"));

    public static final Target LBL_MESSAGE = Target.the("mensaje de ingreso al app")
            .located(By.xpath("//div[contains(text(), 'Swag Labs')]"));

    public static final Target ULO_MESSAGE = Target.the("mensaje de usuario bloqueado")
            .located(By.xpath("//button[@data-test='error-button']/parent::h3"));
}
