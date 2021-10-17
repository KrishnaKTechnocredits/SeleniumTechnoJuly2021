package technocredits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignUpTest {
	
	void facebookSignup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP - Enter facebook url");
		driver.get("https://www.facebook.com");
		
		System.out.println("STEP - click on create account button");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP - Enter firstname");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("techno");
		
		System.out.println("STEP - Enter lastname");
		driver.findElement(By.name("lastname")).sendKeys("credits");
		
		System.out.println("STEP - Enter email");
		driver.findElement(By.name("reg_email__")).sendKeys("kanani.maulik@gmail.com");
		
		System.out.println("STEP - REenter email id");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("kanani.maulik@gmail.com");
		
		System.out.println("STEP - Enter password");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Pwd123@123");
		
		System.out.println("STEP - Enter Date of birth");
		WebElement birthDayelement = driver.findElement(By.xpath("//select[@title='Day']"));
		Select birthDaySelect = new Select(birthDayelement);
		birthDaySelect.selectByVisibleText("13");
		
		driver.close();
		System.out.println("Test passed successfully");
	}
	
	public static void main(String[] args) throws InterruptedException {
		new FacebookSignUpTest().facebookSignup();
	}
}
