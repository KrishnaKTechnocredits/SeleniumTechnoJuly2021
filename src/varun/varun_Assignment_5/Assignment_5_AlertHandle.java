package varun.varun_Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment_5_AlertHandle {
	WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");
	@Test
	void testCase1() throws InterruptedException {
		System.out.println("STEP - Click on Registration menu");
		driver.findElement(By.linkText("Registration")).click();
		System.out.println("User landded on registration page");
		Thread.sleep(3000);
		System.out.println("Enter Username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Varun");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Joshi45678");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("Please handle the alert");
		Alert alert = driver.switchTo().alert();
		String successText = alert.getText();
		alert.accept();

		if (successText.equals("Success!"))
			System.out.println("Test Case passed");
		else
			System.out.println("Test Case Failed. Please handle alert carefully");
	}
	
	void negativeTestScenario() throws InterruptedException {
		System.out.println("STEP - Click on Registration menu");
		driver.findElement(By.linkText("Registration")).click();
		System.out.println("User landded on registration page");
		Thread.sleep(3000);
		System.out.println("Enter Username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Varun");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Josh");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		System.out.println("Please handle the alert");
		Alert alert = driver.switchTo().alert();
		String successText = alert.getText();
		alert.dismiss();

		if (successText.equals("Failed! please enter strong password"))
			System.out.println("Negative Test Case passed");
		else
			System.out.println("Test Case Failed. Please handle alert carefully");
	}	
	
	public static void main(String[] args) throws InterruptedException {

		Assignment_5_AlertHandle alert_PopUp_Assignment = new Assignment_5_AlertHandle();
		alert_PopUp_Assignment.testCase1();
		alert_PopUp_Assignment.negativeTestScenario();
	}
}
