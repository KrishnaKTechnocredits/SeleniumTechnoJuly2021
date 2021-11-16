package dattaraj_W.dattaraj_Selenium_Test;

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

public class Selenium_Test1 {
	
	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() throws InterruptedException {
		System.out.println("STEP- Open chrome browser");
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP- Open URL");
		driver.get("https://www.snapdeal.com/");
	}
	
	public ArrayList<String> menuTextList() {

		System.out.println("STEP : Move over on sign in button");
		WebElement signIn = driver.findElement(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(signIn).perform();

		System.out.println("STEP : Get menu text");
		ArrayList<String> menuList = new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'dropdownWrapper')]/div[2]/div/ul/li"));
		for (int index = 0; index < list.size(); index++) {
			menuList.add(list.get(index).getText());
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
	void closeBrowser() {
		driver.close();
	}
}
