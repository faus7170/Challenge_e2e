package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage extends PageObject {

    public static Target buttonProdduct(String product){
        return Target.the("Boton producto - "+product)
                .located(By.xpath("//div[@id='inventory_container']//div[@class='inventory_item']//div[contains(text(),'"+product+"')]"));
    }
    public static Target ADD_TO_CART= Target.the("Boton agregar producto")
            .located(By.xpath("//*[@id='add-to-cart']"));

    public static Target BACK_PRODUCTS= Target.the("Boton Regresar lista de productos")
            .located(By.xpath("//button[@id='back-to-products']"));


    public static Target SHOPPING_BUTTON = Target.the("Boton carrito de compra")
            .located(By.xpath("//*[@id='shopping_cart_container']/a"));

    public static Target TITULO_CART = Target.the("Boton carrito de compra")
            .located(By.xpath("//*[@id='header_container']/div[2]/span"));

    public static Target CHECKOUT_BUTTON = Target.the("Boton Chekout")
            .located(By.xpath("//*[@id='checkout']"));


}
