package monali.SeleniumTest_1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class SeleniumTest_1_Snapdeal {

	private static WebDriver driver;
	
	@BeforeMethod
	public WebDriver setup() {
		System.out.println("Launch Snapdeal url");
		driver=PredefinedActions.start("https://www.snapdeal.com/");
		return driver;
	}
	
	@Test
	public void verifyMenusUnderSignIn() {
		Actions action=new Actions(driver);
		System.out.println("STEP: Go to Sign in menu(mouse hover)");
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Sign In']"))).build().perform();
		System.out.println("STEP : get List of menus under sign in option");
		List<WebElement> element=driver.findElements(By.xpath("//div//span[text()='Sign In']//following-sibling::div//div[2]//ul/li/a"));
		List<String> actualList= getTextMenusUnderSignIn(element);
		System.out.println("STEP : get list Expected List menus");
		ArrayList<String> expectedList=new ArrayList<String>();
		expectedList.add("Your Account");
		expectedList.add("Your Orders");
		expectedList.add("Shortlist");
		expectedList.add("SD Cash");
		
		System.out.println("STEP : Verify actual and expected List");
		Assert.assertEquals(actualList, expectedList, "Actual and Expected List mismatches");
	}
	
	@Test 
	public ArrayList<String> getTextMenusUnderSignIn(List<WebElement> list) {
		System.out.println("STEP: Get List of menus under sign in ");
		ArrayList<String> actualList=new ArrayList<String>();
		
		for(WebElement e:list) {
			actualList.add(e.getText());
		}
		return actualList;
		
	}
	
	
}
