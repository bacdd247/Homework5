package bacdd.steps;

import bacdd.common.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Hooks {
    public static WebDriver driver;
    @Before
    public void setUp() {
        driver = WebDriverFactory.createDriver();
        driver.manage().window().maximize();
    }


    @After
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png","anh"); //stick it in the report
        driver.quit();
    }

}
