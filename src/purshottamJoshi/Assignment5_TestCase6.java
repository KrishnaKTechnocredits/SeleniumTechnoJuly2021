/* Assignment 5 - 17th Oct’2021
http://automationbykrishna.com/#
Test Case 6 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms section and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert  */

package purshottamJoshi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment5_TestCase6 {

	void validateBasicForms() throws InterruptedException {
		
		System.out.println("STEP - Click on basic elements");
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP - Enter valid email");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("joshipurushottam6@gmail.com");
		System.out.println("STEP - Enter password");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("test12345");
		System.out.println("STEP - Click on submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		System.out.println("STEP - Get alert message");
		String alertMessage = driver.switchTo().alert().getText();
		String expectedAlertMessage = "You successfully clicked on it";
		System.out.println("STEP - Validate alert message");
		if(alertMessage.equals(expectedAlertMessage))
			System.out.println("Alert message matched");
		else
			System.out.println("Alert message did not match");
		driver.switchTo().alert().accept();
		
		System.out.println("test case 6 pass");
		driver.close();
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		new Assignment5_TestCase6().validateBasicForms();
	}
}
