package varun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_4 {
	
	void yahooSignUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step-1 Open Chrome Browser");
		System.out.println("STEP - Enter automation url");
		driver.get("https://login.yahoo.com/");
		
		System.out.println("Step-2 SignUp on Yahoo");
		driver.findElement(By.xpath("//p[@class='sign-up-link']")).click();
		Thread.sleep(3000);
		
		System.out.println("Step-3 Fill a sign up form");
		driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys("Varun");
		driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys("joshi");
		driver.findElement(By.xpath("//input[@id='usernamereg-yid']")).sendKeys("asweyhnb.ikjhn");
		driver.findElement(By.xpath("//input[@id='usernamereg-password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@id='usernamereg-phone']")).sendKeys("9851247851");
		
		System.out.println("Select DOB");
		System.out.println("STEP - Enter month of birth");
		WebElement yahooMonth = driver.findElement(By.id("usernamereg-month"));
		Select yahooMonthSelect = new Select(yahooMonth);
		yahooMonthSelect.selectByVisibleText("January");	
		
		driver.findElement(By.xpath("//input[@id='usernamereg-day']")).sendKeys("26");
		driver.findElement(By.xpath("//input[@id='usernamereg-year']")).sendKeys("1991");
		driver.findElement(By.xpath("//input[@class='usernamereg-freeformGender']")).sendKeys("Male");
		driver.findElement(By.id("reg-submit-button")).click();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Assignment_4 assignment_4 = new Assignment_4();
		assignment_4.yahooSignUp();
		System.out.println("Test Case Passed");
	}
}
