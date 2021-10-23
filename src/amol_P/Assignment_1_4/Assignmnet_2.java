package amol_P.Assignment_1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignmnet_2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\OS (D)\\Techno\\June_Programmes\\Java_Selenium_July21\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath("//*[@name='email_create']")).sendKeys("te34st@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Amol");
		driver.findElement(By.id("customer_lastname")).sendKeys("Pawar");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Password@123");
		
		WebElement day=driver.findElement(By.xpath("//select[@id='days']"));
		Select sl=new Select(day);
		sl.selectByValue("1");
		
		WebElement months=driver.findElement(By.xpath("//select[@name='months']"));
		Select slMonth=new Select(months);
		slMonth.selectByValue("1");
		
		WebElement year=driver.findElement(By.xpath("//select[@name='years']"));
		Select slyears=new Select(year);
		slyears.selectByValue("1993");
		
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Techno");
		
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Pune");
		
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Mundhva");
		
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Pune");
		
		WebElement state=driver.findElement(By.id("id_state"));
		Select slState=new Select(state);
		slState.selectByIndex(2);
		
		driver.findElement(By.name("postcode")).sendKeys("402104");
		
		
		driver.findElement(By.xpath("//textarea[@name='other']")).sendKeys("This is my Other info");
		
		driver.findElement(By.id("phone")).sendKeys("22-323232");
		
		driver.findElement(By.id("phone_mobile")).sendKeys("9192929293");
		
		driver.findElement(By.xpath("//input[@value='My address']")).clear();
		
		driver.findElement(By.xpath("//input[@value='My address']")).sendKeys("This is address alias for future reference");
		
		Thread.sleep(2000);
		//driver.quit();
	}

}
