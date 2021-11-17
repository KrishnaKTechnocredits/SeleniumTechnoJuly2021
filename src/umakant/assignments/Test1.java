/*
 Selenium Test – 1 : 16th Nov’2021
Step – 1 : Go to https://www.snapdeal.com/
Step -2 : Move over on Sign In button
Step – 3 : Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order.
 
Note : For Step 3, Write a separate method to return List of Menu text [Your Account, Your Orders, Shortlist, SD Cash] ie. ArrayList<String>.
Hint : You should have expected Menu list text [ArrayList<String>], which should be compared with actual Menu List text. Compare both list using equals method of Assert. 

 */
package umakant.assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	
	@Test
	public void verifyMenuList() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP - Enter the SnapDeal url");
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		WebElement elem = driver.findElement(By.xpath("//div[@class='accountInner']"));
		System.out.println("STEP - Hover over the Sign In");
		action.moveToElement(elem).perform();
		List<WebElement> elemList = driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']//li/a"));
		ArrayList<String> actualList = new ArrayList<String>();
		System.out.println("STEP - Create the menu list");
		for(WebElement element : elemList) 
			actualList.add(element.getText());
		ArrayList<String> expectedList = new ArrayList<String>();
		expectedList.add("Your Account");
		expectedList.add("Your Orders");
		expectedList.add("Shortlist");
		expectedList.add("SD Cash");
		System.out.println("STEP - verify the menu list");
		Assert.assertEquals(actualList, expectedList,"Menu List does not match");
		driver.close();
	}

}
