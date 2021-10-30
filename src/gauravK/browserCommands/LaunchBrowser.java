package gauravK.browserCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LaunchBrowser {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\TEST\\eclipse-workspace\\Java_Techno_Selenium_2021\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://www.google.com/");
		driver.get("http://www.reading.ac.uk/");
		//driver.get("C:\\Users\\TEST\\eclipse-workspace\\Java_Techno_Selenium_2021");
		//driver.close();
		System.out.println("Page Title is : "+driver.getTitle());
		driver.quit();
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\TEST\\eclipse-workspace\\Java_Techno_Selenium_2021\\geckodriver.exe");
        //FirefoxOptions options = new FirefoxOptions();
        //options.setBinary("C:\\Users\\TEST\\Downloads\\Portable apps installation folder\\PortableApps\\FirefoxPortable\\FirefoxPortable.exe");
        //WebDriver driver =  new FirefoxDriver();
        //driver.get("https://www.reading.ac.uk/");
        
        //driver.quit();
		
		
	}

}
