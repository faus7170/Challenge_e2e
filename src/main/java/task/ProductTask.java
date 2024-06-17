package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;
import questions.QuesGetText;
import ui.ProductPage;
import util.TimeWait;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ProductTask implements Task {
    private String producto1;
    private String producto2;
    public ProductTask(String producto1, String producto2) {
        this.producto1=producto1;
        this.producto2=producto2;
    }
    public static Task add(String producto1, String producto2){
        return instrumented(ProductTask.class,producto1, producto2);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int timeWait = TimeWait.waitImplicitSeconds();

        actor.attemptsTo(
                WaitUntil.the(ProductPage.buttonProdduct(producto1),WebElementStateMatchers.isVisible()).forNoMoreThan(timeWait).seconds(),
                Click.on(ProductPage.buttonProdduct(producto1)),
                Click.on(ProductPage.ADD_TO_CART),
                Click.on(ProductPage.BACK_PRODUCTS)

        );
        actor.attemptsTo(
                WaitUntil.the(ProductPage.buttonProdduct(producto2),WebElementStateMatchers.isVisible()).forNoMoreThan(timeWait).seconds(),
                Click.on(ProductPage.buttonProdduct(producto2)),
                Click.on(ProductPage.ADD_TO_CART),
                Click.on(ProductPage.BACK_PRODUCTS)

        );
        actor.attemptsTo(
                Click.on(ProductPage.SHOPPING_BUTTON)
        );

        theActorInTheSpotlight().should(
                seeThat("Título Carrito de compra", QuesGetText.getText(ProductPage.TITULO_CART),
                        Matchers.equalTo("Your Cart"))
        );
        actor.attemptsTo(
                WaitUntil.the(ProductPage.CHECKOUT_BUTTON, WebElementStateMatchers.isVisible()).forNoMoreThan(timeWait).seconds(),
                Scroll.to(ProductPage.CHECKOUT_BUTTON).andAlignToBottom(),
                Click.on(ProductPage.CHECKOUT_BUTTON)
        );
    }
}
