package monali.Assignment_5_Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import dattaraj_W.base.PredefinedActions;

/*Test Case 3 - 
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
public class TestCase_3 {

	String alertMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";

	void javaScriptConfirmationAlertOKValidation(String expectedText) throws InterruptedException {
		System.out.println("Step 1: Launch Automation By Krishna Site");
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step 2: Click on Basic Elements tab");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(3000);
		System.out.println("Step 3: To scroll down on page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("Step 4: Click on Java Script confirmation button");
		driver.findElement(By.xpath("//button[text()='Javascript Confirmation']")).click();
		System.out.println("Step 5: Switch to alert window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step 6: Get the text of alert");
		String actualText = alert.getText();
		System.out.println("Step 7: Accept the alert");
		alert.accept();
		System.out.println("Step 8: get the message below confirmation button");
		String messageBelowbutton = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		System.out.println("Step 8 : Validate alert messages");
		if (actualText.equals(alertMessage) && expectedText.equals(messageBelowbutton))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.close();
	}

	void javaScriptConfirmationAlertCancelValidation(String expectedText) throws InterruptedException {
		System.out.println("Step 1: Launch Automation By Krishna Site");
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step 2: Click on Basic Elements tab");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(3000);
		System.out.println("Step 3: To scroll down on page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("Step 4: Click on Java Script confirmation button");
		driver.findElement(By.xpath("//button[text()='Javascript Confirmation']")).click();
		System.out.println("Step 5: Switch to alert window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step 6: Get the text of alert");
		String actualText = alert.getText();
		System.out.println("Step 7: Click on Cancel button on alert window");
		alert.dismiss();
		System.out.println("Step 8: Validate alert message for cancel");
		String messageBelowbutton = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText();
		System.out.println("Step 8 : Validate alert messages");
		if (actualText.equals(alertMessage) && expectedText.equals(messageBelowbutton))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		TestCase_3 tc3 = new TestCase_3();
		tc3.javaScriptConfirmationAlertOKValidation("You pressed OK!");
		tc3.javaScriptConfirmationAlertCancelValidation("You pressed Cancel!");
	}
}
