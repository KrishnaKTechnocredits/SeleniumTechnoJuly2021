package madhavi;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*Assignment 15 : Actions class
Steps
1. Navigate to to flipkart
2. Mouse hover on `Home`
3. Mouse hover Under Living Room section 
4. Click on `Blanket` or `any other option`*/
public class Assignment_15 {
	WebDriver driver;

	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP1 : Launch Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.flipkart.com/");
		System.out.println("STEP : Close login Screen");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	void navigateToTVUnits() {
		System.out.println("STEP2 : Click on Home");
		Actions action = new Actions(driver);
		WebElement home = driver.findElement(By.xpath("//*[text()='Home']"));
		action.moveToElement(home)
	    .perform();
	
		WebElement livingRoom = driver.findElement(By.xpath("//a[text()='Living Room']"));
		action.moveToElement(livingRoom)
		.build()
		.perform();
		int actualListCount = driver.findElements(By.xpath("//span[text()='more in Living Room']/parent::div/a"))
				.size();

		int expectedCount = 13;
		System.out.println("Test verification is done");
		Assert.assertEquals(actualListCount, expectedCount);
		WebElement elementvUnits = driver.findElement(By.xpath("//a[text()='TV Units']"));
		action.click(elementvUnits).perform();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
