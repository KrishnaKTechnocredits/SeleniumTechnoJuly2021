package akansha_Jain.Assignment_11;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PreDefinedActions {
	static WebDriver driver;
	
	public static WebDriver start() {
		System.out.println("STEP- Open chrome browser");
		System.setProperty("webdriver.chrome.driver", "//Users//punchh_akansha//eclipse-workspace//Java_Techno_Selenium_2021//resources//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP- Open URL");
		driver.get("http://automationbykrishna.com/index.html#");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("STEP- Open Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		return driver;
	}
}