package madhavi;
import java.util.ArrayList;
import java.util.List;
/*Selenium Test – 1 : 16th Nov’2021
Step – 1 : Go to https://www.snapdeal.com/
Step -2 : Move over on Sign In button
Step – 3 : Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order.
*/
import java.util.concurrent.TimeUnit;
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
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP1 : Launch Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public ArrayList<String> menutext() {
		System.out.println("STEP2 : Click on SignIn");
		Actions action = new Actions(driver);
		WebElement sign_In = driver.findElement(By.xpath("//*[text()='Sign In']"));
		action.moveToElement(sign_In)
		.perform();

		System.out.println("STEP3 : Get Menu Text Options");
		ArrayList<String> menuTextList = new ArrayList<>();
		List<WebElement> list = driver
				.findElements(By.xpath("//div[contains(@class,'dropdownWrapper')]/div[2]/div/ul/li"));
		for (int index = 0; index < list.size(); index++) {
			menuTextList.add(list.get(index).getText());
		}
		return menuTextList;
	}

	@Test(priority = 2)
	public void verfiyManutextOptions() {
		ArrayList<String> actualmenuTextList = menutext();
		ArrayList<String> expectedmenuTextList = new ArrayList<String>();
		System.out.println("STEP4 : Get Menu Text Options");
		expectedmenuTextList.add("Your Account");
		expectedmenuTextList.add("Your Orders");
		expectedmenuTextList.add("Shortlist");
		expectedmenuTextList.add("SD Cash");
		System.out.println("Test verification is done");
		Assert.assertEquals(actualmenuTextList, expectedmenuTextList);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}