package amolVyas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import amolVyas.Assignment_5.Action;

public class SeleniumTest_1 {
	
	@Test
	void verifyDropdownUnderSignIn() throws InterruptedException {
		WebDriver driver = Action.start("https://www.snapdeal.com/");
		Actions actions = new Actions(driver);
		System.out.println("STEP-Hover to Sign In");
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='accountInner']"))).perform();
		System.out.println("STEP-Get the text of all items under SignIn");
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='dropdownWrapper']/div[@class='dropdownAccountNonLoggedIn']//li"));
		List<String> actualNameList = getTextFromWebElementList(element);
		List<String> expectedNameList = new ArrayList();
		expectedNameList.add("Your Account");
		expectedNameList.add("Your Orders");
		expectedNameList.add("Shortlist");
		expectedNameList.add("SD Cash");
		Assert.assertEquals(actualNameList, expectedNameList,"Data not matched");
		driver.quit();
	}
	
	List<String> getTextFromWebElementList(List<WebElement> element){
		List<String> list = new ArrayList();
		for(WebElement wb : element) {
			list.add(wb.getText());
		}
		return list;
	}
	}
