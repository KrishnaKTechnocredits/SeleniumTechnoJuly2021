package shantanu.selenium_test;

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

public class Selenium_test {
	WebDriver driver;
	
	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		System.out.println("STEP - Enter url");
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
	}
	
	ArrayList<String> expectedMenuList(){
		ArrayList<String> expectedMenuList = new ArrayList();
		expectedMenuList.add("Your Account");
		expectedMenuList.add("Your Orders");
		expectedMenuList.add("Shortlist");
		expectedMenuList.add("SD Cash");
		return expectedMenuList;
	}
	
	ArrayList<String> actualMenuList(){
		ArrayList<String> actualMenuList = new ArrayList();
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//span[text()='Sign In']"));
		action.moveToElement(element).build().perform();
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']/div[@class='accountList']/ul//li/a"));
		for(WebElement e : options) {
			actualMenuList.add(e.getText());
		}
		return actualMenuList;
	}
	
	@Test
	void checkMenuListTest() {
		Assert.assertEquals(expectedMenuList(), actualMenuList());
	}
	
	@AfterMethod
	void tearDown() {
		driver.close();
	}
	
}
