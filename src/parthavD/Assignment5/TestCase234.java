/*Test Case 2 - Test case 4

Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert.*/

package parthavD.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class TestCase234 {

	void testBasicElements() throws InterruptedException{
	
		System.out.println("Step1 - Launch Automation by Krishna Webpage");
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step2 - Navigate to Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Step3 - Verify Basic Alert");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Alert']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Step4 - Verify Alert text");
		String messageText = alert.getText();
		alert.accept();
		if (messageText.equals("You must be TechnoCredits student!!"))
			System.out.println("The basic alert works fine");
		else
			System.out.println("The basic alert doesn't work well");
			
		System.out.println("Step5 - Verify JavaScript Confirmation alert");
		
		driver.findElement(By.xpath("//button[text()='Javascript Confirmation']")).click();
		alert = driver.switchTo().alert();
		messageText = alert.getText();
		System.out.println("Step6 - Verify Javascript confirmation text");
		if (messageText.equals("Are you are doing your homework regularly, Press Okay else Cancel!!"))
			System.out.println("The Javascript confirmation text is fine");
		else
			System.out.println("The Javascript confirmation text doesn't match");
		System.out.println("Step7 - Verify OK button scenario");
		alert.accept();
		messageText = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		if (messageText.equals("You pressed OK!"))
			System.out.println("The OK button scenario passed");
		else
			System.out.println("The OK button scenario failed");
		driver.findElement(By.xpath("//button[text()='Javascript Confirmation']")).click();
		alert = driver.switchTo().alert();
		System.out.println("Step9 - Verify Cancel button scenario");
		alert.dismiss();
		messageText = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText();
		if (messageText.equals("You pressed Cancel!"))
			System.out.println("The Cancel button scenario passed");
		else
			System.out.println("The Cancel button scenario failed");
		
		System.out.println("Step10 - Verify JavaScript Prompt");
		System.out.println("Step11 - Click on JavaScript Prompt");				
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Thread.sleep(2000);
		alert = driver.switchTo().alert();
		messageText = alert.getText();
		System.out.println("Step12 - Verify default text displayed on JavaScript Prompt");				
		if (messageText.equals("Please enter your name :"))
			System.out.println("The Javascript prompt text message is displayed correctly");
		else	
			System.out.println("The Javascript prompt text message is not displayed correctly");
		System.out.println("Step13 - Verify OK Button scenario on JavaScript Prompt");				
		String alertMessageName = "John Jack";
		System.out.println("Step14 - Add name text in JavaScript Prompt and click OK button");	
		alert.sendKeys("John Jack");
		alert.accept();
		System.out.println("Step15 - Verify text displayed in UI after click of OK button");	
		messageText = driver.findElement(By.xpath("//p[text()='Hello John Jack! How are you today?']")).getText();
		String expectedText = "Hello " + alertMessageName + "! How are you today?";
		if (messageText.equals(expectedText))
			System.out.println("OK Button scenario passed");
		else	
			System.out.println("OK Button scenario failed");
		System.out.println("Step16 - Verify Cancel Button scenario on JavaScript Prompt");				
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Thread.sleep(2000);
		alert = driver.switchTo().alert();
		messageText = alert.getText();
		System.out.println("Step17 - Add name text in JavaScript Prompt and click Cancel button");	
		alert.sendKeys("John Jack");
		alert.dismiss();
		System.out.println("Step18 - Verify text displayed in UI after click of Cancel button");	
		expectedText = "User cancelled the prompt.";
		messageText = driver.findElement(By.xpath("//p[text()='User cancelled the prompt.']")).getText();
		if(messageText.equals(expectedText))
			System.out.println("Cancel Button scenario passed");
		else
			System.out.println("Cancel Button scenario failed");		
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new TestCase234().testBasicElements();

	}

}
