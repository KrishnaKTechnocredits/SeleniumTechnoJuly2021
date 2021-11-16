package shalakaP.Test1;

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

public class SigninOnSnapdeal {
	WebDriver driver;

	@BeforeMethod
	public void signIn() {
		System.out.println("STEP-Enter Url");
		driver = PredefinedActions.start("https://www.snapdeal.com/");
		System.out.println("STEP-Move over on Sign In button");
		WebElement signinElement = driver.findElement(By.xpath("//span[text()='Sign In']"));
		Actions action = new Actions(driver);
		action.moveToElement(signinElement).build().perform();
	}

	ArrayList<String> actualMenuList() {
		ArrayList<String> actualMenuList = new ArrayList<String>();
		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']/div/ul/li/a"));
		for (WebElement menuName : elements) {
			actualMenuList.add(menuName.getText());
		}
		return actualMenuList;
	}

	ArrayList<String> expectedMenuList() {
		ArrayList<String> expectedMenuList = new ArrayList<String>();
		expectedMenuList.add("Your Account");
		expectedMenuList.add("Your Orders");
		expectedMenuList.add("Shortlist");
		expectedMenuList.add("SD Cash");
		return expectedMenuList;
	}

	@Test
	public void verifyMenuList() {
		System.out.println(
				"STEP-Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order");
		Assert.assertEquals(actualMenuList(), expectedMenuList());
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
