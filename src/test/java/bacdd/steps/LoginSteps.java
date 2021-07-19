package bacdd.steps;


import bacdd.page.HomePage;
import bacdd.page.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    public LoginSteps() {
        this.driver = Hooks.driver;
        loginPage = new LoginPage(this.driver);
        homePage = new HomePage(this.driver);
    }

    @Given("^Open home page$")
    public void openHomePage() {
        homePage.openHomePage();
    }

    @Given("^Click on My Account Menu$")
    public void clickOnMyAccountMenu() {
        loginPage.clickOnMyAccountMenu();
    }

    @When("^Enter registered (.*) in username textbox$")
    public void enterRegisteredUsername(String username) {
        loginPage.inputUsername(username);
    }

    @When("^Enter (.*) in password textbox$")
    public void enterRegisteredPassword(String password) {
        loginPage.inputPassword(password);
    }

    @And("^Click on login button$")
    public void clickOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("^User must successfully login to the web page$")
    public void verifyLoginSuccess() {
        loginPage.verifyDashboardDisplayed();
    }

    @Then("^Proper error must be displayed (.*)$")
    public void verifyLoginFail(String errormessage) {
        loginPage.verifyLoginError(errormessage);
    }

    @Then("^Password should be masked$")
    public void verifyPasswordIsInvisible() {
        loginPage.verifyPasswordIsInvisible();
    }

    @When("^Click on logout button$")
    public void logout() {
        homePage.logout();
    }

    @Then("^User is not signed in to his account again$")
    public void verifyCanNotLoginAgain() { loginPage.verifyCanNotLoginAgain(); }

}
