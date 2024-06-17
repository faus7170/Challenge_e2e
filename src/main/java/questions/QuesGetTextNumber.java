package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class QuesGetTextNumber implements Question<String> {
    private final Target target;

    public QuesGetTextNumber(Target target) {
        this.target = target;
    }

    public static QuesGetTextNumber getText(Target target) {
        return new QuesGetTextNumber(target);
    }
    @Override
    public String answeredBy(Actor actor) {
            String value=BrowseTheWeb.as(actor).find(target).getText().trim();
            value=value.replaceAll("[^-\\d.]", "");
            if(value.equals("-"))value="0.00";
            return value;
    }
}
