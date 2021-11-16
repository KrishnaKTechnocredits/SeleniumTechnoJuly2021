/*Selenium Test – 1 : 16th Nov’2021
Step – 1 : Go to https://www.snapdeal.com/
Step -2 : Move over on Sign In button
Step – 3 : Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order.
*/

package purshottamJoshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Purshottam_SeleniumTest1 {
	
	@Test
	void automateSnapDeal() {
		
		WebDriver driver = PredefinedActions.start("https://www.snapdeal.com/");
		
		System.out.println("STEP - Click on sign in ");
		driver.findElement(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']")).click();
		
		System.out.println("STEP - Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order.");
		
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']//ul/li"));
		List<String> actualMenuList = getActualMenuList(element);
		String[] arr = {"Your Account","Your Orders","Shortlist","SD Cash"};
		List<String> expectedMenuList = new ArrayList<>(Arrays.asList(arr));
		Assert.assertEquals(actualMenuList, expectedMenuList);
		
		driver.close();
	}

	List<String> getActualMenuList(List<WebElement> element){
		
		List<String> al = new ArrayList<>();
		for (int index = 0; index < element.size(); index++) {
			al.add(element.get(index).getText());
		}
		
		return al;
	}
	
}
