/*Selenium Test – 1 : 16th Nov’2021
Step – 1 : Go to https://www.snapdeal.com/
Step -2  : Move over on Sign In button
Step – 3 : Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order.
 
Note : For Step 3, Write a separate method to return List of Menu text [Your Account, Your Orders, Shortlist, SD Cash] ie. ArrayList<String>.
Hint : You should have expected Menu list text [ArrayList<String>], which should be compared with actual Menu List text. Compare both list using equals method of Assert. 
*/

package ritabrata_bhattacharyya.Selenium_Test_1;

import java.util.ArrayList;
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


public class Ritabrata_Test_1 {
	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP 1: Launch Browser");
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@Test
	void testStep3() {
		Actions action = new Actions(driver);
		System.out.println("Step 3: Hover over the Sign In menu");
		action.moveToElement(driver.findElement(By.xpath("//div//span[text()='Sign In']"))).build().perform();
		String locator = "//div//span[text()='Sign In']//following-sibling::div//div[2]//ul/li/a";
		List<WebElement> list = driver.findElements(By.xpath(locator));
		List<String> actualList = testStep3GetMenu(list);
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Your Account");
		expectedList.add("Your Orders");
		expectedList.add("Shortlist");
		expectedList.add("SD Cash");
		Assert.assertEquals(actualList, expectedList);
		System.out.println("Test cases passed successfully");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	public List<String> testStep3GetMenu(List<WebElement> list) {
		System.out.println("Step 4: Get the menu options under Sign In");
		List<String> actualList = new ArrayList<String>();
		for (WebElement element: list) {
			actualList.add(element.getText());	
		}
		return actualList;
		
	}
	@AfterClass
	void releaseResources() {
		driver.close();
	}
	
}
