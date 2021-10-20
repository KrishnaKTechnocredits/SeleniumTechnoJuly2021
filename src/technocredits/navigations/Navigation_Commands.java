package technocredits.navigations;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation_Commands {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");// Navigate to URL
		
		driver.navigate().to("");
		
		try {
			driver.navigate().to(new URL(""));
		} catch (MalformedURLException e) {
		
		}
		
		
		
		driver.navigate().back();
		
		driver.navigate().refresh();
		
		driver.navigate().forward();
		
		/**
		 * How many ways to refresh the page
		 * 
		 * 1. driver.navigate().refresh();
		 * 2. driver.get(driver.getCurrentUrl())
		 * 3. back & fourth
		 * 4. driver.navigate().to(driver.getCurrentUrl();
		 * 5. from the key action f5
		 */
		
		
	}



}
