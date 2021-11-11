package margi.Assignment_15;

import java.util.List;
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

public class Assignment_15 {

	WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("STEP : Launch Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public int getSizeOfList() throws InterruptedException {
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement home = driver.findElement(By.xpath("//div[@class='_37M3Pb']//div[6]"));
		actions.moveToElement(home).perform();
		WebElement livingRoom = driver.findElement(By.xpath("//a[text()='Living Room']"));
		actions.moveToElement(livingRoom).perform();
		List<WebElement> listOfItems = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		int size = listOfItems.size();
		System.out.println("List size of Living Room items are: " + size);
		return size;
	}

	@Test
	public void verifyListOfItems() throws InterruptedException {
		int actualSize = getSizeOfList();
		int expectedSize = 13;
		Assert.assertEquals(actualSize, expectedSize, "Invalid number of size");
	}

	@AfterClass
	public void releaseResources() {
		driver.close();
	}
}
