package varun;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Selenium_Test_1 {
	
	WebDriver driver;
	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP1 : Launch Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Test case 1:- User lands on Snapdeal website");
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void snapDeal() throws InterruptedException {
		System.out.println("Test case 2:- Verify that user reaches on Sign In button");
		WebElement signIn = driver.findElement(By.xpath("//div[@class='accountInner']"));
		Actions action = new Actions(driver);
		action.moveToElement(signIn).perform();
		System.out.println("Test Case 3:- Get the list of all the dropdown values");
		List<WebElement> dropdownValues = driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']//div[@class='accountList']/ul/li"));
		System.out.println(dropdownValues);
		List<String> actualNameList = getDropDownList(dropdownValues);
		List<String> expectedNameList = new ArrayList<String>();
		expectedNameList.add("Your Account");
		expectedNameList.add("Your Orders");
		expectedNameList.add("Shortlist");
		expectedNameList.add("SD Cash");
		Assert.assertEquals(actualNameList, expectedNameList, "List data is not matching");
		System.out.println(actualNameList);
	}
	
	List<String> getDropDownList(List<WebElement> element){
		List<String> list = new ArrayList<String>();
		for(WebElement wb : element) {
			list.add(wb.getText());
		}
		return list;
	}
}
