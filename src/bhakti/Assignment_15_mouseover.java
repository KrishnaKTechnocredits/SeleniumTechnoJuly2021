/*Assignment 15 : Actions class
Steps
1. Navigate to to flipkart
2. Mouse hover on `Home`
3. Mouse hover Under Living Room section 
4. Click on `Blanket` or `any other option
*/

package bhakti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment_15_mouseover {

	WebDriver driver;
	@BeforeMethod
	void start() {
		
		//System.setProperty("webdriver.chrom.driver", "chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","D:\\backUp\\DELL\\Documents\\Automation\\WorkSpace\\SeleniumTechnoJuly2021\\resources\\chromedriver.exe");
		driver = new ChromeDriver(); 
		System.out.println("Step- Opening flipCard site");
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Step- closing popup");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

	}
	@AfterMethod
	void end() {
		driver.close();
	}

	@Test(priority = 1)
	void navigateToLivingroom_TVUnit() throws InterruptedException {
		
		System.out.println("Step- clicking on Home-> ");
		Actions action = new Actions(driver);
		WebElement home= driver.findElement(By.xpath("//div[text()='Home']"));
		action.moveToElement(home).build().perform();
		
		System.out.println("Step- clicking on Home-> Living room");
		WebElement livingRoom= driver.findElement(By.xpath("//a[text()='Living Room']"));
		action.moveToElement(livingRoom).build().perform();
		System.out.println("Step- clicking on Home-> Living room--> TV Units");
		WebElement TVUnit= driver.findElement(By.xpath("//a[text()='TV Units']"));
		action.moveToElement(TVUnit).click().build().perform();
		Thread.sleep(3000);
		String excpected="TV Entertainment Units";
		String actual= driver.findElement(By.xpath("//div[@class='_3GIHBu']/a[text()='TV Entertainment Units']")).getText();
		Assert.assertEquals(actual, excpected);
		
		driver.navigate().back();

	}
	
	 @Test (priority = 2)
	void validateHome_FurnishingsList_SubOptions() {
		System.out.println("Step- clicking on Home-> ");
		Actions action = new Actions(driver);
		WebElement home= driver.findElement(By.xpath("//div[text()='Home']"));
		action.moveToElement(home).build().perform();
		System.out.println("Step- moving to Home_Furnishings");
		WebElement Home_Furnishings = driver.findElement(By.xpath("//a[text()='Home Furnishings']"));
		action.moveToElement(Home_Furnishings).build().perform();
		List<WebElement> options= driver.findElements(By.xpath("//div[@class='_3XS_gI']/a"));
		ArrayList <String> actualOptionlist= new ArrayList<String>();
		for (WebElement option: options ) {
			String name= option.getText();
			actualOptionlist.add(name);
		}
		ArrayList <String> expected= new ArrayList (Arrays.asList("All", "Bed Linens", "Bedsheets", "Blankets", "Curtains & Accessories", "Bath linen", "Floor coverings", "Covers & protectors", "Cushions & Pillows", "Kitchen Linen Sets", "Table Linen Sets", "Sofa & curtain fabrics", "Branded Collections"));
		System.out.println("Home_Furnishings> list"+actualOptionlist);
		Assert.assertEquals(actualOptionlist, expected);
		
	}
}
