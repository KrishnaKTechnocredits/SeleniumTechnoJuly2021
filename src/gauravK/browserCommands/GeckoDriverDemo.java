package gauravK.browserCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GeckoDriverDemo {

    String driverPath = "D:\\Guru99Demo\\GeckoDriver.exe";
    public WebDriver driver;

    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver", "./resources/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);

    }
    
    public void navigateToUrl() {
        driver.get("http://demo.guru99.com/selenium/guru99home/");
    }

    public void endTest() {
        driver.quit();
    }

}