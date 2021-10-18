/*
 * Test Case 4 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Prompt button
Enter the name in the alert and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.

 */
package husain.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Program4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000L);
		System.out.println("STEP - Open Chrome Browser");

		System.out.println("STEP - Click on BasicElements link");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000L);

		System.out.println("STEP - Click on JavaScript Prompt button");
		driver.findElement(By.id("javascriptPromp")).click();

		System.out.println("STEP - Switch to Alert");
		Alert alert = driver.switchTo().alert();
		String name = "Sean";

		System.out.println("STEP - Enter name in alert textbox and click on OK");
		alert.sendKeys(name);
		alert.accept();

		String expectedText = "Hello " + name + "! How are you today?";
		String actualText = driver.findElement(By.id("pgraphdemo")).getText();

		System.out.println("STEP - Validate mesage below Javascript Prompt button");
		if (expectedText.equals(actualText))
			System.out.println("Message is valid");
		else
			System.out.println("Message is incorrect");

	}

}
