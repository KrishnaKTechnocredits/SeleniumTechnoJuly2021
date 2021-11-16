/*Selenium Test – 1 : 16th Nov’2021
Step – 1 : Go to https://www.snapdeal.com/
Step -2 : Move over on Sign In button
Step – 3 : Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order.
Note : For Step 3, Write a separate method to return List of Menu text [Your Account, Your Orders, Shortlist, SD Cash] ie. ArrayList<String>.
Hint : You should have expected Menu list text [ArrayList<String>], which should be compared with actual Menu List text. Compare both list using equals method of Assert. 
*/


package bhakti;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
////div[@class='dropdownAccountNonLoggedIn']//div[@class='accountList']/ul/li
public class Test1 {
 
	@Test
	void verifySinginMenu() {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		System.out.println("Step – 1 : Go to https://www.snapdeal.com/");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.snapdeal.com");
		driver.manage().window().maximize();
		System.out.println("Step -2 : Move over on Sign In button");
		Actions actions= new Actions(driver);
		WebElement singin= driver.findElement(By.xpath("//div[@class='accountInner']/span[text()='Sign In']"));
		actions.moveToElement(singin).build().perform();
		System.out.println("Step – 3 : Verify Your Account, Your Orders, Shortlist, SD Cash option is visible in the same order.");
		System.out.println("Step 3.1: find actaul list on Sing in");
		ArrayList<String> excpectedList= new ArrayList(Arrays.asList("Your Account", "Your Orders", "Shortlist", "SD Cash"));
		List<WebElement> menuList= driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']//div[@class='accountList']//a"));
		ArrayList <String> actualList= new ArrayList();
		actualList=getArrayList(menuList);
		System.out.println("Actual list-> "+actualList);
		Assert.assertEquals(actualList,excpectedList);
		System.out.println("Step 4: test end");
		driver.quit();
	}
	
	ArrayList<String> getArrayList(List<WebElement> menuList){
		ArrayList <String> actualList= new ArrayList();
		for (WebElement menu: menuList) {
			actualList.add(menu.getText());
		}
		return actualList;
	}
}
