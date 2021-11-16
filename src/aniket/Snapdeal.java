package aniket;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Snapdeal {
	WebDriver driver;

	@BeforeClass
	public void initialiseDriver() {
		System.out.println("STEP : Launch ChromeDriver");
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public List<String> ListOfMenuText(WebDriver driver) {
		List<String> ListOfMenuText = new ArrayList<String>();
		List<WebElement> actualListElement = driver
				.findElements(By.xpath("//div[@class='accountInfoNonLoggedIn']//preceding-sibling::div//a"));

		for (WebElement list : actualListElement) {
			ListOfMenuText.add(list.getText());
		}
		System.out.println("List of Elements: " + ListOfMenuText);
		return ListOfMenuText;
	}

	@Test
	public void verifyMenuTextElement() {
		System.out.println("STEP : Navigate to Snapdeal website");
		driver.get(" https://www.snapdeal.com/");
		System.out.println("STEP :Move over on Sign In button");
		WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In']"));
		Actions action = new Actions(driver);
		action.moveToElement(signIn).build().perform();

		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Your Account");
		expectedList.add("Your Orders");
		expectedList.add("Shortlist");
		expectedList.add("SD Cash");
		// expectedList.add("login");
		List<String> actualList = ListOfMenuText(driver);
		System.out.println("VERIFY : List of Elements ");
		Assert.assertEquals(actualList, expectedList, "List is not matching");
		// System.out.println("Test Passed ");

	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();

	}

}