package technocredits.browserCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");// Navigate to URL
		
		driver.getTitle(); // returns String of Tab Name of browser
		
		driver.close();// close the current window
		
		driver.quit();//close all the browser which open from the current session
		
		driver.getCurrentUrl();// returns String hold the loaded url in browser
		
		driver.manage().window().maximize();//maximized the browser size
		
	}

}
