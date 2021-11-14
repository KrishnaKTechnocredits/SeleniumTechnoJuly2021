package ritabrata_bhattacharyya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment_2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath("//*[@name='email_create']")).sendKeys("r.bhattacharyya96@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id=\"id_gender1\"]")).click();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Ritabrata");
		driver.findElement(By.id("customer_lastname")).sendKeys("Pawar");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Pass@123");
		WebElement day=driver.findElement(By.xpath("//select[@id='days']"));
		Select sl=new Select(day);
		sl.selectByValue("12");
		
		WebElement months=driver.findElement(By.xpath("//select[@name='months']"));
		Select slMonth=new Select(months);
		slMonth.selectByValue("12");
		
		WebElement year=driver.findElement(By.xpath("//select[@name='years']"));
		Select slyears=new Select(year);
		slyears.selectByValue("1996");
		
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Techno");
		
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Action Area 2");
		
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("New Town");
		
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Kolkata");
		
		WebElement state=driver.findElement(By.id("id_state"));
		Select slState=new Select(state);
		slState.selectByIndex(2);
		
		driver.findElement(By.name("postcode")).sendKeys("700156");
		
		
		driver.findElement(By.xpath("//textarea[@name='other']")).sendKeys("This is another info");
		
		driver.findElement(By.id("phone")).sendKeys("033-12345678");
		
		driver.findElement(By.id("phone_mobile")).sendKeys("9382550066");
		
		driver.findElement(By.xpath("//input[@value='My address']")).clear();
		
		driver.findElement(By.xpath("//input[@value='My address']")).sendKeys("Golapbag, Burdwan");
		
		Thread.sleep(3000);
		
	}

}
