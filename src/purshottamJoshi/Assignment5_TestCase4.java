/* Assignment 5 - 17th Oct’2021
http://automationbykrishna.com/#
Test Case 4 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Prompt button
Enter the name in the alert and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button. */


package purshottamJoshi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment5_TestCase4 {

	void validateJavacScriptPromt() throws InterruptedException {
		
		System.out.println("STEP - Click on basic elements");
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);

		// Accept alert
		System.out.println("STEP - Click on Javascript Prompt button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("STEP - Enter name in alert box");
		String name = "Purshottam";
		driver.switchTo().alert().sendKeys(name);
		System.out.println("STEP - Click on okay button");
		driver.switchTo().alert().accept();
		System.out.println("STEP - Validate confirmation message in case of okay");
		String expectedConfirmationMessage = "Hello " + name + "! How are you today?";
		String confirmationMessage = driver.findElement(By.xpath("//p[contains(text(), 'Hello')]")).getText();
		if(confirmationMessage.equals(expectedConfirmationMessage))
			System.out.println("Confirmation message matched");
		else
			System.out.println("Confirmation message did not matched");

		//Dismiss alert
		System.out.println("STEP - Click on Javascript Prompt button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("STEP - Click on cancel button");
		driver.switchTo().alert().dismiss();
		System.out.println("STEP - Validating confirmation message in case of cancel");
		String expectedConfirmationMessage2 = "User cancelled the prompt.";
		String confirmationMessage2 = driver.findElement(By.xpath("//p[contains(text(), 'User')]")).getText();
		if(confirmationMessage2.equals(expectedConfirmationMessage2))
			System.out.println("Confirmation message matched");
		else
			System.out.println("Confirmation message did not matched");

		System.out.println("test case 4 pass");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		
		new Assignment5_TestCase4().validateJavacScriptPromt();
	}
}
