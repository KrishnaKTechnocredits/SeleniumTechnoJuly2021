package elizabeth.Selenium_Test_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SeleniumTest1 {
	
	WebDriver driver;
	SoftAssert soft =new SoftAssert();
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("Step: Launch Browser");
		driver=new ChromeDriver();
		System.out.println("Step: Go to https://www.snapdeal.com/");
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void verifySignInButton(){
		System.out.println("Step: Mouse Hover on Sign In button");
		Actions action=new Actions(driver);
		WebElement signIn=driver.findElement(By.xpath("//*[text()='Sign In']"));
		action.moveToElement(signIn).build().perform();
		System.out.println("Step: Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order.");
		List<WebElement> menu=driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']//li"));
		ArrayList<String> actualMenu=new ArrayList<String>();
		for(WebElement menuName:menu) {
			String name=menuName.getText();
			actualMenu.add(name);
		}
		System.out.println("Actual Menu List: " +actualMenu);
		ArrayList<String> expectedMenu=new ArrayList<String>();
		expectedMenu.add("Your Account");
		expectedMenu.add("Your Orders");
		expectedMenu.add("Shortlist");
		expectedMenu.add("SD Cash");
		soft.assertEquals(actualMenu, expectedMenu);
	}

}
