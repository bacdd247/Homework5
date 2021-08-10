package bacdd.page;
import bacdd.common.BasePage;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.length;

public class ProductPage extends PageFactory {
    WebDriver driver;
    public ProductPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@type='submit']")
    WebElement AddToBasketButton;
    @FindBy(xpath = "//div[@class='woocommerce-message']")
    WebElement noticeTitle;
    @FindBy(xpath = "//a[text()='Description']")
    WebElement descriptionTab;
    @FindBy(xpath = "//h2[text()='Product Description']")
    WebElement descriptionTitle;

    @FindBy(xpath = "//a[contains(text(),'Reviews')]")
    WebElement reviewsTab;
    @FindBy(xpath = "//h2[contains(text(),'Reviews')]")
    WebElement reviewsTitle;

    @FindBy(xpath = "//a[text()='View Basket']")
    WebElement viewBasketButton;
    @FindBy(xpath = "//span[contains(@class,'Price-amount')]")
    WebElement priceProduct;
    @FindBy(xpath = "//del//span[contains(@class,'Price-amount')]")
    WebElement oldPriceProduct;
    @FindBy(xpath = "//ins//span[contains(@class,'Price-amount')]")
    WebElement salePriceProduct;
    @FindBy(xpath = "//input[@type='number']")
    WebElement productNumber;
    @FindBy(xpath = "//h1[@itemprop='name']")
    WebElement productName;
    @FindBy(xpath = "//span[@class='cartcontents']")
    WebElement cartItems;
    @FindBy(xpath = "//span[@class='amount']")
    WebElement cartAmount;
    @FindBy(xpath = "//p[@class='stock in-stock']")
    WebElement booksInStock;

    public void clickViewBasket()   {
        viewBasketButton.click();
    }

    public void  clickCartItems() { cartItems.click(); }

    public void verifyAddToBasket() {
        Assert.assertTrue(noticeTitle.getText().contains("has been added to your basket"));
        String items = productNumber.getAttribute("value");
        String price = priceProduct.getText().replace("₹","").replace(".00","");
        String amount = "₹" + String.valueOf(Long.parseLong(price) * Long.parseLong(items)) + ".00";
        if (Integer.parseInt(items) == 1) {
            Assert.assertEquals(items + " Item", cartItems.getText());
        } else {
            Assert.assertEquals(items + " Items", cartItems.getText());
        }
        Assert.assertEquals(amount, cartAmount.getText());
    }

    public void verifyDetailPage(String arrivalName) {
        Assert.assertEquals(arrivalName, productName.getText());
        Assert.assertTrue(AddToBasketButton.isEnabled());
    }

    public void inputBooksThanStocks() {
        Integer booksThanStock = Integer.parseInt(booksInStock.getText().replace(" in stock","")) + 1;
        productNumber.sendKeys(String.valueOf(booksThanStock));
    }

    public String getHtml5ValidationMessage(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
    }

    public void verifyErrorPrompt() {
        String nameMessage = getHtml5ValidationMessage(productNumber);
        Assert.assertTrue(nameMessage.contains("Value must be less than or equal to"));
        System.out.println(nameMessage);
    }

    public void clickOnAddToBaketButton() {
        AddToBasketButton.click();
    }
    public void clickOnDescription() {
        descriptionTab.click();
    }
    public void verifyDescriptionDisplayed() {
        Assert.assertTrue(descriptionTitle.isDisplayed());
    }
    public void clickOnReviewsTab() {
        reviewsTab.click();
    }
    public void verifyReviewsDisplayed()    {
        Assert.assertTrue(reviewsTitle.isDisplayed());
    }

    public void verifySalePrice()   {
        Assert.assertTrue(oldPriceProduct.isDisplayed() && salePriceProduct.isDisplayed());
    }

}
