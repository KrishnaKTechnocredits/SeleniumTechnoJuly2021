package amol_P.Assignment_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefineAction 
{
	public static WebDriver start() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Step 1- Launch Browser and redirect to site");
		driver.get("http://automationbykrishna.com/index.html#");
		driver.manage().window().maximize();
		System.out.println("Step 2- Click on Demo Table");
		driver.findElement(By.id("demotable")).click();
		Thread.sleep(2000);
		return driver;
		
	}
	
}
