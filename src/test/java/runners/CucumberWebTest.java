package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "stepsDefinitions",
        plugin = {"pretty", "json:target/cucumber/cucumber.json"},
        tags = "@Compra",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucumberWebTest {

}
