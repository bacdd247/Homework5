package bacdd.page;

import bacdd.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;



public class LoginPage extends PageFactory {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul[@id='main-nav']//a[text()='My Account']")
    WebElement myAccountMenu;
    @FindBy(id = "username")
    WebElement txtUsername;
    @FindBy(id = "password")
    WebElement txtPassword;
    @FindBy(xpath = "//input[@name='login']")
    WebElement btnLogin;
    @FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']//a[text()='Dashboard']")
    WebElement dashboard;
    @FindBy(xpath = "//ul[contains(@class,'error')]//li")
    WebElement errorMessage;
    @FindBy(id = "reg_email")
    WebElement txtRegEmail;
    @FindBy(id = "reg_password")
    WebElement txtRegPassword;
    @FindBy(xpath = "//input[@name='register']")
    WebElement btnRegister;


    public void clickOnMyAccountMenu(){
        myAccountMenu.click();
    }
    public void login(String username,String password){
        inputUsername(username);
        inputPassword(password);
        clickOnLoginButton();
    }
    public void inputUsername(String username){
        txtUsername.clear();
        txtUsername.sendKeys(username);
    }
    public void inputPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }
    public void clickOnLoginButton(){
        btnLogin.click();
    }

    public void verifyDashboardDisplayed(){
        Assert.assertTrue(dashboard.isDisplayed());
    }

    public void verifyLoginError(String erromessage)  {
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), erromessage);
    }

    public void verifyPasswordIsInvisible() {
        Assert.assertEquals(txtPassword.getAttribute("type"), "password");
    }

    public void verifyCanNotLoginAgain() {
        Assert.assertTrue(btnLogin.isDisplayed());
    }

    public void inputRandRegEmail(){
        txtRegEmail.clear();
        Random rand = new Random();
        String regusername = "bacdd" + rand.nextInt(1000) + "@paraline.com.vn";
        System.out.println("Email dang ky: " + regusername);
        txtRegEmail.sendKeys(regusername);
    }

    public void inputRegEmail(String regusername){
        txtRegEmail.clear();
        txtRegEmail.sendKeys(regusername);
    }

    public void inputRegPassword(String password) throws InterruptedException {
        txtRegPassword.clear();
        txtRegPassword.sendKeys(password + Keys.ENTER);
        Thread.sleep(5000);
        txtRegPassword.sendKeys(Keys.ENTER);
    }
    public void clickOnRegisterButton() {
        btnRegister.click();
    }
}
