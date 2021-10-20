/*
 Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms scetion and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert
 */
package umakant.alertAndConfirmation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class TestCase6 {
	
	void verifyAlertInBasicSection(String email, String password) throws InterruptedException {
		String expectedMessage = "You successfully clicked on it";
		System.out.println("Step1: Launch the automationbykrishna in chrome");
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step2: Navigate to Basic Elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Step3:Enetr the Email");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(email);
		System.out.println("Step4:Enetr the Password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(password);
		System.out.println("Step5:Click on Submit");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		System.out.println("Step6: Switch to alert window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step7: Get the message in alert window");
		String actualMessage = alert.getText();
		System.out.println("Step8: Click on OK in alert window");
		alert.accept();
		System.out.println("Step9:Compare the expected and actual message");
		if (actualMessage.equals(expectedMessage))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		new TestCase6().verifyAlertInBasicSection("umakant@abc.com","abcd");
	}
}
