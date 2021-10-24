package amrutaM;
/*Assignment - 2 : 16th Oct'2021
Automate Singup : 
http://automationpractice.com/index.php
*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment2_SignUp {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = PredefinedActions.start();
		System.out.println("Step : Navigating to Rgistration page ");
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
	}

	@Test
	public void signUp() {
		System.out.println("Step : Verify Registration text is present or not ");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		String regText = driver.findElement(By.xpath("//div[@id='registration']//h1")).getText();
		String expectedText = "REGISTRATION";
		Assert.assertEquals(regText, expectedText);
		System.out.println("Step : Entering the full name ");
		driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys("Amruta M ");
		System.out.println("Step : Entering the address ");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Nagpur");
		System.out.println("Step : Entering the other email id ");
		driver.findElement(By.xpath("//input[@id='useremail']")).sendKeys("amruta.student@technocredits.com");
		System.out.println("Step : Entering the user city");
		driver.findElement(By.xpath("//input[@id='usercity']")).sendKeys("Nagpur");
		System.out.println("Step : Entering the company name ");
		driver.findElement(By.xpath("//input[@id='organization']")).sendKeys("TECHNOCREDITS");
		System.out.println("Step : Selecting the gender");
		driver.findElement(By.xpath("//input[@id='radio-02']")).click();
		System.out.println("Step : Entering the username ");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("amarkhedkar");
		System.out.println("STEP : Entering the password");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("amruta@123");
		System.out.println("STEP : Re-entering the password");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("amruta@123");
		System.out.println("STEP : Accepting the TERMS & CONDITIONS");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		System.out.println("STEP : Clicking the Sign up button ");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
