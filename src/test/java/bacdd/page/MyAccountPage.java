package bacdd.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends PageFactory{
    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//table[contains(@class,'my_account_orders')]")
    WebElement ordersTable;
    @FindBy(xpath = "//a[@class='button view']")
    WebElement btnView;
    @FindBy(xpath = "//table[contains(@class,'customer_details')]")
    WebElement  custDetails;
    @FindBy(xpath = "//table[contains(@class,'order_details')]")
    WebElement  orderDetails;
    @FindBy(xpath = "//header[@class='title']")
    WebElement  billDetails;
    @FindBy(xpath = "//mark[@class='order-number']")
    WebElement  orderNumber;
    @FindBy(xpath = "//mark[@class='order-date']")
    WebElement  orderDate;
    @FindBy(xpath = "//mark[@class='order-status']")
    WebElement  orderStatus;
    @FindBy(xpath = "//h3[contains(text(),'Shipping Address')]//following::a")
    WebElement btnEditShippingAddress;
    @FindBy(xpath = "//h3[contains(text(),'Billing Address')]")
    WebElement  billingAddress;
    @FindBy(xpath = "//h3[contains(text(),'Shipping Address')]")
    WebElement  shippingAddress;
    @FindBy(xpath = "//input[@name='save_address']")
    WebElement btnSaveAddress;
    @FindBy(xpath = "//label[@for='account_first_name']")
    WebElement txtAccFirstName;
    @FindBy(xpath = "//label[@for='account_last_name']")
    WebElement txtAccLastName;
    @FindBy(xpath = "//label[@for='account_email']")
    WebElement txtAccEmail;
    @FindBy(xpath = "//label[@for='password_1']")
    WebElement txtPassword;
    @FindBy(xpath = "//input[@name='save_account_details']")
    WebElement btnSaveAccDetails;


    public void verifyOrdersTable() {
        Assert.assertTrue(ordersTable.isDisplayed());
    }

    public void clickViewBtn()  {
        btnView.click();
    }

    public void verifyOrdersDetails()  {
        Assert.assertTrue(custDetails.isDisplayed() && orderDetails.isDisplayed() && billDetails.isDisplayed());
    }

    public void verifyOrdersDescription()   {
        Assert.assertTrue(orderDate.isDisplayed() && orderNumber.isDisplayed() && orderStatus.isDisplayed());
    }

    public void verifyAdressPage()  {
        Assert.assertTrue(billingAddress.isDisplayed() && shippingAddress.isDisplayed());
    }
    public void clickOnEditShippingAddress()  {
        btnEditShippingAddress.click();
    }
    public void verifyEditShippingAddress()  {
        Assert.assertTrue(btnSaveAddress.isEnabled());
    }
    public void verifyAccountDetailsPage()  {
        Assert.assertTrue(txtAccEmail.isDisplayed()
                && txtAccFirstName.isDisplayed()
                && txtAccLastName.isDisplayed()
                && txtAccEmail.isDisplayed()
                && txtPassword.isDisplayed()
                && btnSaveAccDetails.isEnabled());
    }

}
