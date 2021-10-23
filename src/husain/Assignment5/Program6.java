/*
 * Test Case 6 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms section and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert
 */
package husain.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Program6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000L);
		System.out.println("STEP - Open Chrome Browser");

		System.out.println("STEP - Click on BasicElements link");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000L);

		System.out.println("STEP - Enter email");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("abc@xyz.com");

		System.out.println("STEP - Enter password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("pass=1234");

		System.out.println("STEP - Click on Submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		System.out.println("STEP - Switch to Alert");
		Alert alert = driver.switchTo().alert();
		String expectedText = "You successfully clicked on it";
		String actualText = alert.getText();
		alert.accept();

		System.out.println("STEP - Validate message displayed on Alert popup");
		if (expectedText.equals(actualText))
			System.out.println("Message is valid");
		else
			System.out.println("Message is incorrect");

	}

}
