package amol_P.Assignment_12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredifineAction {
	public static  WebDriver start() {
		System.setProperty("webdriver.chrome.driver","./resources//chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		System.out.println("Step 1- Open Browser");
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
}
}