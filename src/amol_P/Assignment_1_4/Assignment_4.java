package amol_P.Assignment_1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\OS (D)\\Techno\\June_Programmes\\Java_Selenium_July21\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Amol");
		
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("test@yahoo.com");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("dsf2432sword@32123");
		
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8983424624");
		
		WebElement month=driver.findElement(By.xpath("//select[@id='usernamereg-month']"));
		Select slMonth= new Select(month);
		slMonth.selectByVisibleText("February");
		
		driver.findElement(By.xpath("//input[@name='dd']")).sendKeys("11");
		
		driver.findElement(By.xpath("//input[@name='yyyy']")).sendKeys("1993");
		
		driver.findElement(By.xpath("//input[@name='freeformGender']")).sendKeys("Male");
		
		
		

	}

}
