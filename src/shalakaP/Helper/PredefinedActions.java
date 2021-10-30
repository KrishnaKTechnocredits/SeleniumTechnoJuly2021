package shalakaP.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	public static WebDriver start(String url) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		System.out.println("Step- Open Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step-Enter url");
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
		
		public static WebDriver start() {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			System.out.println("Step- Open Browser");
			WebDriver driver = new ChromeDriver();
			System.out.println("Step-Enter url");
			driver.get("http://automationbykrishna.com");
			driver.manage().window().maximize();
			return driver;
	}
}
