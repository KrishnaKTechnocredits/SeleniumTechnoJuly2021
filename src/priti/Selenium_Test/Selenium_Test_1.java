package priti.Selenium_Test;

import java.util.ArrayList;
import java.util.List;

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
	public void start() {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		System.out.println("Step: launch Chrome bowser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step: launch url -https://www.snapdeal.com/");
		driver.get("https://www.snapdeal.com/");
	}
	
	public ArrayList<String> verifyMenulistOrder() {
		Actions action = new Actions(driver);
		System.out.println("Step: Mouse hover Sign In");
		WebElement singInElement = driver.findElement(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']"));
		action.moveToElement(singInElement).perform();
		System.out.println("Step: Find Menu List under Sing In");
		List<WebElement> listOFMenu = driver.findElements(By.xpath("//div[@class ='dropdownAccountNonLoggedIn']/div/ul/li"));
		ArrayList<String> ListOfMenuText= new ArrayList<String>();
		System.out.println("No of Menus in the Menu List under Sign In :" +listOFMenu.size());
		System.out.println("Verify that the order of menu list item's as: 1.Your Account, 2.Your Orders, 3.Shortlist, 4.SD Cash option is visible in the same order");
			for(WebElement menuElement:listOFMenu) {
				if (menuElement.isDisplayed())
					System.out.println(menuElement.getText());
					ListOfMenuText.add(menuElement.getText());
			}	
			
			return ListOfMenuText;
	}		
		
	@Test
	public void getMenuText() {
		
		ArrayList<String> actualListOfMenuText =verifyMenulistOrder();
		System.out.println("Actual List of Menu under Sing In:"+actualListOfMenuText);
		ArrayList<String> expListOfMenuText = new ArrayList<String>();
		expListOfMenuText.add("Your Account");
		expListOfMenuText.add("Your Orders");
		expListOfMenuText.add("Shortlist");
		expListOfMenuText.add("SD Cash");
		System.out.println("Expected List of Menu under Sing In:"+expListOfMenuText);
		Assert.assertEquals(actualListOfMenuText, expListOfMenuText, "Actual list and expected list of meun under Sing In does not macth");
		
	}
	

}
