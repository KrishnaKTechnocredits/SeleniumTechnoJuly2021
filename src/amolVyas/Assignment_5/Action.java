package amolVyas.Assignment_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Action {
	
	static WebDriver start(String  url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome Browser opened");
		driver.manage().window().maximize();
		System.out.println("Open Given URL");
		driver.get(url);
		return driver;
	}
	
	static WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Open Chrome Browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Open Given URL");
		driver.get("http://automationbykrishna.com/index.html#");
		return driver;
		
	}

}
