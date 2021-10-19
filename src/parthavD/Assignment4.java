/*Assignment 4: 16th Oct'2021
Yahoo Signup.
https://login.yahoo.com/account/create?specId=yidReg*/

package parthavD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import base.PredefinedActions;

public class Assignment4 {

	public void yahooSignUp() throws InterruptedException {
		System.out.println("Step-1 Launch Yahoo URL");
		WebDriver driver = PredefinedActions.start("https://www.yahoo.com/");
		System.out.println("Step-2 Click on Sign In");
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		Thread.sleep(2000);
		System.out.println("Step-3 Click on Create Account");
		driver.findElement(By.xpath("//a[@id='createacc']")).click();
		Thread.sleep(2000);
		System.out.println("Step-4 Add First & Last Name");
		driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys("User FirstName");
		driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys("User LastName");
		System.out.println("Step-5 Add Email ID");
		driver.findElement(By.xpath("//input[@id='usernamereg-yid']")).sendKeys("W234jd");
		System.out.println("Step-6 Enter password");
		driver.findElement(By.xpath("//input[@id='usernamereg-password']")).sendKeys("Password@123");
		System.out.println("Step-7 Add mobile phone number");
		driver.findElement(By.xpath("//input[@id='usernamereg-phone']")).sendKeys("8874567123");
		System.out.println("Step-8 Add Birth Month");
		Select selectBirth = new Select(driver.findElement(By.xpath("//select[@id='usernamereg-month']")));
		selectBirth.selectByVisibleText("April");
		System.out.println("Step-9 Add Birth Month");
		driver.findElement(By.xpath("//input[@id='usernamereg-day']")).sendKeys("24");
		System.out.println("Step-10 Add Birth Year");
		driver.findElement(By.xpath("//input[@id='usernamereg-year']")).sendKeys("1990");
		driver.findElement(By.name("freeformGender")).sendKeys("Male");
		System.out.println("Test Completed successfully");
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment4().yahooSignUp();

	}

}
