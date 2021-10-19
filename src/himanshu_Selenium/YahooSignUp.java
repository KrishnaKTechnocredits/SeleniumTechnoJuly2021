package himanshu_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class YahooSignUp {

        void yahooSignupMethod() throws InterruptedException{
		
	    System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    System.out.println("STEP 1: Launch Yahoo Website");
	    driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	    
	    System.out.println("STEP 2: Add Your Name");
	    driver.findElement(By.id("usernamereg-firstName")).sendKeys("Himanshu");
	    
	    System.out.println("STEP 3: Add Your Last Name");
	    driver.findElement(By.id("usernamereg-lastName")).sendKeys("Gupta");
	    
	    System.out.println("STEP 4: Add Your Email-Id");
	    driver.findElement(By.id("usernamereg-yid")).sendKeys("himanshugupta988");
	    
	    System.out.println("STEP 5: Add Your Password");
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Password123");
	    
	    System.out.println("STEP 6: Add Your Number");
	    driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9876512345");
	   
	    System.out.println("STEP 7: Add Your Birth Month");
	    WebElement birthmonthelement = driver.findElement(By.xpath("//select[@name='mm']"));
		Select birthmonthselect = new Select(birthmonthelement);
		birthmonthselect.selectByVisibleText("October");
		
		System.out.println("STEP 8: Add Your Birth Date");
	    driver.findElement(By.id("usernamereg-day")).sendKeys("23");
	    
	    System.out.println("STEP 9: Add Your Birth Year");
	    driver.findElement(By.xpath("//input[@id='usernamereg-year']")).sendKeys("1994");
	    
	    System.out.println("STEP 10: Add Your Gender");
	    driver.findElement(By.xpath("//input[@class='usernamereg-freeformGender']")).sendKeys("Male");
	    
	    driver.close();
	    System.out.println("Result: Yahoo Sign Up Successfull");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		YahooSignUp ass4 = new YahooSignUp();
		ass4.yahooSignupMethod();
		
	}
}
