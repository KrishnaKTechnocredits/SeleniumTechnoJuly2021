package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	public static WebDriver start(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP - Enter url");
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP - Enter url");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		return driver;
	}
}
