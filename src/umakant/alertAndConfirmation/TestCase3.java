/*
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
package umakant.alertAndConfirmation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class TestCase3 {
	String alertMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";

	void verifyAcceptConfirmationBoxMessage(String expectedMessage) throws InterruptedException {
		System.out.println("Step1: Launch the automationbykrishna in chrome");
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step2: Navigate to Basic Elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Step3: Click on JavaScript Confirmation");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("Step4: Switch to confirmation window");
		Alert confirmMessage = driver.switchTo().alert();
		System.out.println("Step5: get the confirmation message");
		String actualMessage = confirmMessage.getText();
		System.out.println("Step6: Click on OK in confirmation window");
		confirmMessage.accept();
		System.out.println("Step7: Get the message below the confirmation box");
		String msgBelowConfirmationBox = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Step8: Compare both the messages");
		if (actualMessage.equals(alertMessage) && msgBelowConfirmationBox.equals(expectedMessage))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.close();
	}

	void verifyCancelConfirmationBoxMessage(String expectedMessage) throws InterruptedException {
		System.out.println("Step1: Launch the automationbykrishna in chrome");
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step2: Navigate to Basic Elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Step3: Click on JavaScript Confirmation");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("Step4: Switch to confirmation window");
		Alert confirmMessage = driver.switchTo().alert();
		System.out.println("Step5: get the confirmation message");
		String actualMessage = confirmMessage.getText();
		System.out.println("Step6: Click on Cancel in confirmation window");
		confirmMessage.dismiss();
		System.out.println("Step7: Get the message below the confirmation box");
		String msgBelowConfirmationBox = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Step8: Compare both the messages");
		if (actualMessage.equals(alertMessage) && msgBelowConfirmationBox.equals(expectedMessage))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		TestCase3 test = new TestCase3();
		test.verifyAcceptConfirmationBoxMessage("You pressed OK!");
		test.verifyAcceptConfirmationBoxMessage("You pressed Cancel!");
		test.verifyCancelConfirmationBoxMessage("You pressed OK!");
		test.verifyCancelConfirmationBoxMessage("You pressed Cancel!");
	}

}
