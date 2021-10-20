/*
 Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Prompt button
Enter the name in the alert and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
 */
package umakant.alertAndConfirmation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class TestCase4 {
	void verifyAcceptPromptBoxMessage(String name) throws InterruptedException {
		System.out.println("Step1: Launch the automationbykrishna in chrome");
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step2: Navigate to Basic Elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Step3: Click on JavaScript Prompt");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("Step4: Switch to prompt window");
		Alert prompt = driver.switchTo().alert();
		System.out.println("Step5: Enter the name in prompt");
		prompt.sendKeys(name);
		System.out.println("Step6: Click on OK in prompt window");
		prompt.accept();
		System.out.println("Step7: Get the message below the prompt box");
		String msgBelowConfirmationBox = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedMessage = "Hello " + name + "! How are you today?";
		System.out.println("Step8: Compare both the messages");
		if (msgBelowConfirmationBox.equals(expectedMessage))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.close();
	}

	void verifyCancelPromptBoxMessage(String name) throws InterruptedException {
		System.out.println("Step1: Launch the automationbykrishna in chrome");
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step2: Navigate to Basic Elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Step3: Click on JavaScript Prompt");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("Step4: Switch to prompt window");
		Alert prompt = driver.switchTo().alert();
		System.out.println("Step5: Enter the name in prompt");
		prompt.sendKeys(name);
		System.out.println("Step6: Click on cancel in prompt window");
		prompt.dismiss();
		System.out.println("Step7: Get the message below the prompt box");
		String msgBelowConfirmationBox = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedMessage = "User cancelled the prompt.";
		System.out.println("Step8: Compare both the messages");
		if (msgBelowConfirmationBox.equals(expectedMessage))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		TestCase4 test = new TestCase4();
		test.verifyAcceptPromptBoxMessage("Umakant");
		test.verifyCancelPromptBoxMessage("Umakant");
	}

}
