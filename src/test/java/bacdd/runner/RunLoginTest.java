package bacdd.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty","html:target/report.html"},
    glue="bacdd.steps",
    //tags = "@Test",
    features = "src/test/java/bacdd/feature/Login.feature"
)
public class RunLoginTest {
}
