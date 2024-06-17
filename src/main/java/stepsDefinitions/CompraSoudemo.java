package stepsDefinitions;

import groovy.util.logging.Slf4j;
import interactions.NavigateTo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.hamcrest.Matchers;
import questions.QuesGetText;
import task.LoginTastk;
import task.ProductTask;
import task.ValidateBuyTask;
import ui.ValidateBuyPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

@Slf4j
public class CompraSoudemo {

    @Given("El {actor} ingresa a la pagina souce demo con el usuario: {} y clave: {}")
    public void el_usuario_ingresa_a_la_pagina_souce_demo_con_el_usuario_standard_user_y_clave_secret_sauce(Actor actor,String usuario, String clave) {
        actor.attemptsTo(NavigateTo.login("uat"));
        theActorInTheSpotlight().attemptsTo(LoginTastk.with(usuario,clave));
    }
    @When("Agrega productos {}, {} al carrito de compras")
    public void agregaProductosProductoCantidadProductoCantidadCalCarritoDeCompras(String product1, String product2) {
        theActorInTheSpotlight().attemptsTo(ProductTask.add(product1,product2));
    }
    @When("Reviso el carrito de compras, e ingreso los datos {},{},{}")
    public void reviso_el_carrito_de_compras_e_ingreso_los_datos_firstname_lastname_zipcode(String firstName,String lastName,String zipCode) {
        theActorInTheSpotlight().attemptsTo(ValidateBuyTask.with(firstName,lastName,zipCode));
    }

    @Then("Finalizo la compra con el mensaje")
    public void finalizo_la_compra_con_el_mensaje(String docString) {
        theActorInTheSpotlight().should(
                seeThat("Overview de compra",
                        QuesGetText.getText(ValidateBuyPage.TEXT_CHECK_OVERVIEW_TITLE),
                        Matchers.equalTo("Checkout: Overview"))
        );

        theActorInTheSpotlight().attemptsTo(
                Scroll.to(ValidateBuyPage.FINALIZA_COMPRA_BUTTON).andAlignToBottom(),
                Click.on(ValidateBuyPage.FINALIZA_COMPRA_BUTTON)
        );

        theActorInTheSpotlight().should(
                seeThat("Valida Fin Compra",
                        QuesGetText.getText(ValidateBuyPage.TEXT_FINAL_TITLE),
                        Matchers.equalTo(docString))
        );

    }



}
