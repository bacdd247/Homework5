package bacdd.steps;

import bacdd.common.BasePage;
import bacdd.page.HomePage;
import bacdd.page.LoginPage;
import bacdd.page.MyAccountPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class MyAccountSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    BasePage basePage;
    MyAccountPage myAccountPage;

    public MyAccountSteps() {
        this.driver = Hooks.driver;
        loginPage = new LoginPage(this.driver);
        homePage = new HomePage(this.driver);
        basePage = new BasePage(this.driver);
        myAccountPage = new MyAccountPage(this.driver);
    }

    @Then("^User must view Dashboard of the site$")
    public void verifyDashboard() {
        loginPage.verifyDashboardDisplayed();
    }

    @When("^Click on Orders link$")
    public void clickMyAccountLink()  {
        homePage.clickOnOrders();
    }
    @When("^User must view their orders on clicking orders link$")
    public void verifyOrdersPage()  {
        myAccountPage.verifyOrdersTable();
    }
    @When("^Click view button$")
    public void clickOnViewBtn()  {
        myAccountPage.clickViewBtn();
    }
    @When("^User must view his Order details,customer details and billing details$")
    public void verifyOrdersDetails()  {
        myAccountPage.verifyOrdersDetails();
    }
    @When("^User must view Order Number Ordered date and Status of the order$")
    public void verifyOrdersDescription()  {
        myAccountPage.verifyOrdersDescription();
    }
    @When("^Click on Address link$")
    public void clickOnAdrress()  {
        homePage.clickOnAddresses();
    }
    @When("^Click on Account details$")
    public void clickOnAccountDetails()  {
        homePage.clickOnAccountDetails();
    }
    @When("^User must view billing address and ship address$")
    public void verifyAdressPage()  {
        myAccountPage.verifyAdressPage();
    }
    @When("^Click Edit on Shipping Address$")
    public void clickOnEditShippingAddress()  {
        myAccountPage.clickOnEditShippingAddress();
    }
    @When("^User can Edit Shipping address$")
    public void verifyEditShippingAddress()  {
        myAccountPage.verifyEditShippingAddress();
    }
    @When("^User can view account details where he can change his pasword also$")
    public void verifyAccountDetailsPage()  {
        myAccountPage.verifyAccountDetailsPage();
    }

}
