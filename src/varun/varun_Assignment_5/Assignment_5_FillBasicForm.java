package varun.varun_Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment_5_FillBasicForm {
	
	WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");

	void fillBasicForm() {
		System.out.println("Enter the email ID");
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("varunj@gmail.com");
		System.out.println("Enter the password");
		driver.findElement(By.id("pwd")).sendKeys("test1234");
		System.out.println("Click on submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		alert.accept();
		if (actual.equalsIgnoreCase("You successfully clicked on it"))
			System.out.println("Submit button verification pass");
		else
			System.out.println("Submit button verification failed");
		driver.close();
		System.out.println("STEP-Test Case PASSED");
	}
}
