/*
Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert.

 */
package umakant.alertAndConfirmation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class TestCase2 {

	void getAlertMessage(String expectedMessage) throws InterruptedException {
		System.out.println("Step1: Launch the automationbykrishna in chrome");
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step2: Navigate to Basic Elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Step3: Click on Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		System.out.println("Step4: Switch to alert window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step5: get the alert message");
		String actualMessage = alert.getText();
		System.out.println("Step6: Click on OK in alert window");
		alert.accept();
		System.out.println("Step7: Compare the messages");
		if (actualMessage.equals(expectedMessage))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		TestCase2 test = new TestCase2();
		test.getAlertMessage("You must be TechnoCredits student!!");
		test.getAlertMessage("TechnoCredits student!!");
	}

}
