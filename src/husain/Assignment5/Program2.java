/*
 * Test Case 2 - 

Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert.
 */
package husain.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Program2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000L);
		System.out.println("STEP - Open Chrome Browser");

		System.out.println("STEP - Click on registration link");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000L);
		
		System.out.println("STEP - Click on Alerts button");
		driver.findElement(By.id("javascriptAlert")).click();

		System.out.println("STEP - Switch to Alert");
		Alert alert = driver.switchTo().alert();

		System.out.println("STEP - Valdiate alert message");
		String expectedText = "You must be TechnoCredits student!!";
		String actualText = alert.getText();
		alert.accept();
		if (expectedText.equals(actualText))
			System.out.println("Message is valid");
		else
			System.out.println("Message is incorrect");
	}

}
