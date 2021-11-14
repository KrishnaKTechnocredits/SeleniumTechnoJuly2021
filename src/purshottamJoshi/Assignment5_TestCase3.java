/* Assignment 5 - 17th Oct 2021
http://automationbykrishna.com/#
Test Case 3 - 
Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Confirmation button
Validate the alert message and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
Click on Javascript Confirmation button
Dismiss the alert.
Validate the confirmation message displayed below the Javascript Confirmation button. */
package purshottamJoshi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.PredefinedActions;


public class Assignment5_TestCase3 {
	

	
	
	void validateJavacScriptConfirmation() throws InterruptedException {
		
		System.out.println("STEP- Click on basic elements");
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP- Click on Javascript Confirmation Button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("STEP- Get alert message");
		String expectedAlertMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("STEP- Validating alert message");
		if(alertMessage.equals(expectedAlertMessage))
			System.out.println("Alert message match");
		else
			System.out.println("Alert message does not match");
		System.out.println("STEP- Press okay");
		driver.switchTo().alert().accept();
		System.out.println("STEP- Validating confirmation message");
		String expectedConfirmationMessage = "You pressed OK!";
		String confirmationMessage = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		if(confirmationMessage.equals(expectedConfirmationMessage))
			System.out.println("Confirmation message match");
		else
			System.out.println("Confirmation message not match");
		
		//Dismiss alert
		System.out.println("STEP- Click on Javascript Confirmation");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("STEP- Validating alert message");
		if(alertMessage.equals(expectedAlertMessage))
			System.out.println("Alert message matched");
		else
			System.out.println("Alert message does not match");
		System.out.println("STEP- Click on cancel button");
		driver.switchTo().alert().dismiss();
		System.out.println("STEP- Validating confirmation message");
		String expectedConfirmationMessage2 = "You pressed Cancel!";
		String confirmationMessage2 = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText();
		if(confirmationMessage2.equals(expectedConfirmationMessage2))
			System.out.println("Confirmation message matched");
		else
			System.out.println("Confirmation message did not matched");
		
		System.out.println("test case 3 pass");
		driver.close();
		
	}


	public static void main(String[] args) throws InterruptedException {
		
		new Assignment5_TestCase3().validateJavacScriptConfirmation();
	}

}
