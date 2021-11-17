package elizabeth.Assignment_15;

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

public class Assignment15 {
	
	WebDriver driver;
	SoftAssert soft=new SoftAssert();
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void mouseHoverAction() {
		Actions action =new Actions(driver);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		System.out.println("Step: Mouse Hover on Home");
		WebElement home=driver.findElement(By.xpath("//div[text()='Home']"));
		action.moveToElement(home).perform();
		System.out.println("Step: Mouse hover Under Living Room section");
		WebElement room=driver.findElement(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a[2]"));
		action.moveToElement(room).perform();
		int expectedCountOfItems=13;
		int actualCountOfItems=driver.findElements(By.xpath("//div[@class='_3XS_gI']//a")).size();
		List<WebElement> listOfItems=driver.findElements(By.xpath("//div[@class='_3XS_gI']//a"));
		ArrayList<String> actualListOfItems=new ArrayList<String>();
		for(WebElement items: listOfItems) {
			String item=items.getText();
			actualListOfItems.add(item);
			
		}
		ArrayList<String> expectedListOfItems= new ArrayList<String>();
		expectedListOfItems.add("All");
		expectedListOfItems.add("Sofas Sets & Sectionals");
		expectedListOfItems.add("TV Units");
		expectedListOfItems.add("Dining Sets");
		expectedListOfItems.add("Coffee Tables");
		expectedListOfItems.add("Sofa Beds");
		expectedListOfItems.add("Recliners");
		expectedListOfItems.add("Living Room Chairs");
		expectedListOfItems.add("Cabinet & Drawers");
		expectedListOfItems.add("Bookshelves");
		expectedListOfItems.add("Shoe Racks");
		expectedListOfItems.add("Office Tables");
		expectedListOfItems.add("Office Chairs");
		System.out.println("Actual list of items under the Living Room section is " +actualListOfItems);
		System.out.println("Actual count of items under the Living Room section is " +actualCountOfItems);
		soft.assertEquals(actualCountOfItems, expectedCountOfItems);
		soft.assertEquals(actualListOfItems, expectedListOfItems);
		
		System.out.println("Step: Click on 'Sofas Sets & Sectionals'");
		WebElement item=driver.findElement(By.xpath("//a[text()='Sofas Sets & Sectionals']"));
		action.click(item).build().perform();
		String expectedItem="Sofas & Sectionals";
		String actualItem=driver.findElement(By.xpath("//div[@class='TB_InB']//a[@title='Sofas & Sectionals']")).getText();
		System.out.println("Actual item selected is " +actualItem);
		soft.assertEquals(actualItem, expectedItem);
		soft.assertAll();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}


}
