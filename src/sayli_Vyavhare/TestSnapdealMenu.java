package sayli_Vyavhare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSnapdealMenu {
	WebDriver driver;
	@BeforeClass
	public void openURL(){
		
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step – 1 : Go to https://www.snapdeal.com/");
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public ArrayList<String> returnList(){
		ArrayList<String> actualList=new ArrayList<>();
		List<WebElement>  menu =driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']//ul/li"));
		for(int index=0;index<menu.size();index++) {
			actualList.add(menu.get(index).getText());
		}
		return actualList;
	}
	
	@Test
	public void CheckMenuList(){
		System.out.println("Step – 2 : Move over on Sign In button");
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		System.out.println("Step – 3 : Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order");
		ArrayList<String> actualList=returnList();
		String []expected= {"Your Account","Your Orders","Shortlist","SD Cash"};
		ArrayList<String> expectedList=new ArrayList<String>(Arrays.asList(expected));
		Assert.assertEquals(actualList, expectedList);	
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
}
