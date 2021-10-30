package monali.Assignment_5_Alerts;
/*Test Case 4 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Prompt button
Enter the name in the alert and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import dattaraj_W.base.PredefinedActions;

public class TestCase_4 {

	void javascriptPromptValidation(String text) throws InterruptedException {
		System.out.println("Step 1: Launch Automation By Krishna Site");
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step 2: Click on Basic Elements tab");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(3000);
		System.out.println("Step 3: To scroll down on page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("Step 4: Click on Java Script Prompt button");
		driver.findElement(By.xpath("//button[text()='Javascript Prompt']")).click();
		System.out.println("Step 5: Switch to alert window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step 6: Enter text in alert box");
		alert.sendKeys(text);
		System.out.println("Step 7: Click on OK button");
		alert.accept();
		System.out.println("Step 8: Get the actual message below JavaScript prompt button");
		String actualMessage=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedMessage="Hello "+text+"! How are you today?";
		System.out.println("Step 8: Validate alert messages");
		if(actualMessage.equals(expectedMessage))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		//Cancel Button validation
		System.out.println("Step 9: Click on Java Script Prompt button");
		driver.findElement(By.xpath("//button[text()='Javascript Prompt']")).click();
		System.out.println("Step 10: Switch to alert window");
		 alert = driver.switchTo().alert();
		System.out.println("Step 11: Enter text in alert box");
		alert.sendKeys(text);
		System.out.println("Step 12: Click on Cancel button");
		alert.dismiss();
		System.out.println("Step 13: Get the message below JavaScript prompt button ");
		String actualCancelMessage=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedCancelMessage="User cancelled the prompttt.";
		if(actualCancelMessage.equals(expectedCancelMessage)) 
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		new TestCase_4().javascriptPromptValidation("Monali");
	}
}
