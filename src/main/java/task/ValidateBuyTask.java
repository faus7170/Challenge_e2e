package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;
import questions.QuesGetText;
import ui.ProductPage;
import ui.ValidateBuyPage;
import util.TimeWait;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class ValidateBuyTask implements Task {

    private String firstName;
    private String lastName;
    private String zipCode;
    public ValidateBuyTask (String firstName, String lastName, String zipCode){
        this.firstName=firstName;
        this.lastName=lastName;
        this.zipCode=zipCode;
    }
    public static Task with(String firstName, String lastName, String zipCode){
        return instrumented(ValidateBuyTask.class,firstName,lastName,zipCode);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        int timeWait= TimeWait.waitImplicitSeconds();
        theActorInTheSpotlight().should(
                seeThat("Título Check Informacion",
                        QuesGetText.getText(ValidateBuyPage.TEXT_TITLE),
                        Matchers.equalTo("Checkout: Your Information"))
        );
        actor.attemptsTo(
                WaitUntil.the(ValidateBuyPage.FIRST_NAME_TEXT, WebElementStateMatchers.isVisible()).forNoMoreThan(timeWait).seconds(),
                Enter.theValue(firstName).into(ValidateBuyPage.FIRST_NAME_TEXT),
                Enter.theValue(lastName).into(ValidateBuyPage.LASTNAME_TEXT),
                Enter.theValue(zipCode).into(ValidateBuyPage.ZIPCODE_TEXT),
                Scroll.to(ValidateBuyPage.CONTINUE_BUTTON).andAlignToBottom(),
                Click.on(ValidateBuyPage.CONTINUE_BUTTON)
        );

    }
}
