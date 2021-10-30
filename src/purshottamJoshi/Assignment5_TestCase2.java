/* Assignment 5 - 17th Oct 2021
http://automationbykrishna.com/#
Test Case 2 - 
Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert. */

package purshottamJoshi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment5_TestCase2 {
	
	void basicElement() throws InterruptedException {
		System.out.println("STEP- Click on basic elements");
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP- Click Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		System.out.println("STEP- Get alert message");
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("STEP- Validate alert message");
		if(alertMessage.equals("You must be TechnoCredits student!!"))
			driver.switchTo().alert().accept();
		else
			System.out.println("Alert message does not match");
		
		System.out.println("test case 2 pass");
		
		
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		
		new Assignment5_TestCase2().basicElement();
	}

}
