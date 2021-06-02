package runner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestSuite {

    WebDriver driver;

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver","D:\\Auto\\webdriver\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("https://saucedemo.com");
        driver.manage().window().maximize();
    }

    /*public void setupCoccocDriver() {
        System.setProperty("webdriver.chrome.driver","D:\\Auto\\webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Bac\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
        driver = new ChromeDriver(options);
        driver.get("https://saucedemo.com");
        driver.manage().window().maximize();
    }*/

    @Test
    public void dangnhapthanhcong() {
        login("standard_user", "secret_sauce");
        WebElement shoppingCard = driver.findElement(By.id("shopping_cart_container"));
        Assert.assertTrue(shoppingCard.isDisplayed());
    }

    @Test
    public void dangnhaplockuser() {
        login("locked_out_user", "secret_sauce");
        WebElement errorLabel = driver.findElement(By.xpath("//div[@class='login-box']//h3"));
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", errorLabel.getText());

    }

    @Test
    public void nhapsaiusername() {
        login("standard_user1", "secret_sauce");
        WebElement errorLabel = driver.findElement(By.xpath("//div[@class='login-box']//h3"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorLabel.getText());

    }

    @Test
    public void nhapsaipassword() {
        login("standard_user", "secret_sauce1");
        WebElement errorLabel = driver.findElement(By.xpath("//div[@class='login-box']//h3"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorLabel.getText());

    }

    @Test
    public void khongnhapuser() {
        login("", "secret_sauce1");
        WebElement errorLabel = driver.findElement(By.xpath("//div[@class='login-box']//h3"));
        Assert.assertEquals("Epic sadface: Username is required", errorLabel.getText());

    }

    @Test
    public void khongnhappassword() {
        login("standard_user", "");
        WebElement errorLabel = driver.findElement(By.xpath("//div[@class='login-box']//h3"));
        Assert.assertEquals("Epic sadface: Password is required", errorLabel.getText());

    }

    @Test
    public void dangnhapuserloi() {
        login("problem_user", "secret_sauce");
        WebElement imgLabsBike = driver.findElement(By.xpath("//img[@alt='Sauce Labs Bike Light']"));
        Assert.assertEquals("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg", imgLabsBike.getAttribute("src"));

    }

    @Test
    public void khongnhapuservapassword() {
        login("", "");
        WebElement errorLabel = driver.findElement(By.xpath("//div[@class='login-box']//h3"));
        Assert.assertEquals("Epic sadface: Username is required", errorLabel.getText());

    }

    @Test
    public void dangnhapusertructrac() {
        login("performance_glitch_user", "secret_sauce");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement shoppingCard = driver.findElement(By.id("shopping_cart_container"));
        Assert.assertTrue(shoppingCard.isDisplayed());
        }


    @After
    public void tearDown() {
        driver.quit();
    }

   /* @Test
    public void testcase2() {
        System.setProperty("webdriver.ghecko.driver","D:\\Auto\\webdriver\\gheckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get();
    }*/
    public void  login(String username, String password) {
        WebElement txtUsername = driver.findElement(By.id("user-name"));
        WebElement txtPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.id("login-button"));
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }


}
