/* Selenium Test – 1 : 16th Nov’2021
Step – 1 : Go to https://www.snapdeal.com/
Step -2 : Move over on Sign In button
Step – 3 : Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order.
Note : For Step 3, Write a separate method to return List of Menu text [Your Account, Your Orders, Shortlist, SD Cash] ie. ArrayList<String>.
Hint : You should have expected Menu list text [ArrayList<String>], which should be compared with actual Menu List text. 
Compare both list using equals method of Assert. */

package akansha_Jain;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest1 {
	WebDriver driver;

	@BeforeMethod
	public void startBrowser() {
		System.out.println("STEP- Open chrome browser");
		System.setProperty("webdriver.chrome.driver", ".//resources//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP- Open URL");
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void moveToSignIn() {
		WebElement signin = driver.findElement(By.xpath("//span[text()='Sign In']"));
		Actions action = new Actions(driver);
		action.moveToElement(signin).perform();
	}
	
	public ArrayList<String> getMenuList() {
		ArrayList<String> actualMenuList = new ArrayList<>();
		int totalRows = driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']/div/ul/li")).size();
		for(int index=1;index<=totalRows;index++) {
			String optionName = driver.findElement(By.xpath("//div[@class='dropdownAccountNonLoggedIn']/div/ul/li["+index+"]")).getText();
			actualMenuList.add(optionName);
		}
		return actualMenuList;
	}
	
	@Test
	public void testCase() throws InterruptedException {
		System.out.println("STEP- Move over to Sign In Option");
		moveToSignIn();
		System.out.println("STEP- Get list of Menu options");
		ArrayList<String> expectedMenuList = new ArrayList<>();
		expectedMenuList.add("Your Account");
		expectedMenuList.add("Your Orders");
		expectedMenuList.add("Shortlist");
		expectedMenuList.add("SD Cash");
		ArrayList<String> actualMenuList = getMenuList();
		System.out.println("List of menu options- " + actualMenuList);
		Assert.assertEquals(actualMenuList, expectedMenuList);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}