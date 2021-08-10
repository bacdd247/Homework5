package bacdd.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class CheckoutPage extends PageFactory {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(@class,'checkout')]")
    WebElement checkoutButton;
    @FindBy(xpath = "//input[@name='coupon_code']")
    WebElement txtCouponCode;
    @FindBy(xpath = "//tr[@class='order-total']//span[@class='woocommerce-Price-amount amount']")
    WebElement totalPrice;
    @FindBy(xpath = "//input[@name='apply_coupon']")
    WebElement btnApplyCoupon;
    @FindBy(xpath = "//ul[@class='woocommerce-error']")
    WebElement checkoutErrorMess;
    @FindBy(xpath = "//td[@data-title='Roaming Tax']")
    WebElement roamingTax;
    @FindBy(xpath = "//a[@class='remove']")
    WebElement btnRemove;
    //div[@class='woocommerce-message']
    @FindBy(xpath = "//div[@class='woocommerce-message']")
    WebElement checkoutMessage;
    @FindBy(xpath = "//input[@type='number']")
    WebElement txtQuantity;
    @FindBy(xpath = "//input[@name='update_cart']")
    WebElement btnUpdateCart;
    @FindBy(xpath = "//td[@data-title='Subtotal']//span")
    WebElement subTotalPrice;




    Long basketTotalBefore;
    Long taxBefore;

    public void verifyCheckoutPage() {
        Assert.assertTrue(checkoutButton.isDisplayed());
    }

    public void enterCouponCode(String coupon) {
        basketTotalBefore = Long.parseLong(totalPrice.getText().replace("₹","").replace(".",""));
        taxBefore = Long.parseLong(roamingTax.getText().replace("₹","").replace(".",""));
        txtCouponCode.sendKeys(coupon);
        btnApplyCoupon.click();
    }

    public void verifyTotalPriceWithCoupon(String priceDecrease) {
        Long basketTotalAfter = Long.parseLong(totalPrice.getText().replace("₹","").replace(".",""));
        Long taxAfter = Long.parseLong(roamingTax.getText().replace("₹","").replace(".",""));
        Assert.assertEquals(Long.parseLong(priceDecrease),(basketTotalBefore - taxBefore - basketTotalAfter + taxAfter)/100);
    }

    public void verifyErrorCoupon() {
        Assert.assertTrue(checkoutErrorMess.getText().contains("The minimum spend for this coupon is"));
    }

    public void clickOnRemoveButton()   {
        btnRemove.click();
    }

    public void verifyBookIsRemoved(String bookName) {
        Assert.assertEquals(bookName + " removed. Undo?", checkoutMessage.getText());
    }

    String quantity;
    public void updateQuantity(String numberBooks) {
        txtQuantity.clear();
        txtQuantity.sendKeys(numberBooks);
        quantity =  numberBooks;

    }

    public void clickUpdateBasketButton() {
        Assert.assertTrue(btnUpdateCart.isEnabled());
        btnUpdateCart.click();
    }

    public void verifyBaketIsUpdated()  {
        Assert.assertEquals(quantity, txtQuantity.getAttribute("value"));
    }

    public void verifyBasketTotelPrice()  {
        Assert.assertTrue(totalPrice.isDisplayed());
    }

    public void verifyTotalWithSubtotal()  {
        Assert.assertEquals(Long.parseLong(totalPrice.getText().replace("₹","").replace(".","")) , Long.parseLong(subTotalPrice.getText().replace("₹","").replace(".","")) + Long.parseLong(roamingTax.getText().replace("₹","").replace(".","")));
    }

    public void clickProceedToCheckOutButton()  {
        checkoutButton.click();
    }

    public void verifyTaxRate() {
        Long taxRate = Long.parseLong(roamingTax.getText().replace("₹","").replace(".",""))*100/Long.parseLong(subTotalPrice.getText().replace("₹","").replace(".",""));
        System.out.println("Vietnam tax rate" + taxRate + "% # India tax rate 2%");
        Assert.assertEquals("5", String.valueOf(taxRate));
    }
}
