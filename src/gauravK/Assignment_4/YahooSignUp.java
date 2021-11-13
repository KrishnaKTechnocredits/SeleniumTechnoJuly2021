package gauravK.Assignment_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/*
 * Assignment - 4: 16th Oct'2021

Yahoo Signup.
https://login.yahoo.com/account/create?specId=yidReg

 */
public class YahooSignUp {
	//WebDriver driver;
	@Test
	public YahooSignUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Opening main webpage - Yahoo ");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		
	/*	System.out.println("STEP - clicking Accept All.");
		driver.findElement(By.xpath("//*[@name='agree']")).click();
		
		System.out.println("STEP - Clicking the mail link.");
		driver.findElement(By.xpath("//a[@id='ybarMailLink']")).click();
		Thread.sleep(5000);
		
		System.out.println("STEP - Clicking the signup link.");
		driver.findElement(By.xpath("//*[text()='Sign up']")).click();
		Thread.sleep(3000);
		
		
		
		System.out.println("STEP - clicking create account.");
		driver.findElement(By.xpath("//a[@id='createacc']")).click();
		Thread.sleep(3000);
	*/	
		System.out.println("STEP - Enter first name.");
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Gaurav");
		
		System.out.println("STEP - Enter last name.");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Kothadia");
		
		System.out.println("STEP - Enter email.");
		driver.findElement(By.name("yid")).sendKeys("abcdefghijkl679239");
		
		System.out.println("STEP - Enter password.");
		driver.findElement(By.name("password")).sendKeys("password123");
		
		System.out.println("STEP - selecting country code.");
		WebElement selectCountrycode = driver.findElement(By.xpath("//*[@name='shortCountryCode']"));
		Select selection = new Select(selectCountrycode);
		selection.selectByValue("GB");
		
		System.out.println("STEP - Enter phone.");
		driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("07516894281");
		
		System.out.println("STEP - selecting country code.");
		WebElement Countrycode = driver.findElement(By.xpath("//*[@name='shortCountryCode']"));
		Select selectCountry = new Select(Countrycode);
		selectCountry.selectByValue("GB");
		
		System.out.println("STEP - select birthday month.");
		Select selectbirthMonth = new Select(driver.findElement(By.xpath("//*[@name='mm']")));
		selectbirthMonth.selectByValue("10");
		
		System.out.println("STEP - enter birthday date.");
		driver.findElement(By.xpath("//*[@name='dd']")).sendKeys("20");
		
		System.out.println("STEP - enter birthday year.");
		driver.findElement(By.xpath("//*[@name='yyyy']")).sendKeys("1990");
		
		System.out.println("STEP - enter gender.");
		driver.findElement(By.xpath("//*[@name='freeformGender']")).sendKeys("Male");
		
		System.out.println("STEP - Click Acknowledge.");
		driver.findElement(By.xpath("//*[@name='signup']")).click();
	}
	
	public static void main (String[] args) throws InterruptedException {
		YahooSignUp ysp = new YahooSignUp();
	}

}
