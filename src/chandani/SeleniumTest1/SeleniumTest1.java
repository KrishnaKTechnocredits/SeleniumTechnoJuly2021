/* Selenium Test – 1 : 16th Nov’2021
Step – 1 : Go to https://www.snapdeal.com/
Step -2 : Move over on Sign In button
Step – 3 : Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order.
Note : For Step 3, Write a separate method to return List of Menu text [Your Account, Your Orders, Shortlist, SD Cash] ie. ArrayList<String>.
Hint : You should have expected Menu list text [ArrayList<String>], which should be compared with actual Menu List text. 
Compare both list using equals method of Assert. */

package chandani.SeleniumTest1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class SeleniumTest1 {
	
	WebDriver driver;
	
	@BeforeMethod
	void setup() throws InterruptedException {
		driver = PredefinedActions.start("https://www.snapdeal.com/");
		System.out.println("STEP - Open Snapdeal website");
		Thread.sleep(3000);
	}
	

	public List<String> getMenuList(List<WebElement> list){
	ArrayList<String> listofMenuText = new ArrayList<String>();	
	//ArrayList<String> listofMenuText = new ArrayList<String>();	
	List<WebElement> menuList = driver
			.findElements(By.xpath("//div[contains(@class,'dropdownWrapper')]/div[2]/div/ul/li"));
	 
	 for(int index = 0; index < menuList.size();index++ ){
		listofMenuText.add(menuList.get(index).getText());
	}
	return listofMenuText;
	}
	
	@Test
	public void VerifyMenuText() {
       
		WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In']"));
		
		Actions action = new Actions(driver);
		action
		.moveToElement(signIn)
		.perform();
		
		List<WebElement> menuList = driver
				.findElements(By.xpath("//div[contains(@class,'dropdownWrapper')]/div[2]/div/ul/li"));
		List<String> actualList = getMenuList(menuList);
		System.out.println("Actual List is : " + actualList);
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Your Account");
		expectedList.add("Your Orders");
		expectedList.add("Shortlist");
		expectedList.add("SD Cash");
		System.out.println("Expected List is : " + expectedList);
		Assert.assertEquals(actualList, expectedList);
		System.out.println("Selenium Test 1 Passed Successfully");
		
	}
		
	@AfterMethod
	void tearingDown() {
		driver.close();
	}

}
