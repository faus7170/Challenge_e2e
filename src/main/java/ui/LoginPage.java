package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class LoginPage extends PageObject {

    public static Target USER_NAME_INPUT= Target.the("Campo Usuario")
            .located(By.cssSelector("#user-name"));
    public static Target PASSWORD_INPUT =Target.the("Campo Clave")
            .located(By.cssSelector("#password"));
    public static Target LOGIN_BUTTON =Target.the("Boton Login")
            .located(By.cssSelector("#login-button"));
}
