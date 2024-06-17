package task;

import interactions.NavigateTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.LoginPage;
import util.TimeWait;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTastk implements Task {
    private String usuario;
    private String clave;
    public LoginTastk(String usuario, String clave) {
        this.usuario=usuario;
        this.clave=clave;
    }
    public static Task with(String usuario,String clave){
        return instrumented(LoginTastk.class,usuario,clave);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int timeWait = TimeWait.waitImplicitSeconds();
        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginPage.USER_NAME_INPUT),
                Enter.theValue(clave).into(LoginPage.PASSWORD_INPUT),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
