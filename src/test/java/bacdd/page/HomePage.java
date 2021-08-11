package bacdd.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends PageFactory {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//nav[@id='main-nav-wrap']//a[text()='Shop']")
    WebElement shopMenu;
    @FindBy(xpath = "//div[@id='content']/nav/a[text()='Home']")
    WebElement homeMenuButton;
    @FindBy(xpath = "//div[@class='row_inner']//div[@data-slide-duration='0']//img")
    List<WebElement> listSlider;
    @FindBy(xpath = "//div[@class='woocommerce']//a/img")
    List<WebElement> listArrivals;
    @FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']//a[text()='Logout']")
    WebElement logoutButton;
    @FindBy(xpath = "//a[text()='Orders']")
    WebElement menuOrders;
    @FindBy(xpath = "//a[text()='Account Details']")
    WebElement menuAccountDetails;
    @FindBy(xpath = "//a[text()='Addresses']")
    WebElement menuAddresses;



    public void openHomePage() {
        driver.get("http://practice.automationtesting.in/");
    }
    public void clickOnShopMenu(){
        shopMenu.click();
    }
    public void clickOnHomeMenuButton(){
        homeMenuButton.click();
    }
    public void verifyNumberOfSliders(){
        Assert.assertEquals(3,listSlider.size());
    }
    public void verifyNumberOfArrivals(){
        Assert.assertEquals(3,listArrivals.size());
    }
    public void logout() {
        logoutButton.click();
    }
    public void clickOnArrival(String productname) {
        By xpathArrival = By.xpath("//img[@title='" + productname + "']");
        WebElement arrival = driver.findElement(xpathArrival);
        Assert.assertTrue(arrival.isEnabled());
        arrival.click();
    }

    public void clickOnAddresses()  { menuAddresses.click();  }
    public void clickOnOrders()  { menuOrders.click();  }
    public void clickOnAccountDetails()  { menuAccountDetails.click();  }

}
