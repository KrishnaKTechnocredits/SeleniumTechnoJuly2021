/*
 * Test Case 3 - 

Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Confirmation button
Validate the alert message and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
Click on Javascript Confirmation button
Dismiss the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.

 */
package husain.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Program3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000L);
		System.out.println("STEP - Open Chrome Browser");

		System.out.println("STEP - Click on BasicElements link");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000L);

		System.out.println("STEP - Click on JavaScript Confirmation button");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		System.out.println("STEP - Switch to Alert");
		Alert alert = driver.switchTo().alert();

		System.out.println("STEP - Validate alert message for OK");
		String expectedText = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String actualText = alert.getText();
		alert.accept();
		if (expectedText.equals(actualText))
			System.out.println("Alert text for OK is valid");
		else
			System.out.println("Alert text for OK is incorrect");

		System.out.println("STEP - Validate message for OK below Javascript confirmation button");
		String okMsgExpected = "You pressed OK!";
		String okMsgActual = driver.findElement(By.id("pgraphdemo")).getText();
		if (okMsgExpected.equals(okMsgActual))
			System.out.println("Message for OK is valid");
		else
			System.out.println("Message for OK is incorrect");

		System.out.println("STEP - Click on JavaScript Confirmation button");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		System.out.println("STEP - Switch to Alert");
		alert = driver.switchTo().alert();

		System.out.println("STEP - Validate message for Cancel below Javascript confirmation button");
		alert.dismiss();
		String cancelMsgExpected = "You pressed Cancel!";
		String cancelMsgActual = driver.findElement(By.id("pgraphdemo")).getText();
		if (cancelMsgExpected.equals(cancelMsgActual))
			System.out.println("Message for Cancel is valid");
		else
			System.out.println("Message for Cancel is incorrect");

	}

}
