package gauravK.Selenium_Test_1;

import java.util.ArrayList;
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

public class SnapdealTesting {
	WebDriver driver;
	
	@BeforeClass
	void initiation() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Loading the webpage.");
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@Test
	void verifySnapdeal() {
		System.out.println("Mouse hover on Sign In.");
		WebElement hoverSignIn = driver.findElement(By.xpath("//span[text()='Sign In']"));
		//String abc = hoverSignIn.getText();
		//System.out.println(abc);
		Actions act = new Actions(driver);
		act.moveToElement(hoverSignIn)
		//.build()
		.perform();
		
		System.out.println("Locating the list.");
		String listLocator = "//div//span[text()='Sign In']//following-sibling::div/div[2]/div/ul/li/a";
		ArrayList<WebElement> list = (ArrayList<WebElement>)driver.findElements(By.xpath(listLocator));
		System.out.println("Converting list of obtained elements to list of string.");
		ArrayList<String> obtainedList = extractList(list);
		System.out.println("List provided to testers to check.");
		ArrayList<String> providedList = new ArrayList<String>();
		providedList.add("Your Account");
		providedList.add("Your Orders");
		providedList.add("Shortlist");
		providedList.add("SD Cash");
		
		System.out.println("Comparing the contents using Assert.");
		Assert.assertEquals(obtainedList, providedList);
	}
	
	ArrayList<String> extractList(ArrayList<WebElement> weblist){
		ArrayList<String> listWords = new ArrayList<>();
		for(WebElement s: weblist) {
			listWords.add(s.getText());
		}
		return listWords;		
	}
	
	@AfterClass
	void teardown() {
		driver.close();
	}
}
