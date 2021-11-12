package akansha_Jain;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment_15 {
	WebDriver driver;
	
	@BeforeMethod
	public void startBrowser() {
		System.out.println("STEP- Open chrome browser");
		System.setProperty("webdriver.chrome.driver", ".//resources//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP- Open URL");
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	int getCountofOptionsInHomeFurnishings() throws InterruptedException {
		System.out.println("STEP- Click on cross icon");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		System.out.println("STEP- Mouse hover to home -> home furnishings -> get count of options in home furnishings");
		action.moveToElement(driver.findElement(By.xpath("//*[text()='Home']"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Living Room']"))).perform();
		int count = driver.findElements(By.xpath("//span[text()='more in Living Room']/parent::div/a")).size();
		System.out.println("Count of options in home furnishings are- " + count);
		return count;
	}
	
	@Test
	public void testCase() throws InterruptedException {
		Assert.assertEquals(getCountofOptionsInHomeFurnishings(), 13);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}