package bacdd.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait= new WebDriverWait(driver,10);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitForSec(int time){
        try {
            Thread.sleep(time* 1000L);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementIsClickAble(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
