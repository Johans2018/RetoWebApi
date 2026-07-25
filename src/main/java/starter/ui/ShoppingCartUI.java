package starter.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShoppingCartUI {

    public static final Target SLB_BUTTON = Target.the("Boton adicionar carrito Mochila de Sauce Labs")
            .located(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']"));

    public static final Target SLBL_BUTTON = Target
            .the("Boton adicionar carrito Luz para bicicleta de Sauce Labs")
            .located(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bike-light']"));

    public static final Target CART = Target.the("Carrito de compras")
            .located(By.xpath("//span[@data-test='shopping-cart-badge']"));
}
