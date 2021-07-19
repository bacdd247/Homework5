package bacdd.steps;

import bacdd.common.BasePage;
import bacdd.common.WebDriverFactory;
import bacdd.page.HomePage;
import bacdd.page.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    BasePage basePage;

    public RegisterSteps() {
        this.driver = Hooks.driver;
        loginPage = new LoginPage(this.driver);
        homePage = new HomePage(this.driver);
        basePage = new BasePage(this.driver);
    }

    @When("^Enter a radom email in register textbox$")
    public void inputRandomRegisterUsername() {
        loginPage.inputRandRegEmail();
    }

    @When("^Enter (.*) in register username textbox$")
    public void inputRegisterUsername(String regusername) {
        loginPage.inputRegEmail(regusername);
    }

    @When("^Enter (.*) in register password textbox$")
    public void inputRegisterPassword(String password) throws InterruptedException {
            loginPage.inputRegPassword(password);
    }
    @When("^Click on register button$")
    public void clickRegister() {
        loginPage.clickOnRegisterButton();
    }
    @Then("^User will be registered successfully and will be navigated to the Home page$")
    public void verifyRegisterSuccess() {
        loginPage.verifyDashboardDisplayed();
    }
    @Then("^Registration must fail with a warning message (.*)$")
    public void verifyRegisterFail(String errorMessage) {
        loginPage.verifyLoginError(errorMessage);
    }
}
