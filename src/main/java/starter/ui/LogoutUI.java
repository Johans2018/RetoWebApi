package starter.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LogoutUI {

    public static final Target BURGER_MENU = Target.the("Menu hamburguesa")
            .located(By.xpath("//button[@id='react-burger-menu-btn']"));

    public static final Target LOGOUT_BUTTON = Target.the("Boton cerrar sesión")
            .located(By.xpath("//a[@id='logout_sidebar_link']"));

    public static final Target SAWG_LABS_LOGO = Target.the("Logo Swag labs")
            .located(By.xpath("//div[contains(text(),'Swag Labs')]"));
}
