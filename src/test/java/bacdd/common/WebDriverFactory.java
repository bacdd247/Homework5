package bacdd.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class WebDriverFactory {
    public static WebDriver createDriver() {
        String browser = System.getProperty("browser", "chrome");

        switch(browser) {
            case "firefox" :
                WebDriverManager.getInstance(FIREFOX).setup();
                return new FirefoxDriver();
            case "chrome":
                WebDriverManager.getInstance(CHROME).setup();
                return new ChromeDriver();
            default:
                throw new RuntimeException("Unsupported webdriver: " + browser);
        }
    }
}
