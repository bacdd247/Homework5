package bacdd.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends PageFactory{
    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']")
    WebElement billingDetails;
    @FindBy(xpath = "//h3[@id='order_review_heading']")
    WebElement orderDetails;
    @FindBy(xpath = "//div[@class='woocommerce-shipping-fields']")
    WebElement additionaldetails;
    @FindBy(xpath = "//ul[@class='wc_payment_methods payment_methods methods']")
    WebElement paymentGatewayDetails;
    @FindBy(xpath = "//input[@name='billing_first_name']")
    WebElement firstNameTxt;
    @FindBy(xpath = "//input[@name='billing_last_name']")
    WebElement lastNameTxt;
    @FindBy(xpath = "//input[@name='billing_company']")
    WebElement billingCompanyTxt;
    @FindBy(xpath = "//input[@name='billing_email']")
    WebElement billingEmailTxt;
    @FindBy(xpath = "//input[@name='billing_phone']")
    WebElement billingPhoneTxt;
    @FindBy(xpath = "//input[@name='billing_address_1']")
    WebElement billingAddress1Txt;
    @FindBy(xpath = "//input[@name='billing_postcode']")
    WebElement billingPostcodeTxt;
    @FindBy(xpath = "//input[@name='billing_city']")
    WebElement billingCityTxt;
    @FindBy(xpath = "//span[@class='select2-chosen']")
    WebElement chooseCountryList;
    @FindBy(xpath = "//input[@value='bacs']")
    WebElement radioDirectBankTransfer;
    @FindBy(xpath = "//input[@value='cheque']")
    WebElement radioCheckPayments;
    @FindBy(xpath = "//input[@value='cod']")
    WebElement radioCashOnDelivery;
    @FindBy(xpath = "//input[@value='ppec_paypal']")
    WebElement radioPayPal;
    @FindBy(xpath = "//a[@class='showcoupon']")
    WebElement addCoupon;
    @FindBy(xpath = "//h2[contains(@class,'bank-details')]")
    WebElement bankDetails;
    @FindBy(xpath = "//table[@class='shop_table order_details']")
    WebElement orderDetail;
    @FindBy(xpath = "//input[@id='place_order']")
    WebElement btnPlaceOrder;

    public void verifyPaymentPage() {
        Assert.assertTrue(btnPlaceOrder.isDisplayed());
    }

    public void verifyPaymentPageDetail()   {
        Assert.assertTrue(billingDetails.isDisplayed());
        Assert.assertTrue(orderDetails.isDisplayed());
        Assert.assertTrue(additionaldetails.isDisplayed());
        Assert.assertTrue(paymentGatewayDetails.isDisplayed());
    }

    public void verifyAddCoupon() {
        Assert.assertTrue(addCoupon.isDisplayed());
    }
    public void fillFirstName(String firstName) {
        firstNameTxt.sendKeys(firstName);
    }
    public void fillLastName(String lastName) {
        lastNameTxt.sendKeys(lastName);
    }
    public void fillBillingCompany(String billingCompany) {
        billingCompanyTxt.sendKeys(billingCompany);
    }
    public void fillBillingEmail(String billingEmail) {
        billingEmailTxt.sendKeys(billingEmail);
    }
    public void fillBillingPhone(String billingPhone) {
        billingPhoneTxt.sendKeys(billingPhone);
    }
    public void fillbillingAddress1(String billingAddress) {
        billingAddress1Txt.sendKeys(billingAddress);
    }
    public void fillBillingPostcode(String billingPostcode) {
        billingPostcodeTxt.sendKeys(billingPostcode);
    }
    public void clickPaymentType(String paymentType) {
        switch (paymentType) {
            case "Check Payments":
                radioCheckPayments.click();
                break;
            case "Cash on Delivery":
                radioCashOnDelivery.click();
                break;
            case "PayPal Express Checkout":
                radioPayPal.click();
                break;
            default:
                radioDirectBankTransfer.click();
                break;
        }
    }

    public void fillBillingCity(String billingCity) {
        billingCityTxt.sendKeys(billingCity);
    }


    public void clickPlaceOrder()   {
        btnPlaceOrder.click();
    }

    public void verifyConfirmationPage()    {
        Assert.assertTrue(bankDetails.isDisplayed() && orderDetail.isDisplayed());
    }
}
