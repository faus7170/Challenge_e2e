package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ValidateBuyPage extends PageObject {

    public static Target TEXT_TITLE = Target.the("Titulo pagina")
            .located(By.xpath("//*[@id='header_container']/div[2]/span"));
    public static Target FIRST_NAME_TEXT = Target.the("Campo First Name")
            .located(By.xpath("//*[@id='first-name']"));
    public static Target LASTNAME_TEXT = Target.the("Campo Last Name")
            .located(By.xpath("//*[@id='last-name']"));
    public static Target ZIPCODE_TEXT =Target.the("Campo Zip Code")
            .located(By.xpath("//*[@id='postal-code']"));
    public static Target CONTINUE_BUTTON =Target.the("Boton continuar")
            .located(By.xpath("//*[@id='continue']"));

    public static Target TEXT_CHECK_OVERVIEW_TITLE = Target.the("Titulo overview compra")
            .located(By.xpath("//*[@id='header_container']/div[2]/span"));
    public static Target FINALIZA_COMPRA_BUTTON= Target.the("Boton finalizar compra")
            .located(By.xpath("//*[@id='finish']"));

    public static Target TEXT_FINAL_TITLE = Target.the("Titulo Finalizar  compra")
            .located(By.xpath("//*[@id='checkout_complete_container']/h2"));

}
