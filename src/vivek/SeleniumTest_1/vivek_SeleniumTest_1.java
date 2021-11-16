package vivek.SeleniumTest_1;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class vivek_SeleniumTest_1 {

	WebDriver driver;

	@BeforeTest
	public WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		System.out.println("STEP - Open Snapdeal website");
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		return driver;
	}

	@Test
	public void verifySignIn() {
		System.out.println("STEP - Navigate to Sign in");
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		System.out.println("STEP - Get the actual drop down list");
		ArrayList<String> actualDropdown = new ArrayList<>();
		List<WebElement> dropdownList = driver
				.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']//ul/li"));
		for (int index = 0; index < dropdownList.size(); index++) {
			actualDropdown.add(dropdownList.get(index).getText());
		}
		ArrayList<String> expectedDropdown = new ArrayList<>();
		expectedDropdown.add("Your Account");
		expectedDropdown.add("Your Orders");
		expectedDropdown.add("Shortlist");
		expectedDropdown.add("SD Cash");
		System.out.println("STEP - Verify actual dropdown with the expected dropdown");
		Assert.assertEquals(actualDropdown, expectedDropdown);
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
