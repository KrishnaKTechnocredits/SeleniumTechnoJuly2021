package amol_P.Assignment_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredifineAction {
	
	public static  WebDriver start() {
	System.setProperty("webdriver.chrome.driver","./resources//chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	System.out.println("Step 1- Open Browser");
	driver.get("http://automationbykrishna.com/index.html#");
	driver.manage().window().maximize();
	
	return driver;
	}
}
