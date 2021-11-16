package parthavD;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selenium_Test1 {
	
	private static WebDriver driver;
	
	@BeforeMethod
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Step - Launching SnapDeal URL");
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void verifyMenuUnderSignIn() {
		Actions action = new Actions(driver);
		System.out.println("Step - Hover over the Sign In menu");
		action.moveToElement(driver.findElement(By.xpath("//div//span[text()='Sign In']"))).build().perform();
		String locator = "//div//span[text()='Sign In']//following-sibling::div//div[2]//ul/li/a";
		List<WebElement> list = driver.findElements(By.xpath(locator));
		List<String> actualList = getMenuListUnderSignIn(list);
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Your Account");
		expectedList.add("Your Orders");
		expectedList.add("Shortlist");
		expectedList.add("SD Cash");
		Assert.assertEquals(actualList, expectedList);
		System.out.println("Test case passed successfully");
		
	}

	public List<String> getMenuListUnderSignIn(List<WebElement> list){
		System.out.println("Step - Get the menu options under Sign-In");
		List<String> actualList = new ArrayList<String>();
		for (WebElement element: list) {
			actualList.add(element.getText());	
		}
		return actualList;
	}
	
	@AfterMethod
	void tearDown() {
		driver.close();
	}

}
