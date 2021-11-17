/*Selenium Test – 1 : 16th Nov’2021
Step – 1 : Go to https://www.snapdeal.com/
Step -2 : Move over on Sign In button
Step – 3 : Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order.
*/
package monikaZ;

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

public class SeleniumTest_1 {

	WebDriver driver;
	@BeforeClass
	public void start() {
		System.out.println("STEP- Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP- Enter URL");
		driver.get("https://www.snapdeal.com/");
	}
	
	public ArrayList<String> menuTextList(){
	
		System.out.println("STEP- Move over on Sign In button");
		WebElement signIn = driver.findElement(By.xpath("//*[text()='Sign In']"));
		Actions actions =new Actions(driver);
		actions.moveToElement(signIn).perform();
		System.out.println("STEP- Display Menu Text");
		ArrayList<String> menuList=new ArrayList<String>();
		List<WebElement>list=driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']/div[@class='accountList']/ul//li/a"));
		for(WebElement we : list) {
			menuList.add(we.getText());
			
		}
		
		return menuList;
	}
	@Test
	public void testCase() {
		System.out.println("STEP : Verify Menu items");
		ArrayList<String> actualList = menuTextList();
		ArrayList<String> expectedList = new ArrayList<String>();
		expectedList.add("Your Account");
		expectedList.add("Your Orders");
		expectedList.add("Shortlist");
		expectedList.add("SD Cash");
		Assert.assertEquals(actualList, expectedList, "List not match");
	}

	@AfterClass
	public void teardown() {
		driver.close();
	}
}
