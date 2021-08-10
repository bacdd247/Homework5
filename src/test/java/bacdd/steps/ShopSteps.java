package bacdd.steps;
import bacdd.common.BasePage;
import bacdd.page.*;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ShopSteps {
    WebDriver driver;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    BasePage basePage;
    ShopPage shopPage;

    public ShopSteps() {
        this.driver = Hooks.driver;
        productPage = new ProductPage(this.driver);
        checkoutPage = new CheckoutPage(this.driver);
        basePage = new BasePage(this.driver);
        shopPage = new ShopPage(this.driver);
    }

    @When("^Adjust the filter by price between (.*) to (.*) rps$")
    public void adjustTheFilter() {

    }
    @When("^Click on Filter button$")
    public void cliclFilter() {

    }
    @When("^User can view books only between (.*) to (.*) rps price$")
    public void verifyBooksPrice() {

    }
    @When("^Click (.*) in the product category$")
    public void clickOnCategory(String prodCate) {
        shopPage.clickOnProductCategory(prodCate);
    }
    @When("^User can view only that particular product$")
    public void verifyParticularProduct$() {
        shopPage.verifyPartiProd();
    }
    @When("^Click on (.*) in Default sorting dropdown$")
    public void clickSortingDropdrown(String valueSort) {
        shopPage.clickSortDropdown(valueSort);
    }
    @When("^User can view the popular products only$")
    public void verifyPopularProduct() {
        shopPage.verifyPopularProduct();
    }
    @When("^Click on Sale written product$")
    public void clickSaleProduct() {
        shopPage.clickOnSale();
    }
    @When("^User can view the actual price with old price striken$")
    public void verifySaleProduct() {
        productPage.verifySalePrice();
    }

    @When("^Click on the Add To Basket button of (.*)$")
    public void clickAddProductToCart(String productName) {
        shopPage.clickOnAddProductToCard(productName);
    }
    @When("^Click on View Basket link$")
    public void clickViewBasket() {
        basePage.waitForSec(5);
        shopPage.clickBtnViewBasket();
    }
    @When("^The tax rate variers for India compared to other countries$")
    public void verifyTaxRate() {
        checkoutPage.verifyTaxRate();
    }

}
