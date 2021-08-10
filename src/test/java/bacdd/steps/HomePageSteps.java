package bacdd.steps;

import bacdd.common.BasePage;
import bacdd.page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    BasePage basePage;
    PaymentPage paymentPage;

    public HomePageSteps() {
        this.driver = Hooks.driver;
        loginPage = new LoginPage(this.driver);
        homePage = new HomePage(this.driver);
        productPage = new ProductPage(this.driver);
        checkoutPage = new CheckoutPage(this.driver);
        basePage = new BasePage(this.driver);
        paymentPage = new PaymentPage(this.driver);
    }

    @Given("^Click on Shop Menu")
    public void clickShop() {
        homePage.clickOnShopMenu();
    }

    @When("^Click on Home menu button$")
    public void clickHomeButton() {
        homePage.clickOnHomeMenuButton();
    }

    @When("^Verify the Home page has Three Sliders only$")
    public void verifyHomepageSliders() {
        homePage.verifyNumberOfSliders();
    }

    @When("^Verify the Home page has three Arrivals$")
    public void verifyHomepageArrivals() {
        homePage.verifyNumberOfArrivals();
    }

    @When("^Click the image in the Arrivals (.*)$")
    public void clickOnArrival(String productname) {
        homePage.clickOnArrival(productname);
    }

    @When("^Verify browser navigate to next page and user can add (.*) book into basket$")
    public void verifyDetailProduct(String arrivalName) {
        productPage.verifyDetailPage(arrivalName);
    }

    @When("^Click on the Add To Basket button$")
    public void clickAddToBasket() {
        productPage.clickOnAddToBaketButton();
    }

    @When("^User can view that Book in the Menu item with price$")
    public void verifyAddToBasketSuccess() {
        productPage.verifyAddToBasket();
    }

    @When("^Click on Description$")
    public void clickOnDescription() {
       productPage.clickOnDescription();
    }


    @When("^Verify description regarding that book$")
    public void verifyDescription() {
        productPage.verifyDescriptionDisplayed();
    }

   @When("^Click on Reviews tab$")
    public void clickOnReviewsTab() {
       productPage.clickOnReviewsTab();
    }

    @When("^Verify Reviews regarding that book$")
    public void verifyReviewsTab() {
        productPage.verifyReviewsDisplayed();
    }

    @When("^Select more books than the books in stock$")
    public void inputMoreBooksThanStock() {
        productPage.inputBooksThanStocks();
    }

    @When("^Verify error prompt you must enter right number$")
    public void verifyErrorPrompt() {
        productPage.verifyErrorPrompt();
    }

    @When("^Click on Item link$")
    public void clickOnItemLink() {
        basePage.waitForSec(5);
        productPage.clickCartItems();

    }

    @When("^Click view Basket$")
    public void clickViewBasket()   {
        productPage.clickViewBasket();
    }

    @When("^Verify broswer navigates to check out page$")
    public void verifyCheckoutPage() {
        checkoutPage.verifyCheckoutPage();
    }

    @When("^Enter the Coupon code (.*)$")
    public void enterCoupon(String coupon) {
        checkoutPage.enterCouponCode(coupon);
    }

    @When("^Verify the total price is (.*) rps off$")
    public void validateTotalPrice(String priceDecrease) {
        basePage.waitForSec(5);
        checkoutPage.verifyTotalPriceWithCoupon(priceDecrease);
    }


    @When("^Verify user can not able to apply coupon for the book price > 450 rps$")
    public void verifyCoupon() {
        basePage.waitForSec(5);
        checkoutPage.verifyErrorCoupon();
    }

    @When("^Click on Remove icon$")
    public void clickOnRemoveIcon() {
        checkoutPage.clickOnRemoveButton();
    }

    @When("^Verify the book (.*) is removed from cart$")
    public void verifyRemoveBookSuccess(String bookname) {
        basePage.waitForSec(5);
        checkoutPage.verifyBookIsRemoved(bookname);
    }
    @When("^Add 2 quantity of books: (.*)")
    public void addQuantity(String numberBooks) {
        checkoutPage.updateQuantity(numberBooks);
    }
    @When("^Click on Update Basket$")
    public void clickUpdateBasket() {
        checkoutPage.clickUpdateBasketButton();
    }
    @When("^Verrify Basket is updated$")
    public void verifyBasketUpdated() {
        basePage.waitForSec(5);
        checkoutPage.verifyBaketIsUpdated();
    }
    @When("^User can find the Total price of the book in the Check out grid$")
    public void findTotalPrice() {
           checkoutPage.verifyBasketTotelPrice();
    }

    @When("^The total < subtotal because taxes are added in the subtotal$")
    public void verifyTotalWithSubtotalPrice() {
        checkoutPage.verifyTotalWithSubtotal();
    }

    @When("^Click on Proceed to Check out button$")
    public void clickCheckOut() {
        checkoutPage.clickProceedToCheckOutButton();
    }
    @When("^Verify browser leads to payment gateway page$")
    public void verifyPaymentPage() {
        paymentPage.verifyPaymentPage();
    }
    @When("^User can view Billing Details,Order Details,Additional details and Payment gateway details$")
    public void verifyPaymentDetail() {
        paymentPage.verifyPaymentPageDetail();
    }
    @When("^User can fill his details in billing details form, add coupon and can opt any payment in the payment gateway$")
    public void verifyFillPaymentDetail() {
        paymentPage.verifyAddCoupon();
        paymentPage.fillFirstName("BAC");
        paymentPage.fillLastName("DEP ZAI");
        paymentPage.fillBillingCompany("MBBANK");
        paymentPage.fillBillingEmail("bacdepzai@gmail.com");
        paymentPage.fillBillingPhone("346289765");
        paymentPage.fillbillingAddress1("DONG DA");
        paymentPage.fillBillingPostcode("84");
        paymentPage.fillBillingCity("HA NOI");
        paymentPage.clickPaymentType("Check Payments");
        paymentPage.clickPaymentType("Cash on Delivery");
        paymentPage.clickPaymentType("PayPal Express Checkout");
        paymentPage.clickPaymentType("Direct Bank Transfer");
    }

    @When("^Fill details in billing details form and choose payment type in the payment gateway")
    public void fillPaymentDetail() {
        paymentPage.verifyAddCoupon();
        paymentPage.fillFirstName("BAC");
        paymentPage.fillLastName("DEP ZAI");
        paymentPage.fillBillingCompany("MBBANK");
        paymentPage.fillBillingEmail("bacdepzai@gmail.com");
        paymentPage.fillBillingPhone("346289765");
        paymentPage.fillbillingAddress1("DONG DA");
        paymentPage.fillBillingPostcode("84");
        paymentPage.fillBillingCity("HA NOI");
    }

    @When("^Click on Place Order button$")
    public void clickPlaceOrderBtn() {
        paymentPage.clickPlaceOrder();
    }

    @When("^Verify Order confirmation page with order details,bank details$")
    public void verifyOrderPage() {
        basePage.waitForSec(5);
        paymentPage.verifyConfirmationPage();
    }
}
