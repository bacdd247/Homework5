package bacdd.steps;

import bacdd.common.BasePage;
import bacdd.page.HomePage;
import bacdd.page.LoginPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CommonSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    BasePage basePage;

    public CommonSteps() {
        this.driver = Hooks.driver;
        loginPage = new LoginPage(this.driver);
        homePage = new HomePage(this.driver);
        basePage = new BasePage(this.driver);
    }

    @When("^Click on back button$")
    public void goBack() {
        basePage.waitForSec(3);
        driver.navigate().back();
    }


}
