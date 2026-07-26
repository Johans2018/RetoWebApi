package starter.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutUI {

    public static final Target CHECKOUT_BUTTON = Target.the("Boton de verificación")
            .located(By.xpath("//button[@data-test='checkout']"));

    public static final Target FIRSTNAME_FIELD = Target.the("Campo nombre")
            .located(By.xpath("//input[@data-test='firstName']"));

    public static final Target LASTNAME_FIELD = Target.the("Campo apellido")
            .located(By.xpath("//input[@data-test='lastName']"));

    public static final Target POSTAL_FIELD = Target.the("Campo codigo postal")
            .located(By.xpath("//input[@data-test='postalCode']"));

    public static final Target CONTINUE_BUTTON = Target.the("Boton continuar")
            .located(By.xpath("//input[@data-test='continue']"));

    public static final Target FINISH_BUTTON = Target.the("Boton finalizar")
            .located(By.xpath("//button[@data-test='finish']"));

    public static final Target MESSAGE = Target.the("Mensaje ¡Gracias por su pedido!")
            .located(By.xpath("//h2[@data-test='complete-header']"));

    public static final Target BACK_HOME_BUTTON = Target.the("Boton volver al inicio")
            .located(By.xpath("//button[@data-test='back-to-products']"));

    public static final Target ERROR_MESSAGE = Target.the("Mensaje error")
            .located(By.xpath("//h3[@data-test='error']"));
}
