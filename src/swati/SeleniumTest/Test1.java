package swati.SeleniumTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {

	WebDriver driver;
	
	@BeforeMethod
	void startup() {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("Step – 1 : Go to https://www.snapdeal.com/");
		driver.get(" https://www.snapdeal.com/");
		driver.manage().window().maximize();		
	}
	
	
	void MoveOverOnSignIn() {
		WebElement signIn=driver.findElement(By.xpath("//*[text()='Sign In']"));
		Actions action =new Actions(driver);
		action.moveToElement(signIn).perform();	
	}
	
	List<String> getMenuList() {
		List<String> menuList=new ArrayList<String>();
		int count=driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']//ul//li")).size();
		for(int index=1;index<=count;index++) {
			String dropDownOption=driver.findElement(By.xpath("//div[@class='dropdownAccountNonLoggedIn']//ul//li["+index+"]")).getText();
			menuList.add(dropDownOption);
		}
		
		return menuList;
	}
	
	@Test
	void verifyMenuList() {
		System.out.println("Step -2 : Move over on Sign In button");
		MoveOverOnSignIn();
		System.out.println("Step – 3 : Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order.");
		List<String> expected=new ArrayList<String>();
		List<String> actual=new ArrayList<String>();
		expected.add("Your Account");
		expected.add("Your Orders");
		expected.add("Shortlist");
		expected.add("SD Cash");
		actual=getMenuList();
		Assert.assertTrue(expected.equals(actual));
	}
	
	@AfterMethod
	void tearDown() {
		driver.close();
	}
}
